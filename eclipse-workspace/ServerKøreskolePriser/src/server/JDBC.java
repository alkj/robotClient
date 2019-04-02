package server;

import java.sql.Connection;
import java.sql.ResultSet;

public class JDBC {
	Connector c;
	Connection con;
	
	public JDBC() {
        this.c = new Connector();
        this.con = c.getConnection();
	}
	
	public void opretkøreskole(Køreskole køreskole) {
		
		try {
			
			c.doUpdate("INSERT INTO koreskoler(koreskole_id, koreskolenavn, adresse, postnummer, telefonnummer, mail) values ('"
					+køreskole.id+"', '"+køreskole.navn+"', '"+køreskole.adresse+"', "+køreskole.postnummer+", "+køreskole.telefonnummer+", '"+køreskole.mail+"');");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		INSERT INTO koreskoler(koreskole_id, koreskolenavn, adresse, postnummer, telefonnummer, mail) values
//		('s165477', 'bjarnes koreskole', 'hurtigvej 234', 4000, 88888888, 'testest@mail.dk');

		
		
		
	}
	
	
}
