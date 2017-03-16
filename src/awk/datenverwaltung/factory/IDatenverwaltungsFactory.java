package awk.datenverwaltung.factory;


import awk.datenverwaltung.usecase.*;

public interface IDatenverwaltungsFactory
{

    IWaffenPflegen getWaffenPflegen();
    IKartenPflegen getKartenPflegen();
    IEinheitenPflegen getEinheitenPflegen();

    IEinheitSuchen getEinheitenSuchen();
    IWaffeSuchen getWaffeSuchen();
    IKarteSuchen getKarteSuchen();
}
