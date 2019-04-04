package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	Connector c;
	Connection con;
	
	public JDBC() {
        this.c = new Connector();
        this.con = c.getConnection();
	}
	
	public void opretkøreskole(Køreskole køreskole) {
		
		/*
		
		try {
			c.doUpdate("INSERT INTO koreskoler(koreskole_id, koreskolenavn, adresse, postnummer, telefonnummer, mail) values ('"
					+køreskole.id+"', '"+køreskole.navn+"', '"+køreskole.adresse+"', "+køreskole.postnummer+", "+køreskole.telefonnummer+", '"+køreskole.mail+"');");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		*/
		
		//-----------------prepared statement---------------------------_//
		
		String s = "INSERT INTO koreskoler(koreskole_id, koreskolenavn, adresse, postnummer, telefonnummer, mail) values (?, ?, ?, ?, ?, ?);";
		int updated = 0;
		try {
			PreparedStatement p = con.prepareStatement(s);
			p.setString(1, køreskole.id);
			p.setString(2, køreskole.navn);
			p.setString(3, køreskole.adresse);
			p.setInt(4, køreskole.postnummer);
			p.setInt(5, køreskole.telefonnummer);
			p.setString(6, køreskole.mail);
			
			updated = p.executeUpdate();
						
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			System.out.println(updated+" record(s) updated");
		}
		
		//"INSERT INTO koreskoler(koreskole_id, koreskolenavn, adresse, postnummer, telefonnummer, mail) values ('s165477', 'bjarnes koreskole', 'hurtigvej 234', 4000, 88888888, 'testest@mail.dk');"

		
		
		
	}
	
	
}
