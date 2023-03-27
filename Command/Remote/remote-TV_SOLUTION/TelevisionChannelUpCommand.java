/*
 * ConcreteCommand for Television
 */

public class TelevisionChannelUpCommand implements Command {
    Television tv;
    public TelevisionChannelUpCommand(Television tv) {
	this.tv = tv;
    }
    public void execute() {
	tv.channelUp();
    }
}

