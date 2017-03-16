package awk.persistence.entity;

import javax.persistence.*;


@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Waffen
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String race;    // Marine, Alien oder Pred
    private String type;    // Nahkampf, oder Fernkampf
    private String strength;
    private String roa;     // Anzahl der Schüsse
    private String avv;     // Anti vehicle value


    public Waffen() {}

    public Waffen(String name, String type, String race, String strength, String roa, String avv) {
        this.name = name;
        this.type = type;
        this.race = race;
        this.strength = strength;
        this.roa = roa;
        this.avv = avv;
    }


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getRoa() {
        return roa;
    }

    public void setRoa(String roa) {
        this.roa = roa;
    }

    public String getAvv() {
        return avv;
    }

    public void setAvv(String avv) {
        this.avv = avv;
    }

}
