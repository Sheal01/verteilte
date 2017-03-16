package dialog.addCard;

import awk.datenverwaltung.factory.impl.DatenverwaltungsFactory;
import awk.datenverwaltung.usecase.IKartenPflegen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class addCardController implements Initializable
{
    @FXML private TextField txtName;
    @FXML private RadioButton rbEnvironment;
    @FXML private RadioButton rbStrategy;
    @FXML private ComboBox cbRace;
    @FXML private TextArea taAbility;
    @FXML private Label laStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // Befüllen der ComboBoxen und einstellen eines Standardwerts
        cbRace.getItems().addAll("Marines", "Aliens", "Predator");
    }


    // Nur, wenn es sich um eine Strategiekarte handelt soll eine Rasse auswählbar sein
    // Wenig Aufwand, um erste Fehleingaben abzufangen
    @FXML
    public void rbStrategyClicked(ActionEvent event) throws Exception
    {
        cbRace.setDisable(false);
    }


    @FXML
    public void btnAddCardClicked(ActionEvent event) throws Exception
    {
        DatenverwaltungsFactory dvFactory = new DatenverwaltungsFactory();
        IKartenPflegen kartenPflegen = dvFactory.getKartenPflegen();

        // Wenn weder Umgebungs- noch Strategiekarte ausgewählt wurde
        if (!rbEnvironment.isSelected() & !rbStrategy.isSelected())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing input");
            alert.setHeaderText(null);
            alert.setContentText("You need to select a card type.");
            alert.showAndWait();
        }




        // Eingaben überprüfen
        // Wenn Umgebungskarte ausgewählt, dann
        if (rbEnvironment.isSelected())
        {
            if (txtName.getText().isEmpty() | taAbility.getText().isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Missing input");
                    alert.setHeaderText(null);
                    alert.setContentText("You need to fill in at least the name and type of the card.");
                    alert.showAndWait();
            }
            else
            {
                Boolean ok = Boolean.valueOf(kartenPflegen.umgebungskarteAnlegen(txtName.getText(), taAbility.getText()));

                if (ok)
                {
                    laStatus.setText(txtName.getText() + " added to the database");
                    txtName.clear();
                    taAbility.clear();
                }
                else
                {
                    laStatus.setText("Failed to add the data");
                }
            }

        }
        // Wenn Strategiekarte ausgewählt wurde
        else if (rbStrategy.isSelected() )
        {
            // Wenn Eingaben fehlen
            if (txtName.getText().isEmpty() | cbRace.getSelectionModel().isEmpty() | taAbility.getText().isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing input");
                alert.setHeaderText(null);
                alert.setContentText("You need to fill in at least the name, race and ability.");
                alert.showAndWait();
            }
            else
            {
                Boolean ok2 = Boolean.valueOf(kartenPflegen.strategiekarteAnlegen(txtName.getText(), cbRace.getValue().toString(), taAbility.getText()));

                if (ok2)
                {
                    laStatus.setText( txtName.getText() +" added.");

                    txtName.clear();
                    taAbility.clear();
                }
                else
                {
                    laStatus.setText("Failed to add the data");
                }

            }
        }



    }







    public void btnCancelClicked(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dialog/hauptmenu/hauptmenu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
