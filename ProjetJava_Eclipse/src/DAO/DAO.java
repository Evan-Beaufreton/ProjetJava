package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO <T>{

	protected Connection connect;
	protected Statement stmt;
	
	public abstract T create(Object T);
	
	public abstract T update(Object T);
	
	public abstract void delete(Object T);
	
	public void open() {
		connect = SingleConnection.getInstance();
		try {
			stmt = connect.createStatement();
		} catch (SQLException e) {
			System.out.println("Erreur de Statement");
			e.printStackTrace();
		}
	}
	
	public void close() {
		SingleConnection.close(connect);
	}
}
