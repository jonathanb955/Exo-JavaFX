package user;


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

        StartApplication.changeScene("user/gestionUser");
    }
}
