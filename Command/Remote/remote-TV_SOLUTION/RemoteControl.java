/*
 * A "RemoteControl" object will be the "invoker" of the Command DP
 *
 */

public class RemoteControl {

    private Command command;

    public RemoteControl() {
	System.out.println("We have found the remote!");
    }

    public void setCommand(Command command) {
	this.command = command;
    }

    public void action() {
	command.execute();
    }
}
	
