package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Utilisateur;

public class UtlisateurRepository {
    private Connection connexion;

    public UtlisateurRepository() {

    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateurs (nom, prenom, email, mdp, role) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMdp());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }

    }


    public Utilisateur getUtilisateurParEmail(Utilisateur utilisateur, String email) {
        String sql = "SELECT * FROM utilisateurs WHERE email = ?";
        int idUtilisateur = 0;
        String nom = "";
        String prenom = "";
        String mdp = "";
        String role = "";

        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getEmail());
            stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();

            System.out.println("Utilisateur trouvé avec succès !");

           idUtilisateur = rs.getInt("idUtilisateur");
            System.out.println("Votre id: "+idUtilisateur);

            nom = rs.getString("nom");
            System.out.println("Votre nom: "+nom);

            prenom = rs.getString("prenom");
            System.out.println("Votre prénom: "+prenom);

           email = rs.getString("email");
            System.out.println("Votre email: "+email);

            mdp = rs.getString("mdp");
            System.out.println("Votre mdp: "+mdp);

            role = rs.getString("role");
            System.out.println("Votre role: "+role);

        } catch (SQLException e) {
            System.out.println("Erreur! Utilisateur non trouvé: " + e.getMessage());
        }
        return utilisateur;
    }

    public void supprimerUtilisateurParEmail(Utilisateur utilisateur,String email) {
        String sql = "DELETE FROM utilisateurs  WHERE email = ?";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getEmail());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }

    }

    }


