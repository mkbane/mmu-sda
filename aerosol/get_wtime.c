/*
 * function to return double representing number of wall clock
 * seconds since some arbitrary point in time
 * mkbane (2023)
 * TO DO: update to clock_gettime 
 */
#include <stddef.h>
#include <sys/time.h>
double get_wtime () {
  struct timeval wallTime;
  gettimeofday(&wallTime, NULL);
  double seconds = wallTime.tv_sec;
  double microsecs = wallTime.tv_usec;
  return seconds + microsecs*1.0E-06;
}
