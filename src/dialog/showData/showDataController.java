package dialog.showData;


import awk.datenverwaltung.factory.impl.DatenverwaltungsFactory;
import awk.datenverwaltung.usecase.IEinheitSuchen;
import awk.datenverwaltung.usecase.IKarteSuchen;
import awk.datenverwaltung.usecase.IWaffeSuchen;
import awk.persistence.entity.*;
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


public class showDataController implements Initializable
{
    public static int id = 1;


    // Quellen TreeView:
    // https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/016_treeView/Main.java
    // https://www.youtube.com/watch?v=SvmSNbXQSnQ&index=16&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG

    @FXML private TreeView<String> treeView;
    @FXML private ComboBox cbRace;
    @FXML private ComboBox cbChoice;
    @FXML private TextField txtInput;

    // Für die gefundenen Werte
    @FXML private Label laName;
    @FXML private Label laType;
    @FXML private Label laPoints;
    @FXML private Label laModelsize;
    @FXML private Label laMovement;
    @FXML private Label laRangedSkill;
    @FXML private Label laCloseCombat;
    @FXML private Label laConditions;
    @FXML private Label laStrength;
    @FXML private Label laWounds;
    @FXML private Label laArmorValue;
    @FXML private Label laLongText;

    // Für die konstanten Label
    @FXML private Label txtType;
    @FXML private Label txtPoints;
    @FXML private Label txtModelsize;
    @FXML private Label txtMovement;
    @FXML private Label txtRangedSkill;
    @FXML private Label txtCloseCombat;
    @FXML private Label txtConditions;
    @FXML private Label txtStrength;
    @FXML private Label txtWounds;
    @FXML private Label txtArmorValue;


    DatenverwaltungsFactory dvFactory = new DatenverwaltungsFactory();

    private static String race;
    private static String choice;


    // Befüllt die Comboboxen und TreeView mit Daten beim Laden des Dialogs
    // Alle Labels unsichtbar machen. Diese sollen erst nach der Auswahl erscheinen.
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // Deaktivieren aller Beschreibungsfelder
        txtType.setVisible(false);
        txtPoints.setVisible(false);
        txtModelsize.setVisible(false);
        txtMovement.setVisible(false);
        txtRangedSkill.setVisible(false);
        txtCloseCombat.setVisible(false);
        txtConditions.setVisible(false);
        txtStrength.setVisible(false);
        txtWounds.setVisible(false);
        txtArmorValue.setVisible(false);
        laLongText.setVisible(false);


        cbRace.getItems().addAll("Marines", "Aliens", "Predator");
        cbRace.getSelectionModel().select("Marines");

        cbChoice.getItems().addAll("Unit", "Weapon", "Strategy Card", "Ability", "Environmental Card");
        cbChoice.setPromptText("what to search");


        TreeItem<String> root, Aliens, Marines, Predator, EnvironmentalCards;

        root = new TreeItem<>();
        root.setExpanded(true);

        // Aufbau nach Rassen
        Aliens = makeBranch("Aliens", root);
        makeBranch("Units", Aliens);
        makeBranch("Weapons", Aliens);
        makeBranch("Strategy Cards", Aliens);
        makeBranch("Ability", Aliens);

        Marines = makeBranch("Marines", root);
        makeBranch("Units", Marines);
        makeBranch("Weapons", Marines);
        makeBranch("Strategy Cards", Marines);
        makeBranch("Ability", Marines);

        Predator = makeBranch("Predator", root);
        makeBranch("Units", Predator);
        makeBranch("Weapons", Predator);
        makeBranch("Strategy Cards", Predator);
        makeBranch("Ability", Predator);

        EnvironmentalCards = makeBranch("EnvironmentalCards", root);
        //workaround gegen NullPointerException
        makeBranch("Environmental Cards", EnvironmentalCards);

        treeView.setRoot(root);
        treeView.setShowRoot(false);


