package org.hadl.m2.entities.services;

import java.util.ArrayList;
import java.util.List;

import org.hadl.m2.entities.ports.Port;
import org.hadl.m2.interfaceM2.Interface;

public abstract class Service implements Interface {

	protected String name;
	public List<Port> listPort;


	public Service(String name, List<Port> listPort) {
		super();
		this.name = name;
		this.listPort = new ArrayList<>();
	}

	public List<Port> getListPort() {
		return listPort;
	}

	public void setListPort(List<Port> listPort) {
		this.listPort = listPort;
	}

	public void addPort(Port port) {
		listPort.add(port);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}