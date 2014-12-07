package org.hadl.m2.entities.link;

import org.hadl.m2.entities.component.Configuration;
import org.hadl.m2.entities.ports.Port;
import org.hadl.m2.entities.roles.Role;

public class Attachement extends Link {


	private Role toConnector;
	private Port  fromComponent;
	
	public Attachement(String name, Port fromComponent, Role toConnector,Configuration conf) {
		super(name, conf);
		//controle sur port fournis a role requis
		//controle sur port requis a role fournis
		
		this.fromComponent = fromComponent;
		this.toConnector = toConnector;
		
	}
	
	public Attachement(String name,Role toConnector, Port fromComponent, Configuration conf) {
		super(name,conf);
		this.fromComponent = fromComponent;
		this.toConnector = toConnector;
	}

	public Role getToConnector() {
		return toConnector;
	}

	public void setToConnector(Role toConnector) {
		this.toConnector = toConnector;
	}

	public Port getFromComponent() {
		return fromComponent;
	}

	public void setFromComponent(Port fromComponent) {
		this.fromComponent = fromComponent;
	}

}