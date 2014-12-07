package org.hadl.m1.client.port;

import org.hadl.m2.entities.ports.Port;

public class SendRequestP extends Port{

	public SendRequestP(String name) {
		super(name);
		}
	
	public void receiveRequest(Object msg) {
		System.out.println("SendRequestPort : Meassage est arriver au port "+this.getName());
		setChanged();
		notifyObservers(msg);
	}

	

}
