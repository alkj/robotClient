package server;

import java.util.ArrayList;

public class Køreskole {
	String id;
	String navn;
	String adresse;
	int postnummer;
	int telefonnummer;
	String mail;
	
	public Køreskole() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		String s = "";
		
		s+="id=";
		s+= id;

		s+="\nnavn=";
		s+=navn;
		
		s+="\nadresse=";
		s+=adresse;
		
		s+="\npostnummer=";
		s+=postnummer;
		
		s+="\ntelefonnummer=";
		s+=telefonnummer;

		s+="\nmail=";
		s+=mail;

		
		return s;
	}
	
	

}
