package server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Tilbud extends UnicastRemoteObject implements Serializable {
	
	public Tilbud() throws Exception {
		// TODO Auto-generated constructor stub
	}
	
	String koreskole_id;
	int pris;
	String korekort_type;
	int lynkursus;
	String bilmarke;
	String bilstørrelse;
	String køn;
	String beskrivelse;
	TilgængeligeDage tilgængeligeDage;	


}
