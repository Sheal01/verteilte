package awk.datenverwaltung.usecase.impl;


import awk.datenverwaltung.usecase.IKarteSuchen;
import awk.persistence.entity.Strategiekarte;
import awk.persistence.entity.Umgebungskarte;

import java.util.ArrayList;
import java.util.List;

public class KarteSuchen implements IKarteSuchen
{
    KartenManager km = new KartenManager();

    private int marineid = 1;
    private int alienid = 21;
    private int predid = 41;


    public List<Strategiekarte> showMarineStrategiekarten(int id)
    {
        List<Strategiekarte> foundKarte = new ArrayList<>();

        marineid =marineid + id;

        if (marineid >= 22)
        {
            return foundKarte;
        }

        foundKarte = km.strategiekarteSuchenPerID(marineid);

        return foundKarte;
    }

    public List<Strategiekarte> showAlienStrategiekarten(int id)
    {
        List<Strategiekarte> foundKarte = new ArrayList<>();

        alienid = alienid + id;

        if (alienid >= 42)
        {
            return foundKarte;
        }

        foundKarte = km.strategiekarteSuchenPerID(alienid);

        return  foundKarte;
    }



    public List<Strategiekarte> showPredStrategiekarten(int id)
    {
        List<Strategiekarte> foundKarte = new ArrayList<>();

        predid = predid + id;

        if (predid >= 62)
        {
            return foundKarte;
        }

        foundKarte = km.strategiekarteSuchenPerID(predid);

        return foundKarte;
    }


    public List<Umgebungskarte> showUmgebungskarten(int id)
    {
        List<Umgebungskarte> foundKarte = km.umgebungskarteSuchenPerID(id);

        return  foundKarte;
    }


    public List<Strategiekarte> showStrategiekarten(String name)
    {
        List<Strategiekarte> foundKarte = km.strategiekarteSuchen(name);

        return foundKarte;
    }


    public List<Umgebungskarte> showUmgebungskarten(String name)
    {
        List<Umgebungskarte> foundKarte = km.umgebungskarteSuchen(name);

        return foundKarte;
    }

}
