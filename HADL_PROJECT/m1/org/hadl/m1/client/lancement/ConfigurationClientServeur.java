package org.hadl.m1.client.lancement;

import java.util.List;
import java.util.Observable;

import org.hadl.m1.client.port.SendRequestP;
import org.hadl.m1.link.A1;
import org.hadl.m1.link.A2;
import org.hadl.m1.rpc.G;
import org.hadl.m1.rpc.RPC;
import org.hadl.m2.entities.component.Component;
import org.hadl.m2.entities.component.Configuration;
import org.hadl.m2.entities.connector.Connector;
import org.hadl.m2.entities.link.Attachement;
import org.hadl.m2.entities.link.Link;
import org.hadl.m2.entities.ports.Port;
import org.hadl.m2.lancement.Message;

public class ConfigurationClientServeur extends Configuration {
	private Client c1;
	private Serveur s1;
	private RPC rpc;
	private A1 a1;
	private A2 a2;

	public ConfigurationClientServeur(String name,
			List<Component> listeComposants, List<Link> listeLinks,
			List<Connector> listeConnectors) {
		super(name, listeComposants, listeLinks, listeConnectors,null);

		c1 = new Client("client 1 ", this);
		s1 = new Serveur(name, listeComposants, listeLinks, listeConnectors,this);
		rpc = new RPC("connecteur 1", this);
		a1 = new A1(name, c1.getSendRequestPort(), rpc.getCaller(), this);
		a2 = new A2(name, s1.getReceiveRequestP(), rpc.getCalled(), this);

		this.addLink(a1);
		this.addLink(a2);
		this.addComposant(c1);
		this.addConfiguration(s1);

	}

	public Client getC1() {
		return c1;
	}

	public RPC getRpc() {
		return rpc;
	}

	public void setRpc(RPC rpc) {
		this.rpc = rpc;
	}

	public void setC1(Client c1) {
		this.c1 = c1;
	}

	public Serveur getS1() {
		return s1;
	}

	public void setS1(Serveur s1) {
		this.s1 = s1;
	}

	/**
	 * Transfer the data to a role or port
	 * 
	 * @param observable
	 * @param object
	 */
	public void transfertData(Observable observable, Object object) {
		for (Link link : listeLinks) {
			//System.out.println(observable);
			if (link instanceof Attachement
					&& ((Attachement) link).getFromComponent().equals(
						observable)
					){
				System.out.println("Configuration : Transfert de données ");
				((Attachement) link).getToConnector().receiveData(
						(Message) object);
			} else if (link instanceof Attachement
					&& ((Attachement) link).getToConnector().equals(observable)) {
				System.out.println("Configuration : Transfert de données");
				((Attachement) link).getFromComponent().receiveData(
						(Message) object);
			}
		}
	}

}
