/*
 * ConcreteCommand for Television
 */

public class TelevisionChannelDownCommand implements Command {
    Television tv;
    public TelevisionChannelDownCommand(Television tv) {
	this.tv = tv;
    }
    public void execute() {
	tv.channelDown();
    }
}

