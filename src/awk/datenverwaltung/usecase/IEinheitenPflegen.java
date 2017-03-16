package awk.datenverwaltung.usecase;


public interface IEinheitenPflegen
{

    boolean marineHinzufuegen(String name,
                              String type,
                              String punkte,
                              String movement,
                              String modelSize,
                              String closeCombat,
                              String rangedSkill,
                              String strength,
                              String conditions,
                              String wounds,
                              String armorValue,
                              String leadership);

    boolean alienHinzufuegen(String name,
                             String type,
                             String punkte,
                             String modelSize,
                             String movement,
                             String closeCombat,
                             String rangedSkill,
                             String strength,
                             String conditions,
                             String wounds,
                             String armorValue,
                             String leadership);

    boolean predatorHinzufuegen(String name,
                                String type,
                                String punkte,
                                String modelSize,
                                String movement,
                                String closeCombat,
                                String rangedSkill,
                                String strength,
                                String conditions,
                                String wounds,
                                String armorValue,
                                String leadership);



    boolean UnitAbilityHinzufuegen(String name, String beschreibung, String race, String einheit);

}



