package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SingleConnection {

	static private Connection Connect;
	
	private SingleConnection() {
			try {
				// CHANGER LE PORT ET LE NOM DE LA BASE44
				this.Connect = DriverManager.getConnection( "jdbc:mysql://localhost:3306/absences?serverTimezone=UTC", "root", "root");
				Statement stat = Connect.createStatement();
				System.out.println("Connexion reussie !");
			} catch (SQLException e) {
				System.err.println("Erreur d'etablissement de connexion");
				e.printStackTrace();
			}
		
	}
	
	static public Connection getInstance() {
		if (Connect == null) {
			new SingleConnection();
			return Connect;
		} else {
			return Connect;
		}
	} 

	static public void close(Connection conn) {
		try {
			conn.close();
			System.out.println("Connexion fermee !");
		} catch (SQLException e) {
			System.out.println("Erreur de connection");
			e.printStackTrace();
		}
	}
	
}
