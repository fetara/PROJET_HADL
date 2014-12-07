package org.hadl.m1.rpc;

import org.hadl.m2.entities.roles.Glue;
import org.hadl.m2.entities.roles.Role;
import org.hadl.m2.lancement.Message;

public class G extends Glue{

	public G(String name) {
		super(name);
	}
	public void receiveRequest(Object msg) {
		System.out.println("Glue G : Message est arriver au glue " + this.name);
		for (Role role : this.getRoles()) {
			if (role instanceof Called) {
				((Called) role).receiveRequest((Message) msg);
				
			}else if (role instanceof Caller) {
				System.out.println("Glue G : Message est arriver au glue " + this.name);
				
			}
		}
	}


}
