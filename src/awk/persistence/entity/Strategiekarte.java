package awk.persistence.entity;

import javax.persistence.*;

@Entity
public class Strategiekarte
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50) private String name;
    @Column(length = 500) private String inhalt;
    @Column(length = 50) private String race;

    public Strategiekarte() {}

    public Strategiekarte(String name, String race, String inhalt)
    {
        this.name = name;
        this.inhalt = inhalt;
        this.race = race;
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

    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
