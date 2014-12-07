package org.hadl.m1serveur.connecteur;

import org.hadl.m1.rpc.Called;
import org.hadl.m2.entities.roles.Glue;
import org.hadl.m2.entities.roles.Role;
import org.hadl.m2.lancement.Message;

public class G1 extends Glue{

	public G1(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void receiveRequest(Object msg) {
		System.out.println("Glue : Message Dans Glue " + this.name);
		for (Role role : this.getRoles()) {
			if (role instanceof Called) {
				((Called) role).receiveRequest((Message) msg);
			}
		}
	}


}
