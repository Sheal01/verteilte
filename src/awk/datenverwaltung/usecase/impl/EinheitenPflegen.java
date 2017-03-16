package awk.datenverwaltung.usecase.impl;


import awk.datenverwaltung.usecase.IEinheitenPflegen;
import awk.persistence.entity.Ability;
import awk.persistence.entity.Alien;
import awk.persistence.entity.Marines;
import awk.persistence.entity.Predator;

public class EinheitenPflegen implements IEinheitenPflegen
{
    public EinheitenPflegen() {}


    public boolean marineHinzufuegen(String name,
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
                                     String leadership)
    {
        EinheitenManager em = new EinheitenManager();

        Marines marine = new Marines(name, type, punkte, movement, modelSize, closeCombat, rangedSkill, strength, conditions, wounds, armorValue, leadership );

        em.marineHinzufuegen(marine);


        return true;
    }

    public boolean alienHinzufuegen(String name,
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
                                    String leadership)
    {
        EinheitenManager em = new EinheitenManager();

        Alien alien = new Alien(name, type, punkte, modelSize, movement, closeCombat, rangedSkill, strength, conditions, wounds, armorValue, leadership );

        em.alienHinzufuegen(alien);


        return true;
    }


    public boolean predatorHinzufuegen(String name,
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
                                       String leadership)
    {
        EinheitenManager em = new EinheitenManager();

        Predator pred = new Predator(name, type, punkte, modelSize, movement, closeCombat, rangedSkill, strength, conditions, wounds, armorValue, leadership);

        em.predatorHinzufuegen(pred);


        return true;
    }


    public boolean UnitAbilityHinzufuegen(String name, String beschreibung, String race, String einheit)
    {
        EinheitenManager em = new EinheitenManager();

        Ability ability = new Ability();

        ability.setName(name);
        ability.setBeschreibung(beschreibung);
        ability.setRace(race);
        ability.setEinheit_name(einheit);

        em.abilityHinzufuegen(ability);


        return true;
    }







}
