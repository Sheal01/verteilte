package awk.persistence;


import awk.persistence.entity.*;

import java.util.Collection;
import java.util.List;

public interface IDatenverwaltungDAO
{
    void anlegen(Object var0);

    List<Marines> showAllMarines();

    List<Marines> showMarinesWithID(int id);
    List<Alien> showAlienWithID(int id);
    List<Predator> showPredWithId(int id);

    // Für alle Waffenaufrufe mit ID
    List<Waffen> showAlienWeaponWithID(int id);

    List<Strategiekarte> showStrategiekarteWithID(int id);
    List<Umgebungskarte> showUmgebungskarteWithID(int id);

    List<Strategiekarte> showStrategiekartenWithName(String name);
    List<Umgebungskarte> showUmgebungskarteWithName(String name);

    List<Waffen> showWaffeWithName(String name);

    List<Waffen> getAllWeaponsPerRace(String race);

    List<Marines> getMarineNames();
    List<Alien> getAlienNames();
    List<Predator> getPredNames();

    List<Marines> searchMarineWithName(String name);
    List<Alien> searchAlienWithName(String name);
    List<Predator> searchPredWithName(String name);


    boolean changeWeapon(Waffen waffe);






}
