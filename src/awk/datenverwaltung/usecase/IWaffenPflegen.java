package awk.datenverwaltung.usecase;


public interface IWaffenPflegen
{

    boolean waffeAnlegen(String name, String type, String race, String strength, String roa, String avv);

    boolean waffenAbilityAnlegen(String name, String beschreibung, String race, String waffenid);

    boolean waffeAendern(String name, String type, String  race, String strength, String roa, String avv);
}
