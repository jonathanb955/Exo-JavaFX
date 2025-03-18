package database;

import java.sql.Connection;

import static database.Database.getConnexion;

public class Application {


    public static void main(String[] args) {
        Connection cnx = getConnexion();
        if (cnx != null) {
            System.out.println("Connexion établie avec succès !");
        } else {
            System.out.println("Échec de la connexion à la base de données.");
        }
    }
}