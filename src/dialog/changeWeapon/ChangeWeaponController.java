package dialog.changeWeapon;


import awk.datenverwaltung.factory.impl.DatenverwaltungsFactory;
import awk.datenverwaltung.usecase.IWaffeSuchen;
import awk.datenverwaltung.usecase.IWaffenPflegen;
import awk.datenverwaltung.usecase.impl.WaffeSuchen;
import awk.persistence.entity.Waffen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChangeWeaponController implements Initializable
{
    DatenverwaltungsFactory dvFactory = new DatenverwaltungsFactory();
    IWaffeSuchen waffeSuchen = new WaffeSuchen();

    @FXML private ComboBox cbRace;
    @FXML private ComboBox cbWeapons;

    @FXML private TextField txtName;
    @FXML private TextField txtRace;
    @FXML private TextField txtType;
    @FXML private TextField txtROA;
    @FXML private TextField txtStrength;
    @FXML private TextField txtAVV;

    @FXML private Label laStatus;

    @FXML
    // Befüllen der ComboBox mit den Rassen
    public void initialize(URL location, ResourceBundle resources)
    {
        cbRace.getItems().addAll("Marines", "Aliens", "Predator");
        cbRace.getSelectionModel().select("Marines");
    }

    // Befüllen der ComboBox mit den Waffen einer Rasse
    public void btnLoadWeaponsClicked(ActionEvent event) throws Exception
    {
        List<Waffen> foundWaffen = waffeSuchen.showAllWeaponsPerRace(cbRace.getValue().toString());

        cbWeapons.getItems().addAll(foundWaffen);
    }

    // Lädt eine Waffe
    public void btnShowDataClicked(ActionEvent event) throws Exception
    {
        List<Waffen> foundWaffe = waffeSuchen.showWaffeWithName(cbWeapons.getValue().toString());

        for(Waffen w : foundWaffe)
        {
            txtName.setText(w.getName());
            txtRace.setText(w.getRace());
            txtType.setText(w.getType());
            txtROA.setText(w.getRoa());
            txtStrength.setText(w.getStrength());
            txtAVV.setText(w.getAvv());
        }
    }

    public void btnChangeDataClicked(ActionEvent event) throws Exception
    {
        IWaffenPflegen waffenPflegen = dvFactory.getWaffenPflegen();
        boolean ok = waffenPflegen.waffeAendern(txtName.getText(), txtType.getText(), txtRace.getText(), txtStrength.getText(), txtROA.getText(), txtAVV.getText() );

        if (ok)
        {
            laStatus.setText(cbWeapons.getValue().toString() + " sucessfully changed.");
        }
        else
        {
            laStatus.setText("Please check your data. Could not change the entry.");
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
