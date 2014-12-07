package org.hadl.m2.entities.link;


import org.hadl.m2.entities.component.Configuration;
import org.hadl.m2.entities.ports.Port;

public class Binding extends Link {

	private Port portConfiguration;
	private Port portComponent;
	
		
	public Binding(String name, Port portConfiguration, Port portComponent, Configuration conf) {
		super(name,conf);
		this.portConfiguration = portConfiguration;
		this.portComponent = portComponent;
	}
	public Port getPortConfiguration() {
		return portConfiguration;
	}
	public void setPortConfiguration(Port portConfiguration) {
		this.portConfiguration = portConfiguration;
	}
	public Port getPortComponent() {
		return portComponent;
	}
	public void setPortComponent(Port portComponent) {
		this.portComponent = portComponent;
	}
    

}