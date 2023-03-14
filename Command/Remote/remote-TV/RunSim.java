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
	 * Rewrite to use the Command DP,
	 *   invoker  = remote
	 *   receiver = tv 
	 * with ConcreteCommands for
	 *   switchOn, switchOff, channelUp, channelDown, setChannel
	 *
	 * Remember, you can only interact with the receiver ("tv") 
	 * by using Command & invoker ("remote").
	 * You are NOT allowed to invoke methods directly on Television
	 *
	 */

	// ensure remote is controlling the TV
	remote.setTV(tv);
	
	// turn tv on
	remote.TelevisionOn();


	// play with tv channels
	remote.TelevisionChannelUp();
	remote.TelevisionChannelUp();
	remote.TelevisionChannelUp();

	remote.TelevisionSetChannel(205);
	
	remote.TelevisionChannelDown();
	remote.TelevisionChannelDown();
	remote.TelevisionChannelDown();

	// turn tv off
	remote.TelevisionOff();
    }
}
