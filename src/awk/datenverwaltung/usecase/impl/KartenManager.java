package awk.datenverwaltung.usecase.impl;


import awk.persistence.IDatenverwaltungDAO;
import awk.persistence.entity.Strategiekarte;
import awk.persistence.entity.Umgebungskarte;
import awk.persistence.impl.DatenverwaltungDAO;

import java.util.List;

public class KartenManager
{
    private IDatenverwaltungDAO einDatenverwalter = new DatenverwaltungDAO();


    public void umgebungskarteHinzufuegen(Umgebungskarte var2)
    {
        this.einDatenverwalter.anlegen(var2);
    }

    public void strategiekarteHinzufuegen(Strategiekarte var3)
    {
        this.einDatenverwalter.anlegen(var3);
    }


    public List<Strategiekarte> strategiekarteSuchenPerID(int id)
    {
       List<Strategiekarte> foundKarte = this.einDatenverwalter.showStrategiekarteWithID(id);

       return foundKarte;
    }


    public List<Umgebungskarte> umgebungskarteSuchenPerID(int id)
    {
        List<Umgebungskarte> foundKarte = this.einDatenverwalter.showUmgebungskarteWithID(id);

        return foundKarte;
    }


    public List<Strategiekarte> strategiekarteSuchen(String name)
    {
        List<Strategiekarte> foundKarte = this.einDatenverwalter.showStrategiekartenWithName(name);

        return foundKarte;
    }


    public List<Umgebungskarte> umgebungskarteSuchen(String name)
    {
        List<Umgebungskarte> foundKarte = this.einDatenverwalter.showUmgebungskarteWithName(name);

        return foundKarte;
    }
}
