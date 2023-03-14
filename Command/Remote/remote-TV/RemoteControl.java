/*
 * Pre-Command DP, a "RemoteControl" object will invoke actions 
 * directly on a "Television" object
 *
 */

public class RemoteControl {

    private Television tv;

    public RemoteControl() {
	System.out.println("We have found the remote!");
    }
    public void setTV(Television tv) {
	this.tv = tv;
    }
    public void TelevisionChannelDown() {
	tv.channelDown();
    }
    public void TelevisionChannelUp() {
	tv.channelUp();
    }
    public void TelevisionOff() {
	tv.off();
    }
    public void TelevisionOn() {
	tv.on();
    }
    public void TelevisionSetChannel(int channel) {
	tv.setChannel(channel);
    }
}

