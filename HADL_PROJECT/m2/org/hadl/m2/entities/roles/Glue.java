package org.hadl.m2.entities.roles;

import java.util.ArrayList;
import java.util.List;


public class Glue {
	protected String name;
	private List<Role> roles;
	
	
	public Glue(String name) {
		super();
		this.name = name;
		this.roles = new ArrayList<Role>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void addRole(Role role) {
		roles.add(role);
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}