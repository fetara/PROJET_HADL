package org.hadl.m1.link;

import org.hadl.m1.client.port.SendRequestP;
import org.hadl.m1.rpc.Called;
import org.hadl.m1.rpc.Caller;
import org.hadl.m1.serveur.port.ReceiveRequestP;
import org.hadl.m2.entities.component.Configuration;
import org.hadl.m2.entities.link.Attachement;
import org.hadl.m2.entities.ports.Port;
import org.hadl.m2.entities.roles.Role;

public class A2 extends Attachement{

	public A2(String name, ReceiveRequestP fromComponent, Called toConnector, Configuration conf) {
		super(name, fromComponent, toConnector, conf);

	}
	public A2(String name, SendRequestP fromComponent, Called toConnector, Configuration conf) {
		super(name, fromComponent, toConnector, conf);

	}

	
}
