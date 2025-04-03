package repository;

import java.sql.*;

import database.Database;
import model.Utilisateur;
import java.util.ArrayList;



public class UtilisateurRepository {
    private Connection connexion;

    public UtilisateurRepository() {
        this.connexion = Database.getConnexion();
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateurs (nom, prenom, email, mdp) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMdp());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }

    }


    public Utilisateur getUtilisateurParEmail(String email) {
        String sql = "SELECT * FROM utilisateurs WHERE email = ?";
        Utilisateur utilisateur = null;

        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String mdp = rs.getString("mdp");

                utilisateur = new Utilisateur(nom, prenom, email, mdp);
            }
        } catch (SQLException e) {
            System.out.println("Erreur! Utilisateur non trouvé: " + e.getMessage());
        }
        return utilisateur;
    }



    public ArrayList<Utilisateur> getTousLesUtilisateurs() {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs";
        int idUtilisateur = 0;
        String nom = "";
        String prenom = "";
        String email = "";
        String mdp = "";
        String role = "";

        Utilisateur utilisateur = null;

        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            System.out.println("Utilisateur trouvé avec succès !");

            idUtilisateur = rs.getInt("idUtilisateur");
            System.out.println("Votre id: " + idUtilisateur);

            nom = rs.getString("nom");
            System.out.println("Votre nom: " + nom);

            prenom = rs.getString("prenom");
            System.out.println("Votre prénom: " + prenom);

            email = rs.getString("email");
            System.out.println("Votre email: " + email);

            mdp = rs.getString("mdp");
            System.out.println("Votre mdp: " + mdp);

            role = rs.getString("role");
            System.out.println("Votre role: " + role);

        } catch (SQLException e) {
            System.out.println("Erreur! Utilisateur non trouvé: " + e.getMessage());
        }


        return utilisateurs;
    }




    public void supprimerUtilisateurParEmail(Utilisateur utilisateur,String email) {
        String sql = "DELETE FROM utilisateurs  WHERE email = ?";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getEmail());
            stmt.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
        }

    }

    public void mettreAJourUtilisateur(Utilisateur utilisateur) {
        String sql = "UPDATE SET Utilisateur SET nom = ?, prenom = ?, mdp = ?, role = ? \n" + "WHERE email = ?";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getEmail());
            stmt.executeUpdate();
            System.out.println("Utilisateur modifié avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de l'utilisateur : " + e.getMessage());
        }

    }


}




