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

	public void usekoreskoleDatabase() {
		try {
			String s = "use koreskole";
			PreparedStatement p = con.prepareStatement(s);
			p.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void opretkøreskole(Køreskole køreskole) {


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

	}

	public Køreskole getKøreskole(String id) {
		String s = "SELECT * FROM koreskoler where koreskole_id = ?;";
		ResultSet rs = null;
		Køreskole k = new Køreskole();
		try {
			PreparedStatement p = con.prepareStatement(s);
			p.setString(1, id);
			rs = p.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			while(rs.next()) {
				k.id = rs.getString(1);
				k.navn = rs.getString(2);
				k.adresse = rs.getString(3);
				k.postnummer = rs.getInt(4);
				k.telefonnummer = rs.getInt(5);
				k.mail = rs.getString(6);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		return k;

	}
	
	public void opretTilbud(Tilbud t) {
		String s = "INSERT INTO tilbud(koreskole_id, pris, korekort_type, lynkursus, bilmarke, bilstorrelse, kon, tilgangelige_dage, beskrivelse) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int i = 0;
		//		+ "values('s165477', 9500, 'b', 0, 'andet', 'mellem', 'kvinde', 1110000, 'jeg er en frisk fyr')";
		try {
			PreparedStatement p = con.prepareStatement(s);
			p.setString(1, t.koreskole_id);
			p.setInt(2, t.pris);
			p.setString(3, t.korekort_type);
			p.setInt(4, t.lynkursus);
			p.setString(5, t.bilmarke);
			p.setString(6, t.bilstørrelse);
			p.setString(7, t.køn);
			p.setInt(8, t.tilgængelige_dage);
			p.setString(9, t.beskrivelse);
			
			i=p.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("update(s) " + i);
		
	}

}
