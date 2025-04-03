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


    public void seConnecter () throws IOException {
        Utilisateur utilisateurTrouve = utilisateurRepository.getUtilisateurParEmail(emailCase.getText());
        String email = emailCase.getText();
        String mdp = mdpCase.getText();

        if (email.isEmpty() || mdp.isEmpty()) {
            labelErreur.setText("Veuillez remplir tous les champs");
        }else if (utilisateurTrouve == null) {
            System.out.println("Utlisateur non trouvé");
        }else if(utilisateurTrouve.getMdp().equals(mdp)){
            Utilisateur utilisateur=new Utilisateur(email, mdp);
            utilisateurRepository.getUtilisateurParEmail(utilisateur.getEmail());
            System.out.println("Connexion réussie pour : " + utilisateur.getNom());
            SessionUtilisateur.getInstance().sauvegardeSession(utilisateur);
            StartApplication.changeScene("accueil/AccueilView");
            labelErreur.setVisible(false);

        } else {
            System.out.println("Échec de la connexion. Email ou mot de passe incorrect.");
            labelErreur.setText("Email ou mot de passe incorrect.");
            labelErreur.setVisible(true);
        }
    }

    public void mdpOublie (){
            System.out.println("Redirection vers le lien pour changer le mdp");
            labelErreur.setText("Lien pouur changer le mdp");
            }

    public void inscription (ActionEvent event) throws IOException {
                StartApplication.changeScene("accueil/Inscription");
        }



    @FXML
    protected void deconnexion() {
        SessionUtilisateur.getInstance().deconnecter();
        System.out.println("Utilisateur déconnecté.");

    }
    }


