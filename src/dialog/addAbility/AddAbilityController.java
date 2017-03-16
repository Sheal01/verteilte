package dialog.addAbility;

import awk.datenverwaltung.factory.impl.DatenverwaltungsFactory;
import awk.datenverwaltung.usecase.IEinheitSuchen;
import awk.datenverwaltung.usecase.IEinheitenPflegen;
import awk.datenverwaltung.usecase.IWaffeSuchen;
import awk.datenverwaltung.usecase.IWaffenPflegen;
import awk.persistence.entity.Alien;
import awk.persistence.entity.Marines;
import awk.persistence.entity.Predator;
import awk.persistence.entity.Waffen;

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
import java.util.List;
import java.util.ResourceBundle;

public class AddAbilityController implements Initializable
{
    @FXML private TextField txtName;
    @FXML private ComboBox cbRace;
    @FXML private RadioButton rbUnit;
    @FXML private RadioButton rbWeapon;
    @FXML private ComboBox cbUnit;
    @FXML private ComboBox cbWeapon;
    @FXML private TextArea taAbility;
    @FXML private Label laStatus;


    @FXML
    public void initialize(URL location, ResourceBundle resources)
    {
        cbRace.getItems().addAll("Marines", "Aliens", "Predator");
        cbRace.getSelectionModel().select("Marines");

        cbUnit.setDisable(true);
        cbWeapon.setDisable(true);
    }


    /* Lädt anhand der ausgewählten Rasse die gespeicherten Einheiten
     Denkbar wäre auch eine hard coded befüllung der comboBox, da nicht sehr oft neue Einheiten erscheinen
    Laden der Daten dauert länger => schlechte Performance */
    @FXML
    public void rbUnitClicked(ActionEvent event) throws Exception
    {
        cbUnit.setDisable(false);

        DatenverwaltungsFactory dvFactory = new DatenverwaltungsFactory();
        IEinheitSuchen einheitSuchen = dvFactory.getEinheitenSuchen();

        // Ausgewählte Rasse bestimmen für die Abfrage
        switch (cbRace.getValue().toString())
        {
            case "Marines":
                List<Marines> foundMarines = einheitSuchen.getMarineNames();
                cbUnit.getItems().addAll(foundMarines);
                break;

            case "Aliens":
                List<Alien> foundAlien = einheitSuchen.getAlienNames();
                cbUnit.getItems().addAll(foundAlien);
                break;

            case "Predator":
                List<Predator> foundPred = einheitSuchen.getPredatorNames();
                cbUnit.getItems().addAll(foundPred);
                break;
        }
    }

    // Befüllt die comboBox mit den Waffen der vorher ausgewählten Rasse
    @FXML
    public void rbWeaponClicked(ActionEvent event) throws Exception
    {
        cbWeapon.setDisable(false);

        DatenverwaltungsFactory dvFactory = new DatenverwaltungsFactory();
        IWaffeSuchen waffeSuchen =  dvFactory.getWaffeSuchen();

        List<Waffen> foundWaffen = waffeSuchen.showAllWeaponsPerRace(cbRace.getValue().toString());

        cbWeapon.getItems().addAll(foundWaffen);

    }


    @FXML
    public void btnAddAbilityClicked(ActionEvent event) throws Exception
    {
        if (rbWeapon.isSelected())
        {
            DatenverwaltungsFactory dvFactory = new DatenverwaltungsFactory();
            IWaffenPflegen waffenPflegen = dvFactory.getWaffenPflegen();

            waffenPflegen.waffenAbilityAnlegen(txtName.getText(), taAbility.getText(), cbRace.getValue().toString(), cbWeapon.getValue().toString());

            laStatus.setText(txtName.getText()+ " added");
        }
        else
        {
            DatenverwaltungsFactory dvFactory = new DatenverwaltungsFactory();
            IEinheitenPflegen einheitenPflegen = dvFactory.getEinheitenPflegen();

            einheitenPflegen.UnitAbilityHinzufuegen(txtName.getText(), taAbility.getText(), cbRace.getValue().toString(), cbUnit.getValue().toString());

            laStatus.setText(txtName.getText()+ " added");
        }




    }


    // Zurück ins Hauptmenü
    @FXML
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
