package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import repository.UtilisateurRepository;
import model.Utilisateur;
import session.SessionUtilisateur;

import java.io.IOException;


public class LoginController {


    @FXML
    private Button boutonConnexion;

    @FXML
    private Button boutonMdpOublie;

    @FXML
    private Button butonInscription;

    @FXML
    private TextField emailCase;

    @FXML
    private Label labelErreur;

    @FXML
    private PasswordField mdpCase;



    private final UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @FXML
    public void seConnecter() throws IOException {
        String email = emailCase.getText().trim();
        String mdp = mdpCase.getText().trim();

        if (email.isEmpty() || mdp.isEmpty()) {
            labelErreur.setText("Veuillez remplir tous les champs");
            labelErreur.setVisible(true);
        } else {
            Utilisateur utilisateurTrouve = utilisateurRepository.getUtilisateurParEmail(email);

            if (utilisateurTrouve == null) {
                System.out.println("Utilisateur non trouvé");
                labelErreur.setText("Utilisateur non trouvé");
                labelErreur.setVisible(true);
            } else if (utilisateurTrouve.getMdp().trim().equals(mdp)) {
                System.out.println("Connexion réussie");
                SessionUtilisateur.getInstance().sauvegardeSession(utilisateurTrouve);
                StartApplication.changeScene("accueil/AccueilView");
                labelErreur.setVisible(false);
            } else {
                System.out.println("Échec de la connexion. Email ou mot de passe incorrect.");
                labelErreur.setText("Email ou mot de passe incorrect.");
                labelErreur.setVisible(true);
            }
        }

        Utilisateur utilisateurActuel = SessionUtilisateur.getInstance().getUtilisateur();
        if (utilisateurActuel != null) {
            System.out.println("Utilisateur connecté : " + utilisateurActuel.getNom());
        }


}

    public void mdpOublie (){
            System.out.println("Redirection vers le lien pour changer le mdp");
            labelErreur.setText("Lien pouur changer le mdp");
            }

    public void inscription (ActionEvent event) throws IOException {
                StartApplication.changeScene("accueil/Inscription");
        }

    public void emailUtilisateur (){
        System.out.println("Email: " + emailCase.getText());
    }

    public void mdpUtilisateur () {
        System.out.println("Mot de passe: " + mdpCase.getText());
    }

    @FXML
    protected void deconnexion() {
        SessionUtilisateur.getInstance().deconnecter();
        System.out.println("Utilisateur déconnecté.");

    }
    }


