package awk.datenverwaltung.usecase.impl;

import awk.datenverwaltung.usecase.IWaffenPflegen;
import awk.persistence.entity.Ability;
import awk.persistence.entity.Waffen;

public class WaffenPflegen implements IWaffenPflegen
{
    WaffenManager waffenManager = new WaffenManager();

    public WaffenPflegen() {}

    public boolean waffeAnlegen(String name, String type, String race, String strength, String roa, String avv)
    {
        Waffen waffe = new Waffen(name, type, race, strength, roa,avv);

        waffenManager.waffeHinzufuegen(waffe);

        return true;
    }




    public boolean waffenAbilityAnlegen(String name, String beschreibung, String race, String waffenid)
    {

        Ability ability = new Ability(name, beschreibung, race, waffenid);

        waffenManager.waffenAbilityHinzufuegen(ability);

        return true;

    }
// change void to boolean
    public boolean waffeAendern(String name, String type, String  race, String strength, String roa, String avv)
    {
        Waffen waffe = new Waffen(name, type, race, strength, roa, avv);

        boolean ok = waffenManager.changeWaffe(waffe);

        return ok;


    }



}
