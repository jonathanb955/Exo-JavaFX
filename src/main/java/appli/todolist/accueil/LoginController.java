package appli.todolist.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


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



        public void seConnecter () {
            String email = emailCase.getText();
            String mdp = mdpCase.getText();

            if (email.isEmpty() || mdp.isEmpty()) {
                labelErreur.setText("Veuillez remplir tous les champs");
            } else if (email.equals("jb@gmail.com") && mdp.equals("JBAO")) {
                System.out.println("Heureux de vous revoir parmis nous!");
            } else {
                labelErreur.setText("Identifiants incorrect!");
            }
        }

        public void mdpOublie (){
            System.out.println("Redirection vers le lien pour changer le mdp");
            labelErreur.setText("Lien pouur changer le mdp");
            }

            public void inscription (){
            System.out.println("Redirection vers le lien pour l'inscription");
        }

        public void emailUtilisateur (){
            System.out.println("Email: " + emailCase.getText());
        }

    public void mdpUtilisateur (){
        System.out.println("Mot de passe: " + mdpCase.getText());
    }
    }


