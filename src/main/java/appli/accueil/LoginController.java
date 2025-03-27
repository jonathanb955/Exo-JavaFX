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
        } else if (utilisateurTrouve == null) {
            System.out.println("Utilisateur non trouvé");
        }else if(utilisateurTrouve.getMdp().equals(mdp)){
            StartApplication.changeScene("accueil/AccueilView");
        } else {
            labelErreur.setText("Mot de passe incorrect!");
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

    public void mdpUtilisateur (){
        System.out.println("Mot de passe: " + mdpCase.getText());
    }
    }


