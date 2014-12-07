package org.hadl.m1.client.lancement;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hadl.m1.client.port.SendRequestP;
import org.hadl.m1.client.service.SendRequestS;
import org.hadl.m1.serveur.port.ReceiveRequestP;
import org.hadl.m2.entities.component.Component;
import org.hadl.m2.entities.ports.FournisPort;
import org.hadl.m2.entities.ports.Port;
import org.hadl.m2.lancement.Message;

/**
 * 
 * @author arafet&greg ajout du port recieve qui permet de receptionner la
 *         requet
 * 
 */
public class Client extends Component implements Observer {
	// TODO : ajout du port recieve qui permet de receptionner la requet
	private SendRequestP sendRequestPort;
	private SendRequestS sendRequestService;
	private ReceiveRequestP receiveRequestPort;

	public Client(String nom, ConfigurationClientServeur conf) {
		super(nom, conf);
		List<Port> listPortFournis = new ArrayList<>();
		sendRequestPort = new SendRequestP("send request port");
		receiveRequestPort = new ReceiveRequestP("receive request port");
		sendRequestService = new SendRequestS("send request service",
				listPortFournis);

		sendRequestPort.addObserver(this);
		receiveRequestPort.addObserver(this);

		addPortFournis(sendRequestPort);
		addServiceFournis(sendRequestService);
		addPortRequis(receiveRequestPort);
		sendRequestService.addPort(sendRequestPort);

	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println(" ------------ Client ----------- ");
		if (observable instanceof SendRequestP) {
			System.out
					.println("Client : envoy le message au Port Send Request");
			((ConfigurationClientServeur) this.conf).transfertData(observable,
					(Message) object);
		} else if (observable instanceof ReceiveRequestP) {
			System.out.println("------------ Reponse client ------------");

		}
	}

	public SendRequestP getSendRequestPort() {
		return sendRequestPort;
	}

	public void setSendRequestPort(SendRequestP sendRequestPort) {
		this.sendRequestPort = sendRequestPort;
	}

	public SendRequestS getSendRequestService() {
		return sendRequestService;
	}

	public void setSendRequestService(SendRequestS sendRequestService) {
		this.sendRequestService = sendRequestService;
	}

	public ReceiveRequestP getReceiveRequestPort() {
		return receiveRequestPort;
	}

	public void setReceiveRequestPort(ReceiveRequestP receiveRequestPort) {
		this.receiveRequestPort = receiveRequestPort;
	}

}
