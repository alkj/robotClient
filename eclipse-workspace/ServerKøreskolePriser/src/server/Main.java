package server;

import java.rmi.Naming;
import java.sql.Connection;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws Exception {
		
		java.rmi.registry.LocateRegistry.createRegistry(1235); // start i server-JVM                
        KøreskolePriserImplementering ki = new KøreskolePriserImplementering(); 
        Naming.rebind("rmi://localhost:1235/koereskolepriser", ki);
        System.out.println("serveren er startet");
        
        
        JDBC j = new JDBC();
        Køreskole k = new Køreskole();
        k.id="s165479";
        k.navn="peter";
        k.adresse="tingstedvej";
        k.mail="mail@mail.dk";
        k.postnummer=4000;
        k.telefonnummer=88898876;
        
        j.usekoreskoleDatabase();
        
        j.opretkøreskole(k);
        
        Køreskole ks = j.getKøreskole("s165478");
        
        System.out.println(ks.toString());
        
        
        
 		
	}

}
