package awk.datenverwaltung.usecase;

import awk.persistence.entity.Waffen;

import java.util.List;

public interface IWaffeSuchen
{
    List<Waffen> showAllWeaponsPerRace(String race);


    List<Waffen> showAlienWeaponsPerID(int id);
    List<Waffen> showMarinesWeaponsPerID(int id);
    List<Waffen> showPredWeaponsPerID(int id);

    List<Waffen> showWaffeWithName(String name);



}
