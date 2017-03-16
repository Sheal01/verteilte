package dialog.addWeapon;

import awk.datenverwaltung.factory.impl.DatenverwaltungsFactory;
import awk.datenverwaltung.usecase.IWaffenPflegen;
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

public class addWeaponController implements Initializable
{

    // GUI Elemente in der Reihenfolge
    @FXML private TextField txtName;
    @FXML private ComboBox cbRace;
    @FXML private ComboBox cbType;
    @FXML private TextField txtStrength;
    @FXML private TextField txtRoa;
    @FXML private TextField txtAvv;
    @FXML private TextArea taAbilities;
    @FXML private Label laStatus;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // Befüllen der ComboBoxen und einstellen eines Standardwerts
        cbRace.getItems().addAll("Marines", "Aliens", "Predator");
        cbRace.getSelectionModel().select("Marines");

        cbType.getItems().addAll("RS", "CC" );
        cbType.getSelectionModel().select("RS");
    }



    @FXML
    public void btnAddWeaponClicked(ActionEvent event) throws Exception
    {
        DatenverwaltungsFactory dvFactory = new DatenverwaltungsFactory();
        IWaffenPflegen waffenPflegen = dvFactory.getWaffenPflegen();

        // Eingaben überprüfen
        if (txtName.getText().isEmpty() | cbRace.getSelectionModel().isEmpty() | cbType.getSelectionModel().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing input");
                alert.setHeaderText(null);
                alert.setContentText("You need to fill in at least the Name, Race and Type of the weapon.");
                alert.showAndWait();
        }
        else
        {
            Boolean ok = Boolean.valueOf(waffenPflegen.waffeAnlegen(txtName.getText(),
                    cbType.getValue().toString(),
                    cbRace.getValue().toString(),
                    txtStrength.getText(),
                    txtRoa.getText(),
                    txtAvv.getText() ));

            if (ok)
            {
                laStatus.setText(txtName.getText()+" added.");

                txtName.clear();
                txtAvv.clear();
                txtRoa.clear();
                txtStrength.clear();
            }
            else
            {
                laStatus.setText("Failed to add the data");
            }
        }



    }


    @FXML
    public void btnAbortClicked(ActionEvent event) throws Exception
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
