package org.hadl.m1.link;

import org.hadl.m1.client.port.SendRequestP;
import org.hadl.m1.rpc.Caller;
import org.hadl.m2.entities.component.Configuration;
import org.hadl.m2.entities.link.Attachement;
import org.hadl.m2.entities.ports.Port;
import org.hadl.m2.entities.roles.Role;

public class A1 extends Attachement{
	
	public A1(String name, SendRequestP fromComponent, Caller toConnector, Configuration conf) {
		super(name, fromComponent, toConnector,conf );

	}

	
}
