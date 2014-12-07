package org.hadl.m1.client.lancement;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hadl.m1.client.port.SendRequestP;
import org.hadl.m1.client.service.SendRequestS;
import org.hadl.m1.serveur.port.ReceiveRequestP;
import org.hadl.m1.serveur.service.ReceiveRequestS;
import org.hadl.m2.entities.component.Component;
import org.hadl.m2.entities.component.Configuration;
import org.hadl.m2.entities.connector.Connector;
import org.hadl.m2.entities.link.Link;
import org.hadl.m2.entities.ports.Port;
import org.hadl.m2.entities.services.Service;

/**
 * 
 * @author arafet ajouter les rolle caller called pour les connector Simple dans
 *         M1Serveur
 */
public class Serveur extends Configuration implements Observer {

	// serveur component
	private Port receiveRequestP;
	private Port sendRequestPort;
	private Service receiveRequestS;
	private Service sendRequestS;
	private ReceiveRequestP receiveResponseP;
	


	public Serveur(String name, List<Component> listeComposants,
			List<Link> listeLinks, List<Connector> listeConnectors,ConfigurationClientServeur conf) {
		super(name, listeComposants, listeLinks, listeConnectors,conf);
		
		// Instantiation
		this.receiveRequestP = new ReceiveRequestP("ReceiveRequestP");
		this.sendRequestPort = new SendRequestP("SendRequestP2");
		this.receiveRequestS = new ReceiveRequestS("ReceiveRequestS",null);
		this.sendRequestS = new SendRequestS("SendRequestS2",null);
		this.receiveResponseP = new ReceiveRequestP("ReceiveResponseP");


		// Server equoute receiveRequestP
		receiveRequestP.addObserver(this);
		sendRequestPort.addObserver(this);
		receiveResponseP.addObserver(this);
		
		//ajout des ports et service
		this.addPortFournis(sendRequestPort);
		this.addPortRequis(receiveRequestP);
		this.addServiceRequis(receiveRequestS);
		this.addServiceFournis(sendRequestS);
		this.receiveRequestS.addPort(receiveRequestP);
		this.sendRequestS.addPort(sendRequestPort);

	}

	
	public ReceiveRequestP getReceiveRequestP() {
		ReceiveRequestP p = null;
		for (Port port : requisPorts) {
			if (port instanceof ReceiveRequestP) {
				p = (ReceiveRequestP) port;
			}
		}
		return p;
	}


	public void setReceiveRequestP(Port receiveRequestP) {
		this.receiveRequestP = receiveRequestP;
	}

	public Port getSentRequestP() {
		return sendRequestPort;
	}

	public void setSentRequestP(Port sentRequestP) {
		this.sendRequestPort = sentRequestP;
	}

	public Service getReceiveRequestS() {
		return receiveRequestS;
	}

	public void setReceiveRequestS(Service receiveRequestS) {
		this.receiveRequestS = receiveRequestS;
	}

	public SendRequestS getSendRequestS2() {
		return (SendRequestS) sendRequestS;
	}

	public void setSendRequestS2(SendRequestS sendRequestS2) {
		this.sendRequestS = sendRequestS2;
	}

	public ReceiveRequestP getReceiveResponseP() {
		return receiveResponseP;
	}

	public void setReceiveResponseP(ReceiveRequestP receiveResponseP) {
		this.receiveResponseP = receiveResponseP;
	}
	@Override
	public void update(Observable observable, Object object) {
		System.out.println("----- Serveur notification -----");
		if (observable instanceof ReceiveRequestP) {
			this.getSendRequestS2().sendRequest(object);
		} else if (observable instanceof SendRequestP) {
			((ConfigurationClientServeur) this.conf).transfertData(observable, object);
		} else if (observable instanceof ReceiveRequestP) {
			((ConfigurationClientServeur) this.conf).transfertData(observable,
					object);
		}
	}

}
