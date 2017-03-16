package awk.persistence.entity;

import javax.persistence.*;

@Entity
public class Umgebungskarte
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50) private String name;
    @Column(length = 500) private String inhalt;


    public Umgebungskarte(){}

    public Umgebungskarte(String name, String inhalt) {
        this.name = name;
        this.inhalt = inhalt;
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
}
