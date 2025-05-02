package user;

import repository.UtilisateurRepository;
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
import repository.UtilisateurRepository;


public class GestionUserController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableauUser;
    @FXML
    private final UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

     private Utilisateur utilisateur;

    @FXML
    private Button btnSupprimer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String [][] colonnes = {
                { "Id Utilisateur","idUser" },
                { "Nom","nom" },
                { "Prénom","prenom" },
                { "Email","mail" },
                { "Rôle","role" }
                        };

        for ( int i = 0 ; i < colonnes.length ; i ++ ){
            //Création de la colonne avec le titre
            TableColumn<Utilisateur,String> maCol = new TableColumn<>(colonnes[i][0]);
//Ligne permettant la liaison automatique de la cellule avec la propriété
            maCol.setCellValueFactory(
                    new PropertyValueFactory<Utilisateur,String>(colonnes[i][1]));
            //Ajout de la colonne dans notre tableau
            tableauUser.getColumns().add(maCol);
        }
    }



    @FXML
    void supprimerUtilisateur(ActionEvent event) {
        Utilisateur userSel = tableauUser.getSelectionModel().getSelectedItem();
        if (userSel != null) {
            tableauUser.getItems().remove(userSel);
            btnSupprimer.setDisable(true);
        }
    }
    @FXML
    void cliqueTableauEvent(MouseEvent event) {
        Utilisateur userSel = tableauUser.getSelectionModel().getSelectedItem();
        if (userSel != null) {
            btnSupprimer.setDisable(false);
        }else{
            btnSupprimer.setDisable(true);
        }

        if (event.getClickCount() == 2) { // Vérifie si c'est un double-clic
            if (userSel != null) {
                try {
                    StartApplication.changeScene("ModificationUser");
                    ModificationUserController controller = (ModificationUserController)
                            StartApplication. getControllerFromStage();
                    controller.initData(utilisateur);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    }






