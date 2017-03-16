package awk.datenverwaltung.usecase.impl;

import awk.datenverwaltung.usecase.IWaffeSuchen;
import awk.persistence.entity.Waffen;

import java.util.ArrayList;
import java.util.List;

public class WaffeSuchen implements IWaffeSuchen
{
    WaffenManager wm = new WaffenManager();

    private int alien_id = 15;
    private int marines_id = 0;
    private int predator_id = 26;

    public List<Waffen> showAllWeaponsPerRace(String race)
    {

        List<Waffen> foundWaffen = wm.waffenSuchenNachRasse(race);

        return foundWaffen;
    }


    public List<Waffen> showAlienWeaponsPerID(int id)
    {
        List<Waffen> foundWaffen = new ArrayList<>();

        alien_id = alien_id + id;
        if (alien_id >= 27)
        {
            return foundWaffen;
        }

        foundWaffen = wm.waffenSuchenPerID(alien_id);



        return foundWaffen;
    }


    public List<Waffen> showMarinesWeaponsPerID(int id)
    {
        List<Waffen> foundWaffen = new ArrayList<>();

        marines_id = marines_id + id;
        if (marines_id >= 15)
        {
            return foundWaffen;

        }

        foundWaffen = wm.waffenSuchenPerID(marines_id);

        return foundWaffen;
    }


    public List<Waffen> showPredWeaponsPerID(int id)
    {
        List<Waffen> foundWaffen = new ArrayList<>();

        predator_id = predator_id + id;
        if (predator_id >= 40)
        {
            return foundWaffen;
        }

        foundWaffen = wm.waffenSuchenPerID(predator_id);

        return foundWaffen;
    }


    public List<Waffen> showWaffeWithName(String name)
    {
        List<Waffen> foundWaffen = wm.waffenSuchenPerName(name);

        return foundWaffen;
    }

}
