#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double lm=2.0, gm=0.3, k=0.00001;

// prototypes of helper functions
int init(double*, double*, double*, double*, double*, double*, double*, double*, double*, double*, int);
double calc_system_energy(double, double*, double*, double*, int);
void _a(double*, double*, double*, double*, double*, double*, double*, double*, int);
void calcCentre_Mass(double*, double*, double*, double*, double*, double, int);
double t2();

int main(int argc, char* argv[]) {
  int i, j;
  int a;     // user defined (argv[1]) total number of gas molecules in simulation
  int k1, ts; // for time stepping, including user defined (argv[2]) number of timesteps to integrate
  int rc;      // return code
  double *M, *x, *y, *z, *vx, *vy, *vz;  // 1D array for mass, (x,y,z) position, (vx, vy, vz) velocity
  double dx, dy, dz, d, F, GRAVCONST=0.001, b=300;
  double ax, ay, az;
  double *gas, *liquid, *loss_rate;       // 1D array for each particle's component that will evaporate
  double *o1, *o2, *o3, *om;            // save previous values whilst doing global updates
  double totalMass, E;  // for stats

  double t1 = t2();

  /* if avail, input size of system */
  if (argc > 1 ) {
    a = atoi(argv[1]);
    ts = atoi(argv[2]);
  }
  else {
    a = 20000;
    ts = 250;
  }

  printf("Initializing for %d particles in x,y,z space...", a);

  /* malloc arrays and pass ref to init(). NOTE: init() uses random numbers */
  M = (double *) malloc(a * sizeof(double));
  x =  (double *) malloc(a * sizeof(double));
  y =  (double *) malloc(a * sizeof(double));
  z =  (double *) malloc(a * sizeof(double));
  vx = (double *) malloc(a * sizeof(double));
  vy = (double *) malloc(a * sizeof(double));
  vz = (double *) malloc(a * sizeof(double));
  gas = (double *) malloc(a * sizeof(double));
  liquid = (double *) malloc(a * sizeof(double));
  loss_rate = (double *) malloc(a * sizeof(double));
  o1 = (double *) malloc(a * sizeof(double));
  o2 = (double *) malloc(a * sizeof(double));
  o3 = (double *) malloc(a * sizeof(double));
  om = (double *) malloc(a * sizeof(double));

  // should check all rc but let's just see if last malloc worked
  if (om == NULL) {
    printf("\n ERROR in malloc for (at least) old_mass - aborting\n");
    return -99;
  } 
  else {
    printf("  (malloc-ed)  ");
  }

  // initialise
  rc = init(M, x, y, z, vx, vy, vz, gas, liquid, loss_rate, a);
  if (rc != 0) {
    printf("\n ERROR during init() - aborting\n");
    return -99;
  }
  else {
    printf("  INIT COMPLETE\n");
  }
  totalMass = 0.0;
  for (i=0; i<a; i++) {
    M[i] = gas[i]*gm + liquid[i]*lm;
    totalMass += M[i];
  }
  E = calc_system_energy(totalMass, vx, vy, vz, a);
  printf("Time 0. System energy=%g\n", E);


  /* 
     MAIN TIME STEPPING LOOP

     We 'save' old (entry to timestep loop) values to use on RHS of:

     For each aerosol particle we will: calc forces due to other
     particles & update change in velocity and thus position; then we
     condense some of the gas to liquid which changes the mass of the
     particle so we then determine its new velocity via conservation
     of kinetic energy.

     Having looped over the particles (using 'old' values on the right
     hand side as a crude approximation to real life) we then have
     updated all particles independently. 

     We then determine the total mass & the system energy of the
     system. 

     The final statement of each time-stepping loop is to decrease the
     temperature of the system.

     After completing all time-steps, we output the the time taken and
     the centre of mass of the final system configuration.

  */


  printf("Now to integrate for %d timesteps\n", ts);

  // time=0 was initial conditions
  for (k1=1; k1<=ts; k1++) {

    // LOOP1: take snapshot to use on RHS when looping for updates
    for (i=0; i<a; i++) {
      o1[i] = x[i];
      o2[i] = y[i];
      o3[i] = z[i];
      om[i] = M[i];
    }

    double temp_d, temp_z;

    // LOOP2: update position etc per particle (based on old data)
    for(i=0; i<a; i++) {
      // calc forces on body i due to particles (j != i)
      for (j=0; j<a; j++) {
        if (j != i) {
          dx = o1[j] - x[i];
          dy = o2[j] - y[i];
	  dz = o3[j] - z[i];
          temp_d =sqrt(dx*dx + dy*dy + dz*dz);
          d = temp_d>0.01 ? temp_d : 0.01;
          F = GRAVCONST * M[i] * om[j] / (d*d);
	  // calculate acceleration due to the force, F
          ax = (F/M[i]) * dx/d;
          ay = (F/M[i]) * dy/d;
	  az = (F/M[i]) * dz/d;
	  // approximate velocities in "unit time"
          vx[i] += ax;
          vy[i] += ay;
	  vz[i] += az;
        }
      } 
      // calc new position 
      x[i] = o1[i] + vx[i];
      y[i] = o2[i] + vy[i];
      z[i] = o3[i] + vz[i];
      // temp-dependent condensation from gas to liquid
      gas[i] *= loss_rate[i] * exp(-k*b);
      liquid[i] = 1.0 - gas[i];
      M[i] = gas[i]*gm + liquid[i]*lm;
      // conserve energy systems 0.5*m*v*v remains constant
      double v_squared = vx[i]*vx[i] + vy[i]*vy[i] + vz[i]*vz[i];
      double factor = sqrt(om[i]*v_squared/M[i])/sqrt(v_squared);
      vx[i] *= factor;
      vy[i] *= factor;
      vz[i] *= factor;
    } // end of LOOP 2
    _a(x,y,z, vx,vy,vz, gas, liquid, a);
    totalMass = 0.0;
    for (i=0; i<a; i++) {
      totalMass += M[i];
    }
    E = calc_system_energy(totalMass, vx, vy, vz, a);
    printf("At end of timestep %d with temp %f the system energy=%g and total aerosol mass=%g\n", k1, b, E, totalMass);
    // temperature drops per timestep
    b *= 0.99999;
  } // time steps

  printf("Time to init+solve %d molecules for %d timesteps is %g seconds\n", a, ts, t2()-t1);
  // output a metric (centre of mass) for checking
  double com[3];
  calcCentre_Mass(com, x,y,z,M,totalMass,a);
  printf("Centre of mass = (%g,%g,%g)\n", com[0], com[1], com[2]);
} // main


