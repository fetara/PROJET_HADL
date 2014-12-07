package org.hadl.m1.rpc;

import org.hadl.m2.entities.roles.Role;

public class Called extends Role{

	public Called(String name) {
		super(name);
	}

	public void receiveRequest(Object msg) {
		System.out.println("Called : Message dans role " + this.name);
		setChanged();
		notifyObservers(msg);
	}
}
