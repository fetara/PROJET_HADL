package org.hadl.m1.rpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hadl.m1.client.lancement.ConfigurationClientServeur;
import org.hadl.m2.entities.connector.ConnectorSimple;
import org.hadl.m2.entities.roles.Glue;
import org.hadl.m2.entities.roles.Role;
import org.hadl.m2.lancement.Message;

public class RPC extends ConnectorSimple implements Observer {

	private static List<Role> listRoleFournis;
	private static List<Role> listRoleRequis;
	private Caller caller;
	private Called called;
	private G glue;

	public RPC(String name, ConfigurationClientServeur conf) {
		
		super(name, listRoleFournis, listRoleRequis, conf);
		
		listRoleFournis = new ArrayList<>();
		listRoleRequis = new ArrayList<>();
		
		called = new Called("Called");
		caller = new Caller("Caller");
		
		glue = new G("Glue");
		
		called.addObserver(this);
		
		glue.addRole(called);
		glue.addRole(caller);
		
		this.addRoleFournis(called);
		listRoleFournis.add(called);
		
		this.addRoleRequis(caller);
		listRoleRequis.add(caller);
		
		this.addGlue(glue);
		this.listGlues.add(glue);
		

		
	}

	public Caller getCaller() {
		return caller;
	}

	public void setCaller(Caller caller) {
		this.caller = caller;
	}

	public Called getCalled() {
		return called;
	}

	public void setCalled(Called called) {
		this.called = called;
	}

	public Glue getGlue() {
		return glue;
	}

	public void setGlue(G glue) {
		this.glue = glue;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println(" ----- RPC notifications ----- ");
		if (observable instanceof Called) {
			((ConfigurationClientServeur) this.conf).transfertData(observable,
					(Message) object);
		} 

	}

}
