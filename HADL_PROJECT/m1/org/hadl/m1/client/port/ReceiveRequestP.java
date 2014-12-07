package org.hadl.m1.client.port;

import org.hadl.m2.entities.ports.Port;

public class ReceiveRequestP extends Port{

	public ReceiveRequestP(String name) {
		super(name);
	}

	public void receiveData(Object msg) {
		System.out.println("Port : ReceiveRequestP " + this.name);
		setChanged();
		notifyObservers(msg);
	}


}
