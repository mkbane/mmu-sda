class RunSim {
    /*
     * RunSim: main method to test use of RemoteControl
     *
     * RemoteControl (remote) can be used to turn on and off 
     * Television (tv), increment & decrement the channel, 
     * and set the channel number
     *
     */

    public static void main(String[] args) {
	// handle to remote, tv
	RemoteControl remote = new RemoteControl();
	Television tv = new Television();

	/*
	 * In terms of the Command DP,
	 *   invoker  = remote
	 *   receiver = tv 
	 * and we have ConcreteCommands for
	 *   switchOn, switchOff, channelUp, channelDown, setChannel
	 *
	 * Remember, we can only interact with the receiver ("tv") 
	 * by using Command & invoker ("remote").
	 * We are note allowed to invoke methods directly on Television
	 *
	 */

	// turn tv on
	remote.setCommand(new TelevisionOnCommand(tv));
	remote.action();

	// play with tv channels
	remote.setCommand(new TelevisionChannelUpCommand(tv));
	remote.action();
	remote.action();
	remote.action();

	remote.setCommand(new TelevisionSetChannelCommand(tv,205));
	remote.action();
	
	remote.setCommand(new TelevisionChannelDownCommand(tv));
	remote.action();
	remote.action();

	// we can also set various ConcreteCommands to use directly with remote
	Command TVdown = new TelevisionChannelDownCommand(tv);
	Command TVup = new TelevisionChannelUpCommand(tv);
	Command setFavChannel = new TelevisionSetChannelCommand(tv,107);
	remote.setCommand(TVdown);
	remote.action();
	remote.action();
	remote.setCommand(TVup);
	remote.action();
	remote.setCommand(setFavChannel);
	remote.action();

	// turn tv off
	remote.setCommand(new TelevisionOffCommand(tv));
	remote.action();

    }
}
