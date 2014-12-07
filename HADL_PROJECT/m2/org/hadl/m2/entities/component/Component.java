package org.hadl.m2.entities.component;

import java.util.ArrayList;
import java.util.List;

import org.hadl.m2.entities.ports.Port;
import org.hadl.m2.entities.ports.RequisPort;
import org.hadl.m2.entities.services.Service;

public abstract class Component {
	String name = "";
	protected Configuration conf;

	protected List<Service> listServiceFournis;
	protected List<Service> listServiceRequis ;
	protected List<Port> listPortRequis ;
	protected List<Port> listPortFournis;

	public Component(String name, Configuration conf) {

		this.name = name;
		this.conf = conf;
		listServiceFournis= new ArrayList<>();
		listServiceRequis = new ArrayList<>();
		listPortRequis = new ArrayList<>();
		listPortFournis =  new ArrayList<>();
	}

	public void addPortFournis(Port port) {
		listPortFournis.add(port);
	}

	public void addPortRequis(RequisPort port) {

		listPortRequis.add(port);
	}

	public void addServiceRequis(Service service) {

		listServiceRequis.add(service);
	}

	public void addServiceFournis(Service service) {

		listServiceFournis.add((Service)service);
	}

	public List<Service> getListServiceFournis() {
		return listServiceFournis;
	}

	public void setListServiceFournis(List<Service> listServiceFournis) {
		this.listServiceFournis = listServiceFournis;
	}

	public List<Service> getListServiceRequis() {
		return listServiceRequis;
	}

	public void setListServiceRequis(List<Service> listServiceRequis) {
		this.listServiceRequis = listServiceRequis;
	}

	public List<Port> getListPortRequis() {
		return listPortRequis;
	}

	public void setListPortRequis(List<Port> listPortRequis) {
		this.listPortRequis = listPortRequis;
	}

	public List<Port> getListPortFournis() {
		return listPortFournis;
	}

	public void setListPortFournis(List<Port> listPortFournis) {
		this.listPortFournis = listPortFournis;
	}

}