package org.hadl.m2.entities.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hadl.m2.entities.connector.Connector;
import org.hadl.m2.entities.connector.ConnectorSimple;
import org.hadl.m2.entities.link.Link;
import org.hadl.m2.entities.ports.Port;
import org.hadl.m2.entities.roles.Role;
import org.hadl.m2.entities.services.Service;

/**
 * 
 * @author arafet&greg Composant composite classe observer
 */
public class Configuration extends Component{

	protected List<Component> listeComposants;
	protected List<Link> listeLinks;
	protected List<Connector> listeConnectors;
	protected List<Configuration> listConfigurations;
	
	protected List<Port> fournisPorts;
	protected List<Port> requisPorts;
	protected List<Service> fournisServices;
	protected List<Service> requisServices;
	protected List<Role> fournisRole;
	protected List<Role> requisRole;
	
	protected Configuration conf;
	private String name = "";

	public Configuration(String name, List<Component> listeComposants,
			List<Link> listeLinks, List<Connector> listeConnectors,
			Configuration conf) {
		super(name,conf);
	// chaque configuration posséde ou pas une
							// configuration
		listeComposants = new ArrayList<>();
		listeLinks = new ArrayList<>();
		listeConnectors = new ArrayList<>();
		
		fournisRole = new ArrayList<Role>();
		requisRole = new ArrayList<Role>();
		fournisPorts = new ArrayList<Port>();
		requisPorts = new ArrayList<Port>();
		fournisServices = new ArrayList<Service>();
		requisServices = new ArrayList<Service>();

		listConfigurations = new ArrayList<>();
		this.listeComposants = listeComposants;
		this.listeLinks = listeLinks;
		this.listeConnectors = listeConnectors;

		this.name = name;

	}

	public void addRoleFournis(Role role) {
		fournisRole.add(role);
	}
	public void addRoleRequis(Role role) {
		requisRole.add(role);
	}
	public void addPortFournis(Port port) {
		fournisPorts.add(port);
	}
	public void addPortRequis(Port port) {
		requisPorts.add(port);
	}
	public void addServiceFournis(Service service) {
		fournisServices.add(service);
	}
	public void addServiceRequis(Service service) {
		requisServices.add(service);
	}
	
	public void addLink(Link link) {
		listeLinks.add(link);
	}

	public void addConnector(ConnectorSimple connector) {
		listeConnectors.add(connector);
	}

	public void addComposant(Component composant) {
		listeComposants.add(composant);
	}

	public void addConfiguration(Configuration conf) {
		listConfigurations.add(conf);
	}

	public List<Component> getListeComposants() {
		return listeComposants;
	}

	public void setListeComposants(List<Component> listeComposants) {
		this.listeComposants = listeComposants;
	}

	public List<Link> getListeLinks() {
		return listeLinks;
	}

	public void setListeLinks(List<Link> listeLinks) {
		this.listeLinks = listeLinks;
	}

	public List<Connector> getListeConnectors() {
		return listeConnectors;
	}

	public void setListeConnectors(List<Connector> listeConnectors) {
		this.listeConnectors = listeConnectors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}