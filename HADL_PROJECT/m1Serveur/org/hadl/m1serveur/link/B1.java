package org.hadl.m1serveur.link;

import org.hadl.m1.client.lancement.ConfigurationClientServeur;
import org.hadl.m1.serveur.port.ReceiveRequestP;
import org.hadl.m1serveur.port.ExternalSocket;
import org.hadl.m2.entities.link.Binding;
/**
 * 
 * @author arafet
 * Lier le composant avec la configuration
 */
public class B1 extends Binding{

	public B1(String name, ReceiveRequestP portConfiguration, ExternalSocket portComponent,ConfigurationClientServeur conf) {
		super(name, portConfiguration, portComponent, conf);
		
	}

	

}
