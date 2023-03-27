public class Television {
    int channel = 0; // default is channel 0

    public Television() {
	System.out.println("New TV arrives from shop");
    }
    
    public void on() {
	System.out.println("Television -> ON");
	System.out.println("Television channel: " + channel);
    }
    public void off() {
	System.out.println("Television -> OFF");
    }
    public void channelUp() {
	channel++;
	System.out.println("Television channel: " + channel);
    }
    public void channelDown() {
	channel--;
	System.out.println("Television channel: " + channel);
    }
    public void setChannel(int chanNum) {
	channel = chanNum;
	System.out.println("Set television channel to: " + channel);
    }
}
