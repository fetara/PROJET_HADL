package org.hadl.m1.rpc;

import org.hadl.m2.entities.roles.Glue;
import org.hadl.m2.entities.roles.Role;

public class Caller extends Role{

	public Caller(String name) {
		super(name);
		}

	public void receiveData(Object msg) {
		System.out.println("Caller : Message dans role " + this.name);
		for (Glue glue : this.getGlues()) {
			if (glue instanceof G) {
				((G) glue).receiveRequest(msg);
			}
		}
	}
}
