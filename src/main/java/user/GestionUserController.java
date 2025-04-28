package user;


import appli.StartApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.Utilisateur;
import javafx.scene.control.TableColumn;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;



public class GestionUserController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableauUser;

    @FXML
    private Button btnSupprimer;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            String[][] colonnes = {
                    {"Id Utilisateur", "idUser"},
                    {"Nom", "nom"},
                    {"Prénom", "prenom"},
                    {"Email", "mail"},
                    {"Rôle", "role"}
            };

            for (int i = 0; i < colonnes.length; i++) {
                TableColumn<Utilisateur, String> maCol = new TableColumn<>(colonnes[i][0]);
                maCol.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
                tableauUser.getColumns().add(maCol);
            }

            chargerUtilisateurs();
        }

    private void chargerUtilisateurs() {
        ObservableList<Utilisateur> utilisateurs = FXCollections.observableArrayList(
                new Utilisateur(1, "Dupont", "Jean", "jean.dupont@email.com","lol", "Admin"),
                new Utilisateur(2, "Martin", "Sophie", "sophie.martin@email.com","coucou", "User")
        );
        tableauUser.setItems(utilisateurs);

    }
    @FXML
    void supprimerUtilisateur(ActionEvent event) {
        Utilisateur selection = tableauUser.getSelectionModel().getSelectedItem();
        if (selection != null) {

            tableauUser.getItems().remove(selection);
            btnSupprimer.setDisable(true);
        }
    }
    @FXML
    void cliqueTableauEvent(MouseEvent event) {
        Utilisateur selection = tableauUser.getSelectionModel().getSelectedItem();
        btnSupprimer.setDisable(selection == null);

        if (event.getClickCount() == 2 && selection != null) {
            try {
                StartApplication.changeScene("user/modificationUser");
                ModificationUserController controller = (ModificationUserController) StartApplication.getControllerFromStage();
                controller.initData(selection);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}



