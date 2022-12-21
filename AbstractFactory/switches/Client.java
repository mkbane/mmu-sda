import java.util.Scanner;
enum DEV {PRINTER, DISPLAY}
public class Client {

    
    public static void main(String[] args) {
	System.out.printf("Client starts...\n");
	// instanitate AppControl object 'ac'
	AppControl ac = new AppControl();

	// determine choice of resolution and device
	Scanner keyboard = new Scanner(System.in);
	System.out.printf("Enter resolution (LOW, MID or HIGH): ");
	//resolution = validateResolution(keyboard);
	ac.resolution = RES.MED;
	System.out.printf("\t%s\n", ac.resolution);
	
	System.out.printf("Enter device (LOW, MID or HIGH): ");
	//device = validateDevice(keyboard);
	DEV device = DEV.DISPLAY;
	System.out.printf("\t%s\n", device);

	// call method for relevant device
	switch (device) {
	case PRINTER:
	    ac.doPrint();
	case DISPLAY:
	    ac.doDisplay();
	}
	System.out.println("\n\t ...AppControl exits\n");
    } // main
} // Client
