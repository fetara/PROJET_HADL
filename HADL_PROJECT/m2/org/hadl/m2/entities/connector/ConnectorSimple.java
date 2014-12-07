package org.hadl.m2.entities.connector;

import java.util.ArrayList;
import java.util.List;

import org.hadl.m2.entities.component.Configuration;
import org.hadl.m2.entities.roles.*;

public class ConnectorSimple implements Connector {

	public String name = "";

	public List<Role> listRoleFournis ;
	public List<Role> listRoleRequis;
	public List<Glue> listGlues;
	protected Configuration conf;

	public ConnectorSimple() {
		super();
	}

	public ConnectorSimple(String name, List<Role> listRoleFournis,
			List<Role> listRoleRequis, Configuration conf) {
		super();
		this.name = name;
		listRoleFournis =new ArrayList<>();
		listRoleRequis = new ArrayList<>();
		listGlues = new ArrayList<>();
		this.listRoleFournis = listRoleFournis;
		this.listRoleRequis = listRoleRequis;
		this.conf = conf;
	}

	public ConnectorSimple(String name, List<Role> listRoleFournis,
			List<Role> listRoleRequis, List<Glue> listGlues) {
		super();
		this.name = name;
		this.listRoleFournis = listRoleFournis;
		this.listRoleRequis = listRoleRequis;
		this.listGlues = listGlues;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getListRoleFournis() {
		return listRoleFournis;
	}

	public void setListRoleFournis(List<Role> listRoleFournis) {
		this.listRoleFournis = listRoleFournis;
	}

	public List<Role> getListRoleRequis() {
		return listRoleRequis;
	}

	public void setListRoleRequis(List<Role> listRoleRequis) {
		this.listRoleRequis = listRoleRequis;
	}

	public List<Glue> getListGlues() {
		return listGlues;
	}

	public void setListGlues(List<Glue> listGlues) {
		this.listGlues = listGlues;
	}

	public void addRoleRequis(Role role) {
		this.listRoleRequis.add(role);
	}

	public void addRoleFournis(Role role) {
		this.listRoleFournis.add(role);
	}

	public void addGlue(Glue g) {
		this.listGlues.add(g);

	}

}