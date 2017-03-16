package awk.datenverwaltung.usecase.impl;

import awk.persistence.IDatenverwaltungDAO;
import awk.persistence.entity.Ability;
import awk.persistence.entity.Alien;
import awk.persistence.entity.Marines;
import awk.persistence.entity.Predator;
import awk.persistence.impl.DatenverwaltungDAO;

import java.util.List;

public class EinheitenManager
{
    private IDatenverwaltungDAO einDatenverwalter = new DatenverwaltungDAO();

    public EinheitenManager() {}


    public void marineHinzufuegen(Marines var1)
    {
        this.einDatenverwalter.anlegen(var1);
    }

    public void alienHinzufuegen(Alien var2)
    {
        this.einDatenverwalter.anlegen(var2);
    }

    public void predatorHinzufuegen(Predator var3)
    {
        this.einDatenverwalter.anlegen(var3);
    }


    public List<Marines> showAllMarines()
    {
        List<Marines> foundMarines = this.einDatenverwalter.showAllMarines();

        return foundMarines;
    }

    public List<Marines> getMarineNames()
    {
        List<Marines> foundMarines = this.einDatenverwalter.getMarineNames();

        return foundMarines;
    }

    public List<Alien> getAlienNames()
    {
        List<Alien> foundAliens = this.einDatenverwalter.getAlienNames();

        return foundAliens;
    }

    public List<Predator> getPredNames()
    {
        List<Predator> foundPreds = this.einDatenverwalter.getPredNames();

        return foundPreds;
    }


    public void abilityHinzufuegen(Ability var4)
    {
        this.einDatenverwalter.anlegen(var4);
    }

    public List<Marines> getMarineWithID(int id)
    {
        List<Marines> m = this.einDatenverwalter.showMarinesWithID(id);

        return m;
    }

    public List<Alien> getAlienWithID(int id)
    {
        List<Alien> foundAlien = this.einDatenverwalter.showAlienWithID(id);

        return foundAlien;
    }

    public List<Predator> getPredatorWithID(int id)
    {
        List<Predator> foundPred = this.einDatenverwalter.showPredWithId(id);

        return foundPred;
    }




    public List<Marines> marineNameSearch(String name)
    {
        List<Marines> foundMarines = this.einDatenverwalter.searchMarineWithName(name);

        return foundMarines;
    }


    public List<Alien> alienNameSearch(String name)
    {
        List<Alien> foundAlien = this.einDatenverwalter.searchAlienWithName(name);

        return foundAlien;
    }


    public List<Predator> predNameSearch(String name)
    {
        List<Predator> foundPred = this.einDatenverwalter.searchPredWithName(name);

        return foundPred;
    }

}
