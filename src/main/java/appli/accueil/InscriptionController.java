package appli.accueil;


    import appli.StartApplication;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Utilisateur;
    import org.mindrot.jbcrypt.BCrypt;
    import repository.UtilisateurRepository;





    import java.io.IOException;

public class InscriptionController {




        @FXML
        private Button boutonInscriptionInscrip;

        @FXML
        private Label boutonLabelErreurInscrip;

        @FXML
        private Button boutonRetour;

        @FXML
        private PasswordField confirmationMDP;

        @FXML
        private TextField emailCaseInscrip;

        @FXML
        private PasswordField mdpCaseInscrip;

        @FXML
        private TextField nomCase;

        @FXML
        private TextField prenomCase;




    @FXML
        private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();



    public void retourBouton (ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Login");

    }

        public void nomUtil(){
                String nom = nomCase.getText();
        }
        public void prenomUtil(){
                String prenom = prenomCase.getText();
        }
        public void emailUtil(){
                String email = emailCaseInscrip.getText();
        }
        public void mdpUtil(){
                String mdp = mdpCaseInscrip.getText();

        }

        public void confirmationMdpUtil(){
                String confirmationMdp= confirmationMDP.getText();

                if(!mdpCaseInscrip.getText().equals(confirmationMdp)){
                        System.out.println("Le mot de passe ne corresponds pas à ce que vous avez écrit");
                }else{
                        boutonLabelErreurInscrip.setText(" Inscription réussite!");
                }
        }

        public void verifChamps () {
               String nom= nomCase.getText();
               String prenom= prenomCase.getText();
               String email= emailCaseInscrip.getText();
               String mdp= mdpCaseInscrip.getText();
               String confirmationMdp= confirmationMDP.getText();

                if (nom.isEmpty()|| prenom.isEmpty()||email.isEmpty() || mdp.isEmpty()) {
                        boutonLabelErreurInscrip.setText("Veuillez remplir tous les champs");
                } else {
                        boutonInscriptionInscrip.setText("Inscription réussite!");
                }

                if(confirmationMDP.getText().equals(mdp)){
                        System.out.println("Inscription réussite!");
                }else{
                        boutonLabelErreurInscrip.setText("Le mot de passe ne corresponds pas à ce que vous avez écrit");
                }
        }
        public void InsriptionUtil(){
        String nom= nomCase.getText();
        String prenom= prenomCase.getText();
        String email= emailCaseInscrip.getText();
        String mdp= mdpCaseInscrip.getText();
        String mdpHachee = BCrypt.hashpw(mdp, BCrypt.gensalt());

        Utilisateur utilisateur=new Utilisateur(nom, prenom, email, mdpHachee);
        utilisateurRepository.ajouterUtilisateur(utilisateur);
            try {
                StartApplication.changeScene("ressources/appli.accueil/LoginView");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }







    }



