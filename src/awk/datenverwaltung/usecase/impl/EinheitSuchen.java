package awk.datenverwaltung.usecase.impl;

import awk.datenverwaltung.usecase.IEinheitSuchen;
import awk.persistence.entity.Alien;
import awk.persistence.entity.Marines;
import awk.persistence.entity.Predator;

import java.util.List;

public class EinheitSuchen implements IEinheitSuchen
{
    EinheitenManager einheitenManager = new EinheitenManager();

    public List<Marines> showAllMarines()
    {

        List<Marines> foundMarines = einheitenManager.showAllMarines();

        return foundMarines;
    }


    public List<Marines> getMarineNames()
    {
        List<Marines> foundMarines = einheitenManager.getMarineNames();

        return foundMarines;
    }

    public List<Alien> getAlienNames()
    {
        List<Alien> foundAliens = einheitenManager.getAlienNames();

        return foundAliens;
    }

    public List<Predator> getPredatorNames()
    {
        List<Predator> foundPreds = einheitenManager.getPredNames();

        return foundPreds;
    }

    public List<Marines> showMarinesPerID(int id)
    {
        List<Marines> foundMarine = einheitenManager.getMarineWithID(id);

        return foundMarine;
    }

    public List<Alien> showAlienPerID(int id)
    {
        List<Alien> foundAlien = einheitenManager.getAlienWithID(id);

        return foundAlien;
    }

    public List<Predator> showPredatorPerID(int id)
    {
        List<Predator> foundPred = einheitenManager.getPredatorWithID(id);

        return foundPred;
    }



    public List<Marines> searchMarinePerName(String name)
    {
        List<Marines> found = einheitenManager.marineNameSearch(name);

        return found;
    }

    public List<Alien> searchAlienPerName(String name)
    {
        List<Alien> foundAlien = einheitenManager.alienNameSearch(name);

        return foundAlien;
    }


    public List<Predator> searchPredPerName(String name)
    {
        List<Predator> foundpred = einheitenManager.predNameSearch(name);

        return foundpred;
    }



}