int init(double *mass, double *x, double *y, double *z, double *vx, double *vy, double *vz, double *gas, double* liquid, double* loss_rate, int a) {
  // random numbers to set initial conditions - do not parallelise or amend order of random number usage
  int i;
  double comp;
  double min_pos = -50.0, mult = +100.0, maxVel = +10.0;
  double recip = 1.0 / (double)RAND_MAX;

  for (i=0; i<a; i++) {
    x[i] = min_pos + mult*(double)rand() * recip;  
    y[i] = min_pos + mult*(double)rand() * recip;  
    z[i] = 0.0 + mult*(double)rand() * recip;   
    vx[i] = -maxVel + 2.0*maxVel*(double)rand() * recip;   
    vy[i] = -maxVel + 2.0*maxVel*(double)rand() * recip;   
    vz[i] = -maxVel + 2.0*maxVel*(double)rand() * recip;   
    // proportion of aerosol that evaporates
    comp = .5 + (double)rand()*recip/2.0;
    loss_rate[i] = 1.0 - (double)rand()*recip/25.0;
    // aerosol is component of gas and (1-comp) of liquid
    gas[i] = comp;
    liquid[i] = (1.0-comp);
  }
  return 0;
} // init


double calc_system_energy(double M, double *vx, double *vy, double *vz, int n) {
  int i;
  double totalEnergy = 0.0, E;
  for (i=0; i<n; i++) {
    totalEnergy += vx[i]*vx[i] + vy[i]*vy[i] + vz[i]*vz[i];
  }
  totalEnergy = 0.5 * M * totalEnergy;
  E = totalEnergy / (double) n;
  return E;
}


void _a(double *x, double *y, double *z, double *vx, double *vy, double *vz, double *gas, double *liquid, int n) {
  int i;
  printf("num \t position (x,y,z) \t velocity (vx, vy, vz) \t mass (gas, liquid)\n");
  for (i=0; i<n; i++) {
    printf("%d \t %f %f %f \t %f %f %f \t %f %f\n", i, x[i], y[i], z[i], vx[i], vy[i], vz[i], gas[i]*gm, liquid[i]*lm);
  }
}


void calcCentre_Mass(double *com, double *x, double *y, double *z, double *mass, double totalMass, int N) {
  int i, axis;
   // calculate the centre of mass, com(x,y,z)
  for (axis=0; axis<2; axis++) {
    com[0] = 0.0;     com[1] = 0.0;     com[2] = 0.0; 
    for (i=0; i<N; i++) {
      com[0] += mass[i]*x[i];
      com[1] += mass[i]*y[i];
      com[2] += mass[i]*z[i];
    }
    com[0] /= totalMass;
    com[1] /= totalMass;
    com[2] /= totalMass;
  }
  return;
}


#include <sys/time.h>
double t2 () {
  struct timeval wallTime;
  gettimeofday(&wallTime, NULL);
  double c = wallTime.tv_sec;
  double a = wallTime.tv_usec;
  return c + a*1.0E-06;
}
