package awk.persistence.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Einheit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 70) private String name;
    @Column(length = 10) private String type;               // HQ, Elite, Sturm, Standard
    @Column(length = 10) private String punkte;
    @Column(length = 50) private String modelSize;
    @Column(length = 10) private String movement;
    @Column(length = 10) private String closeCombat;
    @Column(length = 10) private String rangedSkill;
    @Column(length = 10) private String strength;
    @Column(length = 10) private String conditions;
    @Column(length = 10) private String wounds;
    @Column(length = 10) private String armorValue;
    @Column(length = 10) private String leadership;

    /*

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

    public String getPunkte() {
        return punkte;
    }

    public void setPunkte(String punkte) {
        this.punkte = punkte;
    }

*/
}
