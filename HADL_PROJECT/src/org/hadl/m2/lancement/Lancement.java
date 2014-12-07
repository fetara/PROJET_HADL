package org.hadl.m2.lancement;

import java.util.ArrayList;
import java.util.List;

import org.hadl.m1.client.lancement.Client;
import org.hadl.m1.client.lancement.ConfigurationClientServeur;
import org.hadl.m1.client.port.SendRequestP;
import org.hadl.m2.entities.component.Component;
import org.hadl.m2.entities.component.ComponentSimple;
import org.hadl.m2.entities.component.Configuration;
import org.hadl.m2.entities.connector.Connector;
import org.hadl.m2.entities.connector.ConnectorSimple;
import org.hadl.m2.entities.link.Attachement;
import org.hadl.m2.entities.link.Link;
import org.hadl.m2.entities.ports.FournisPort;
import org.hadl.m2.entities.ports.Port;
import org.hadl.m2.entities.ports.RequisPort;
import org.hadl.m2.entities.roles.FournisRole;
import org.hadl.m2.entities.roles.RequisRole;
import org.hadl.m2.entities.roles.Role;

public class Lancement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration config = null;
		Component cp1 = new ComponentSimple("cp1", config);
		Component cp2 = new ComponentSimple("cp2",config);

		ConnectorSimple cn1 = new ConnectorSimple();

		Port pR = new RequisPort("port requis");
		FournisPort pF = new FournisPort("port fournis");

		List<Port> listportRequis = new ArrayList<>();
		listportRequis.add((RequisPort) pR);
		((ComponentSimple) cp2).setListPortRequis(listportRequis);

		List<Port> listportFournis = new ArrayList<>();
		listportFournis.add((FournisPort) pF);
		((ComponentSimple) cp1).setListPortFournis(listportFournis);

		Role rR = new RequisRole("role requis");
		Role rF = new FournisRole("role fournis");

		List<Role> listroleRequis = new ArrayList<>();
		listroleRequis.add((RequisRole) rR);
		cn1.setListRoleRequis(listroleRequis);

		List<Role> listroleFournis = new ArrayList<>();
		listroleFournis.add((FournisRole) rF);
		cn1.setListRoleFournis(listroleFournis);
		Link attachement1 = null;
		Link attachement2 = null;
		cn1 = new ConnectorSimple("connector simple", listroleFournis,
				listroleRequis,config);
		for(int i=0;i<cn1.getListRoleRequis().size() ;i++){
		attachement1 = new Attachement("lien1", ((ComponentSimple) cp1).getListPortFournis()
				.get(i), cn1.getListRoleRequis().get(i),config);
		attachement2 = new Attachement("lien2", cn1.getListRoleFournis()
				.get(i), ((ComponentSimple) cp2).getListPortRequis().get(i),config);
		}
		List<Component> listC = new ArrayList<>();
		listC.add((ComponentSimple) cp1);
		listC.add((ComponentSimple) cp2);

		List<Connector> listConnc = new ArrayList<>();
		listConnc.add(cn1);

		List<Link> listLink = new ArrayList<>();
		listLink.add((Attachement) attachement1);
		listLink.add((Attachement) attachement2);

		//config = new Configuration("Configuration", listC,
		//		listLink, listConnc,null);
//------------------------------------------------------------------------------------//

		System.out.println("-------------------------------------------");
		ConfigurationClientServeur conf = new ConfigurationClientServeur("client serveur",listC,
				listLink, listConnc);
		Message message = new Message("SELECT * from client",null);
		conf.getC1().getSendRequestService().sendRequest(message);
	
		
		

	}

}
