package awk.datenverwaltung.usecase.impl;


import awk.datenverwaltung.usecase.IKartenPflegen;
import awk.persistence.entity.Strategiekarte;
import awk.persistence.entity.Umgebungskarte;

public class KartenPflegen implements IKartenPflegen
{

    public boolean strategiekarteAnlegen(String name, String rasse, String beschreibung)
    {
        KartenManager km = new KartenManager();

        Strategiekarte skarte = new Strategiekarte(name, rasse, beschreibung);

        km.strategiekarteHinzufuegen(skarte);

        return true;
    }


    public boolean umgebungskarteAnlegen(String name, String beschreibung)
    {
        KartenManager km = new KartenManager();

        Umgebungskarte ukarte = new Umgebungskarte(name, beschreibung);

        km.umgebungskarteHinzufuegen(ukarte);

        return true;
    }

}
