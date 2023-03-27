/*
 * ConcreteCommand for Television
 */

public class TelevisionSetChannelCommand implements Command {
    Television tv;
    int channel;
    public TelevisionSetChannelCommand(Television tv, int channel) {
	this.tv = tv;
	this.channel = channel;
    }
    public void execute() {
	tv.setChannel(channel);
    }
}

