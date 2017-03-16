package awk.datenverwaltung.usecase;


public interface IKartenPflegen
{
    boolean strategiekarteAnlegen(String name, String rasse, String beschreibung);

    boolean umgebungskarteAnlegen(String name, String beschreibung);

}
