package dialog.hauptmenu.hauptmenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;


public class HauptmenuController
{

    @FXML
    public void btnaddCardClicked(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dialog/addCard/addCard.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void btnSearchData(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dialog/showData/showData.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void btnCAddAbilityClicked(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dialog/addAbility/AddAbility.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void btnAddUnit(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dialog/addUnit/addUnit.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void btnAddWeapon(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dialog/addWeapon/addWeapon.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    public void btnChangeWeaponClicked(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dialog/changeWeapon/changeWeapon.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }



    public void btnDrawEnvironmental(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dialog/addWeapon/addWeapon.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
