package user;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Utilisateur;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;


public class ModificationUserController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField roleField;

    private Utilisateur utilisateurSel;

    public void initData(Utilisateur utilisateur) {
        this.utilisateurSel = utilisateur;
        nomField.setText(utilisateur.getNom());
        prenomField.setText(utilisateur.getPrenom());
        emailField.setText(utilisateur.getEmail());
        roleField.setText(utilisateur.getRole());
    }

    @FXML
    void enregistrerModification(ActionEvent event) {
        utilisateurSel.setNom(nomField.getText());
        utilisateurSel.setPrenom(prenomField.getText());
        utilisateurSel.setEmail(emailField.getText());
        utilisateurSel.setRole(roleField.getText());

        try {
            StartApplication.changeScene("GestionUser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