        // Ermittelt den ausgewählten Eintrag
        treeView.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) ->
                {
                        // Ermitteln vom Parent und Child für das ermitteln der benötigten Operation
                        // Umgebungskarte hat kein child => Nullpointerexception?
                        // Workaround: Umgebungskarte zusätzlich als Child hinzufügen
                        race = newValue.getParent().getValue();
                        choice = newValue.getValue();

                        getOperation(newValue.getParent().getValue(), newValue.getValue());
                });

    }


    public void btnSearchClicked(ActionEvent event) throws Exception
    {


        switch (cbChoice.getValue().toString())
        {
            // Objekt = cbRace
            case "Unit":
                unitSelected();

                IEinheitSuchen einheitSuchen = dvFactory.getEinheitenSuchen();

                // Unterscheidung der Rasse und somit Entität
                switch(cbRace.getValue().toString())
                {
                    case "Marines":
                        List<Marines> foundMarine = einheitSuchen.searchMarinePerName(txtInput.getText());

                        for (Marines marine : foundMarine)
                        {
                            laName.setText(marine.getName());
                            laType.setText(marine.getType());
                            laPoints.setText(marine.getPunkte());
                            laModelsize.setText(marine.getModelSize());

                            laMovement.setText(marine.getMovement());
                            laCloseCombat.setText(marine.getCloseCombat());
                            laRangedSkill.setText(marine.getRangedSkill());
                            laStrength.setText(marine.getStrength());
                            laConditions.setText(marine.getConditions());
                            laWounds.setText(marine.getWounds());
                            laArmorValue.setText(marine.getArmorValue());

                        }

                        break;
                    case "Aliens":
                        List<Alien> foundAlien = einheitSuchen.searchAlienPerName(txtInput.getText());

                        for (Alien Alien : foundAlien)
                        {
                            laName.setText(Alien.getName());
                            laType.setText(Alien.getType());
                            laPoints.setText(Alien.getPunkte());
                            laModelsize.setText(Alien.getModelSize());

                            laMovement.setText(Alien.getMovement());
                            laCloseCombat.setText(Alien.getCloseCombat());
                            laRangedSkill.setText(Alien.getRangedSkill());
                            laStrength.setText(Alien.getStrength());
                            laConditions.setText(Alien.getConditions());
                            laWounds.setText(Alien.getWounds());
                            laArmorValue.setText(Alien.getArmorValue());

                        }
                        break;
                    case "Predator":
                        List<Predator> foundPred = einheitSuchen.searchPredPerName(txtInput.getText());

                        for (Predator predator : foundPred)
                        {
                            laName.setText(predator.getName());
                            laType.setText(predator.getType());
                            laPoints.setText(predator.getPunkte());
                            laModelsize.setText(predator.getModelSize());

                            laMovement.setText(predator.getMovement());
                            laCloseCombat.setText(predator.getCloseCombat());
                            laRangedSkill.setText(predator.getRangedSkill());
                            laStrength.setText(predator.getStrength());
                            laConditions.setText(predator.getConditions());
                            laWounds.setText(predator.getWounds());
                            laArmorValue.setText(predator.getArmorValue());

                        }

                        break;
                }

                break;
            // Objekt = Waffen
            case "Weapon":
                weaponSelected();

                IWaffeSuchen waffeSuchen = dvFactory.getWaffeSuchen();

                List<Waffen> foundWaffe = waffeSuchen.showWaffeWithName(txtInput.getText());

                for(Waffen waffen : foundWaffe)
                {
                    laName.setText(waffen.getName());
                    laType.setText(waffen.getType());
                    laPoints.setText(waffen.getRace());

                    laMovement.setText(waffen.getStrength());
                    laCloseCombat.setText(waffen.getRoa());
                    laRangedSkill.setText(waffen.getAvv());
                }



                break;
            case "Strategy Card":
                longText();

                IKarteSuchen strategiekarteSuchen = dvFactory.getKarteSuchen();

                List<Strategiekarte> foundKarte = strategiekarteSuchen.showStrategiekarten(txtInput.getText());

                for(Strategiekarte karte : foundKarte)
                {
                    laName.setText(karte.getName());

                    laLongText.setText(karte.getInhalt());
                }

                break;
            case "Ability":
                IEinheitSuchen abilitySuchen = dvFactory.getEinheitenSuchen();
                break;

                // works so lala
            case "Environmental Card":
                longText();

                IKarteSuchen umgebungskarteSuchen = dvFactory.getKarteSuchen();

                List<Umgebungskarte> foundKarten = umgebungskarteSuchen.showUmgebungskarten(txtInput.getText());

                for(Umgebungskarte karte : foundKarten)
                {
                    laName.setText(karte.getName());
                    laLongText.setText(karte.getInhalt());
                }

                break;
        }
    }




        private void getOperation(String parent, String child)
        {
            switch (parent)
            {
                case "Aliens":
                    switch (child)
                    {
                        case "Units":
                            unitSelected();

                            IEinheitSuchen einheitSuchen = dvFactory.getEinheitenSuchen();

                            List<Alien> foundAlien = einheitSuchen.showAlienPerID(id);

                            for (Alien Alien : foundAlien)
                            {
                                laName.setText(Alien.getName());
                                laType.setText(Alien.getType());
                                laPoints.setText(Alien.getPunkte());
                                laModelsize.setText(Alien.getModelSize());

                                laMovement.setText(Alien.getMovement());
                                laCloseCombat.setText(Alien.getCloseCombat());
                                laRangedSkill.setText(Alien.getRangedSkill());
                                laStrength.setText(Alien.getStrength());
                                laConditions.setText(Alien.getConditions());
                                laWounds.setText(Alien.getWounds());
                                laArmorValue.setText(Alien.getArmorValue());

                            }
                            break;

                        case "Weapons":
                            weaponSelected();

                            IWaffeSuchen waffeSuchen = dvFactory.getWaffeSuchen();

                            // Alien Waffen fangen in der Tabelle Waffen mit der ID 16 an und hören mit 26 auf

                            List<Waffen> foundWaffen = waffeSuchen.showAlienWeaponsPerID(id);

                            for(Waffen waffen : foundWaffen)
                            {
                                laName.setText(waffen.getName());
                                laType.setText(waffen.getType());
                                laPoints.setText(waffen.getRace());

                                laMovement.setText(waffen.getStrength());
                                laCloseCombat.setText(waffen.getRoa());
                                laRangedSkill.setText(waffen.getAvv());
                            }



                            break;


                        case "Strategy Cards":
                            longText();

                            IKarteSuchen karteSuchen = dvFactory.getKarteSuchen();

                            List<Strategiekarte> foundKarte = karteSuchen.showAlienStrategiekarten(id);

                            for(Strategiekarte karte : foundKarte)
                            {
                                laName.setText(karte.getName());

                                laLongText.setText(karte.getInhalt());
                            }


                            break;
                        case "Ability":
                            longText();
                            break;
                    }
                    break;
                    
                    case "Marines":

                        switch (child)
                        {
                            case "Units":

                                unitSelected();

                                IEinheitSuchen einheitSuchen = dvFactory.getEinheitenSuchen();

                                List<Marines> foundMarine = einheitSuchen.showMarinesPerID(id);

                                for (Marines marine : foundMarine)
                                {
                                    laName.setText(marine.getName());
                                    laType.setText(marine.getType());
                                    laPoints.setText(marine.getPunkte());
                                    laModelsize.setText(marine.getModelSize());

                                    laMovement.setText(marine.getMovement());
                                    laCloseCombat.setText(marine.getCloseCombat());
                                    laRangedSkill.setText(marine.getRangedSkill());
                                    laStrength.setText(marine.getStrength());
                                    laConditions.setText(marine.getConditions());
                                    laWounds.setText(marine.getWounds());
                                    laArmorValue.setText(marine.getArmorValue());

                                }

                                break;
                            case "Weapons":
                                weaponSelected();

                                IWaffeSuchen waffeSuchen = dvFactory.getWaffeSuchen();

                                // Alien Waffen fangen in der Tabelle Waffen mit der ID 16 an und hören mit 26 auf

                                List<Waffen> foundWaffen = waffeSuchen.showMarinesWeaponsPerID(id);

                                for(Waffen waffen : foundWaffen)
                                {
                                    laName.setText(waffen.getName());
                                    laType.setText(waffen.getType());
                                    laPoints.setText(waffen.getRace());

                                    laMovement.setText(waffen.getStrength());
                                    laCloseCombat.setText(waffen.getRoa());
                                    laRangedSkill.setText(waffen.getAvv());
                                }


                                break;
                            case "Strategy Cards":
                                longText();

                                IKarteSuchen karteSuchen = dvFactory.getKarteSuchen();

                                List<Strategiekarte> foundKarte = karteSuchen.showMarineStrategiekarten(id);

                                for(Strategiekarte karte : foundKarte)
                                {
                                    laName.setText(karte.getName());

                                    laLongText.setText(karte.getInhalt());
                                }


                                break;
                            case "Ability":
                                longText();
                                break;
                        }

                        break;


                    case "Predator":
                        switch(child)
                        {
                            case "Units":

                                unitSelected();

                                IEinheitSuchen einheitSuchen = dvFactory.getEinheitenSuchen();

                                List<Predator> foundPred = einheitSuchen.showPredatorPerID(id);

                                for (Predator predator : foundPred)
                                {
                                    laName.setText(predator.getName());
                                    laType.setText(predator.getType());
                                    laPoints.setText(predator.getPunkte());
                                    laModelsize.setText(predator.getModelSize());

                                    laMovement.setText(predator.getMovement());
                                    laCloseCombat.setText(predator.getCloseCombat());
                                    laRangedSkill.setText(predator.getRangedSkill());
                                    laStrength.setText(predator.getStrength());
                                    laConditions.setText(predator.getConditions());
                                    laWounds.setText(predator.getWounds());
                                    laArmorValue.setText(predator.getArmorValue());

                                }


                                break;

                            case "Weapons":
                                weaponSelected();

                                IWaffeSuchen waffeSuchen = dvFactory.getWaffeSuchen();

                                List<Waffen> foundWaffen = waffeSuchen.showPredWeaponsPerID(id);

                                for(Waffen waffen : foundWaffen)
                                {
                                    laName.setText(waffen.getName());
                                    laType.setText(waffen.getType());
                                    laPoints.setText(waffen.getRace());

                                    laMovement.setText(waffen.getStrength());
                                    laCloseCombat.setText(waffen.getRoa());
                                    laRangedSkill.setText(waffen.getAvv());
                                }

                                break;
                            case "Strategy Cards":
                                longText();

                                IKarteSuchen karteSuchen = dvFactory.getKarteSuchen();

                                List<Strategiekarte> foundKarte = karteSuchen.showPredStrategiekarten(id);

                                for(Strategiekarte karte : foundKarte)
                                {
                                    laName.setText(karte.getName());

                                    laLongText.setText(karte.getInhalt());
                                }


                                break;
                            case "Ability":
                                longText();

                                break;
                        }
                        break;

                    case "EnvironmentalCards":
                        longText();

                        IKarteSuchen uKarteSuchen= dvFactory.getKarteSuchen();

                        List<Umgebungskarte> foundKarten = uKarteSuchen.showUmgebungskarten(id);

                        for(Umgebungskarte ukarte : foundKarten)
                        {
                            laName.setText(ukarte.getName());

                            laLongText.setText(ukarte.getInhalt());
                        }

                        break;

                }
        }




    public void btnPrevClicked(ActionEvent event) throws Exception
    {
        if (id == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("There is no previous entry.");
            alert.showAndWait();
        }
        else
        {
            --id;

            getOperation(race, choice);

        }


    }


    public void btnNextClicked(ActionEvent event) throws Exception
    {
        ++id;
        getOperation(race, choice);

    }






    // Dialogaufbau anhand der Auswahl von TreeView
    private void unitSelected()
    {
        laLongText.setVisible(false);

        txtPoints.setVisible(true);
        txtType.setVisible(true);
        txtModelsize.setVisible(true);

        laModelsize.setVisible(true);
        laType.setVisible(true);
        laPoints.setVisible(true);

        txtMovement.setVisible(true);
        txtMovement.setText("Movement");
        txtRangedSkill.setVisible(true);
        txtRangedSkill.setText("Ranged Skill");
        txtCloseCombat.setVisible(true);
        txtCloseCombat.setText("Close Combat");
        txtConditions.setVisible(true);
        txtStrength.setVisible(true);
        txtConditions.setVisible(true);
        txtWounds.setVisible(true);
        txtArmorValue.setVisible(true);

        // rechte seite
        laMovement.setVisible(true);
        laCloseCombat.setVisible(true);
        laRangedSkill.setVisible(true);
        laStrength.setVisible(true);
        laConditions.setVisible(true);
        laWounds.setVisible(true);
        laArmorValue.setVisible(true);


    }
    // Dialogaufbau anhand der Auswahl von TreeView
    private void weaponSelected()
    {
        txtType.setVisible(true);
        txtPoints.setVisible(true);
        txtModelsize.setVisible(false);

        txtPoints.setText("Race");
        txtMovement.setText("Strength");
        txtCloseCombat.setText("ROA");
        txtRangedSkill.setText("AVV");

        txtMovement.setVisible(true);
        txtCloseCombat.setVisible(true);
        txtRangedSkill.setVisible(true);

        txtStrength.setVisible(false);
        txtConditions.setVisible(false);
        txtWounds.setVisible(false);
        txtArmorValue.setVisible(false);

        laLongText.setVisible(false);

        laMovement.setVisible(true);
        laType.setVisible(true);
        laStrength.setVisible(true);
        laCloseCombat.setVisible(true);
        laRangedSkill.setVisible(true);
        laPoints.setVisible(true);
        laModelsize.setVisible(false);
        laConditions.setVisible(false);
        laStrength.setVisible(false);
        laWounds.setVisible(false);
        laArmorValue.setVisible(false);
    }

    // Dialogaufbau anhand der Auswahl von TreeView
    private void longText()
    {
        //laLongText.setText("Ability");
        laLongText.setVisible(true);

        txtPoints.setVisible(false);
        txtType.setVisible(false);
        txtModelsize.setVisible(false);
        txtMovement.setVisible(false);
        txtRangedSkill.setVisible(false);
        txtCloseCombat.setVisible(false);
        txtConditions.setVisible(false);
        txtStrength.setVisible(false);
        txtConditions.setVisible(false);
        txtWounds.setVisible(false);
        txtArmorValue.setVisible(false);


        laName.setVisible(true);
        laType.setVisible(false);
        laPoints.setVisible(false);
        laModelsize.setVisible(false);
        laMovement.setVisible(false);
        laRangedSkill.setVisible(false);
        laCloseCombat.setVisible(false);
        laConditions.setVisible(false);
        laStrength.setVisible(false);
        laWounds.setVisible(false);
        laArmorValue.setVisible(false);



    }



    //Create branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }


    // Zurück ins Hauptmenü
    public void btnMainMenuClicked(ActionEvent event) throws Exception
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
