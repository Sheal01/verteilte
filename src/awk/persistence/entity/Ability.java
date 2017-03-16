package awk.persistence.entity;


import javax.persistence.*;


@Entity
public class Ability
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String beschreibung;
    private String race;
    private String waffen_name;
    private String einheit_name;


//    @ManyToOne
//     private String einheit

/*
    @ManyToOne
    private Einheit einheit;
*/

    public Ability() {}


    // Für Waffenspezifische Sonderregeln
    public Ability(String name, String beschreibung, String race, String waffenid)
    {
        this.name = name;
        this.beschreibung = beschreibung;
        this.race = race;
        this.waffen_name = waffenid;
    }


    // Für rassenspezifische Sonderregeln
    public Ability(String name, String beschreibung, String race)
    {
        this.name = name;
        this.beschreibung = beschreibung;
        this.race = race;
    }

/*
    // Für Einheitenspezifische Sonderregeln
    public Ability(String name, String beschreibung, String race, String einheit)
    {
        this.name = name;
        this.beschreibung = beschreibung;
        this.race = race;
        this.einheit_name = einheit;
    }
*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getWaffen_name() {
        return waffen_name;
    }

    public void setWaffen_name(String waffen_name) {
        this.waffen_name = waffen_name;
    }

    public String getEinheit_name() {
        return einheit_name;
    }

    public void setEinheit_name(String einheit_name) {
        this.einheit_name = einheit_name;
    }
}

