package org.hadl.m2.entities.roles;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.hadl.m2.interfaceM2.Interface;

public abstract class Role extends Observable implements Interface {

	protected String name ;
	private List<Glue> glues;

	public Role(String name) {
		super();
		this.name = name;
		this.glues = new ArrayList<>();
	}
	public List<Glue> getGlues() {
		return glues;
	}

	public void setGlues(List<Glue> glues) {
		this.glues = glues;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void receiveData(Object msg) {
		System.out.println("Role : Message recu dans role "+this.name);
	}
	
	public void addRole(Glue g){
		glues.add(g);
	}
}