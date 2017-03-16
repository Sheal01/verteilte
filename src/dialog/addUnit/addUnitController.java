package dialog.addUnit;

import awk.datenverwaltung.factory.impl.DatenverwaltungsFactory;
import awk.datenverwaltung.usecase.IEinheitenPflegen;
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

public class addUnitController implements Initializable
{
    // GUI Elemente
    @FXML private TextField txtName;
    @FXML private ComboBox cbRace;
    @FXML private ComboBox cbType;
    @FXML private ComboBox cbModelSize;
    @FXML private TextField txtMovement;
    @FXML private TextField txtCloseCombat;
    @FXML private TextField txtRangedSkill;
    @FXML private TextField txtStrength;
    @FXML private TextField txtConditions;
    @FXML private TextField txtWounds;
    @FXML private TextField txtArmorValue;
    @FXML private TextField txtLeadership;
    @FXML private TextField txtPoints;

    @FXML private Label laStatus;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // Befüllen der ComboBoxen und einstellen eines Standardwerts
        cbRace.getItems().addAll("Marines", "Aliens", "Predator");
        cbRace.getSelectionModel().select("Marines");

        cbType.getItems().addAll("T","S","HQ");
        cbType.getSelectionModel().select("T");

        cbModelSize.getItems().addAll("Small", "Medium", "Large", "No Base");
        cbModelSize.getSelectionModel().select("Medium");
    }




    public void btnAddUnitClicked(ActionEvent event) throws Exception
    {
        DatenverwaltungsFactory dvFactory = new DatenverwaltungsFactory();
        IEinheitenPflegen einheitenPflegen = dvFactory.getEinheitenPflegen();

        // Eingaben überprüfen - inwiefern hier sinnvoll?
        if (txtName.getText().isEmpty() | cbRace.getSelectionModel().isEmpty() | cbType.getSelectionModel().isEmpty() )
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing input");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill in the Name, Race and Type.");
            alert.showAndWait();
        }


        // Rasse bestimmen und die entsprechende Entity Klasse aufrufen

            if (cbRace.getValue().equals("Marines"))
            {
                Boolean ok = Boolean.valueOf(einheitenPflegen.marineHinzufuegen(
                        txtName.getText(),
                        cbType.getValue().toString(),
                        txtPoints.getText(),
                        cbModelSize.getValue().toString(),
                        txtMovement.getText(),
                        txtCloseCombat.getText(),
                        txtRangedSkill.getText(),
                        txtStrength.getText(),
                        txtConditions.getText(),
                        txtWounds.getText(),
                        txtArmorValue.getText(),
                        txtLeadership.getText()));

            if (ok)
            {
                laStatus.setText(txtName.getText() + " added");

                txtName.clear();
                txtMovement.clear();
                txtCloseCombat.clear();
                txtRangedSkill.clear();
                txtStrength.clear();
                txtConditions.clear();
                txtWounds.clear();
                txtArmorValue.clear();
                txtLeadership.clear();
            }
            else
            {
                laStatus.setText("Data could not be added");
            }

        }


        else if (cbRace.getValue().equals("Aliens"))
        {
            Boolean ok = Boolean.valueOf(einheitenPflegen.alienHinzufuegen(txtName.getText(),
                    cbType.getValue().toString(),
                    txtPoints.getText(),
                    cbModelSize.getValue().toString(),
                    txtMovement.getText(),
                    txtCloseCombat.getText(),
                    txtRangedSkill.getText(),
                    txtStrength.getText(),
                    txtConditions.getText(),
                    txtWounds.getText(),
                    txtArmorValue.getText(),
                    txtLeadership.getText()));

            if (ok)
            {
                laStatus.setText(txtName.getText() + " added");

                txtName.clear();
                txtMovement.clear();
                txtCloseCombat.clear();
                txtRangedSkill.clear();
                txtStrength.clear();
                txtConditions.clear();
                txtWounds.clear();
                txtArmorValue.clear();
                txtLeadership.clear();
            }
            else
            {
                laStatus.setText("Data could not be added");
            }

        }


        else if (cbRace.getValue().equals("Predator"))
        {
            Boolean ok = Boolean.valueOf(einheitenPflegen.predatorHinzufuegen(txtName.getText(),
                    cbType.getValue().toString(),
                    cbModelSize.getValue().toString(),
                    txtMovement.getText(),
                    txtCloseCombat.getText(),
                    txtRangedSkill.getText(),
                    txtStrength.getText(),
                    txtConditions.getText(),
                    txtWounds.getText(),
                    txtArmorValue.getText(),
                    txtLeadership.getText(),
                    txtPoints.getText()));

            if (ok)
            {
                laStatus.setText(txtName.getText()+" added");

                txtName.clear();
                txtMovement.clear();
                txtCloseCombat.clear();
                txtRangedSkill.clear();
                txtStrength.clear();
                txtConditions.clear();
                txtWounds.clear();
                txtArmorValue.clear();
                txtLeadership.clear();
            }
            else
            {
                laStatus.setText("Data could not be added");
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
