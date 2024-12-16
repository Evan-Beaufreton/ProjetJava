package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO<T> {
    public Connection connect;
    private Statement st;

    // Constructeur
    public DAO() {
        open();
    }

    // Méthodes abstraites
    //public abstract T create(T obj); // Corrigé le nom et la signature
    //public abstract T update(T obj); // Utilisation correcte de T
   // public abstract void delete(T obj);

    // Méthode pour ouvrir la connexion
    public void open() {
        try {
            connect = SingleConnection.getInstance(); // Appel Singleton
            st = connect.createStatement();
            System.out.println("Connexion ouverte dans DAO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthode pour fermer la connexion
    public void close() {
        try {
            if (st != null) st.close();
            if (connect != null && !connect.isClosed()) {
                connect.close();
                System.out.println("Connexion fermée dans DAO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
