enum RES {LOW, MED, HIGH}

public class AppControl {
    // member variables controlling resolution and device
    RES resolution;
    DEV device;

    // constructors
    AppControl() {
	System.out.println("AppControl starts...\n");
    }

    
    public void doPrint() {
	switch (resolution) {
	case LOW:
	    System.out.println("processing a LOW res PRINT\n");
	    break;
	case MED:
	    System.out.println("processing a MEDium res PRINT\n");
	    break;
	case HIGH:
	    System.out.println("processing a HIGH res PRINT\n");
	}
    }

    public void doDisplay() {
	switch (resolution) {
	case LOW:
	    System.out.println("processing a LOW res DISPLAY\n");
	    break;
	case MED:
	    System.out.println("processing a MEDium res DISPLAY\n");
	    break;
	case HIGH:
	    System.out.println("processing a HIGH res DISPLAY\n");
	}
    }
} // AppControl
