package org.hadl.m2.entities.ports;

import java.util.ArrayList;
import java.util.Observable;

import javax.security.auth.login.Configuration;

public abstract class Port extends Observable {

	protected String name;
	private ArrayList tabObservateur;
	private Configuration conf;

	public Port(String name) {
		super();
		this.name = name;
		tabObservateur = new ArrayList();
	}

	public void addPort() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void receiveData(Object msg) {
		System.out.println("->>>>Données recu port<<<<<-");
	}

}