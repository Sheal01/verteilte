package awk.datenverwaltung.factory.impl;


import awk.datenverwaltung.factory.IDatenverwaltungsFactory;
import awk.datenverwaltung.usecase.*;
import awk.datenverwaltung.usecase.impl.*;

public class DatenverwaltungsFactory implements IDatenverwaltungsFactory
{

    public DatenverwaltungsFactory() {}


    public IWaffenPflegen getWaffenPflegen()
    {
        return new WaffenPflegen();
    }

    public IKartenPflegen getKartenPflegen()
    {
        return new KartenPflegen();
    }

    public IEinheitenPflegen getEinheitenPflegen()
    {
        return new EinheitenPflegen();
    }



    public IEinheitSuchen getEinheitenSuchen()
    {
        return new EinheitSuchen();
    }

    public IWaffeSuchen getWaffeSuchen(){return new WaffeSuchen();}

    public IKarteSuchen getKarteSuchen() {return new KarteSuchen();}



}
