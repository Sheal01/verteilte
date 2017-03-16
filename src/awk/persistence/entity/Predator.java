package awk.persistence.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Predator")
public class Predator extends Einheit
{

    private int id;

    private String name;
    private String type; // HQ, Elite, Sturm, Standard
    private String punkte;
    private String modelSize;
    private String movement;
    private String closeCombat;
    private String rangedSkill;
    private String strength;
    private String conditions;
    private String wounds;
    private String armorValue;
    private String leadership;




    public Predator()
    {}

    public Predator(String name,
                    String type,
                    String modelSize,
                    String movement,
                    String closeCombat,
                    String rangedSkill,
                    String strength,
                    String conditions,
                    String wounds,
                    String armorValue,
                    String leadership,
                    String punkte
    )
    {
        this.name = name;
        this.type = type;
        this.punkte = punkte;
        this.modelSize = modelSize;
        this.movement = movement;
        this.closeCombat = closeCombat;
        this.rangedSkill = rangedSkill;
        this.strength = strength;
        this.conditions = conditions;
        this.wounds = wounds;
        this.armorValue = armorValue;
        this.leadership = leadership;
        this.punkte = punkte;


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

    public String getPunkte() {
        return punkte;
    }

    public void setPunkte(String punkte) {
        this.punkte = punkte;
    }

    public String getModelSize() {
        return modelSize;
    }

    public void setModelSize(String modelSize) {
        this.modelSize = modelSize;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getCloseCombat() {
        return closeCombat;
    }

    public void setCloseCombat(String closeCombat) {
        this.closeCombat = closeCombat;
    }

    public String getRangedSkill() {
        return rangedSkill;
    }

    public void setRangedSkill(String rangedSkill) {
        this.rangedSkill = rangedSkill;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getWounds() {
        return wounds;
    }

    public void setWounds(String wounds) {
        this.wounds = wounds;
    }

    public String getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(String armorValue) {
        this.armorValue = armorValue;
    }

    public String getLeadership() {
        return leadership;
    }

    public void setLeadership(String leadership) {
        this.leadership = leadership;
    }
}
