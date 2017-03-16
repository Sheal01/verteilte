package awk.datenverwaltung.usecase.impl;

import awk.persistence.IDatenverwaltungDAO;
import awk.persistence.entity.Ability;
import awk.persistence.entity.Waffen;
import awk.persistence.impl.DatenverwaltungDAO;

import java.util.List;



public class WaffenManager
{
    private IDatenverwaltungDAO einDatenverwalter = new DatenverwaltungDAO();

    public WaffenManager() {}



    public void waffeHinzufuegen(Waffen var1)
    {
        this.einDatenverwalter.anlegen(var1);
    }


    public List<Waffen> waffenSuchenNachRasse(String rasse)
    {
        List<Waffen> foundWeaponsList = this.einDatenverwalter.getAllWeaponsPerRace(rasse);

        return foundWeaponsList;
    }


    public void waffenAbilityHinzufuegen(Ability ability)
    {
        this.einDatenverwalter.anlegen(ability);
    }


    public List<Waffen> waffenSuchenPerID(int id)
    {
        List<Waffen> foundWaffen = this.einDatenverwalter.showAlienWeaponWithID(id);

        return foundWaffen;
    }


    public List<Waffen> waffenSuchenPerName(String name)
    {
        List<Waffen> foundWaffen = this.einDatenverwalter.showWaffeWithName(name);

        return foundWaffen;
    }


    public boolean changeWaffe(Waffen waffe)
    {
        boolean ok =this.einDatenverwalter.changeWeapon(waffe);

        return ok;
    }

}
