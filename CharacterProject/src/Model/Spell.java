package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ellie R.
 */
public class Spell {
    private String name;
    private int level;
    private String effect;
    private String stat;
    private Boolean save;
    private Boolean roll;

    // constructor
    public Spell(String name, int level, String effect, String stat, 
                Boolean save, Boolean roll) {
        this.name = name;
        this.level = level;
        this.effect = effect;
        this.stat = stat;
        this.save = save;
        this.roll = roll;
    }

        public Spell() {
        this.name = "Nameless Spell";
        this.level = 1;
        this.effect = "add info here";
        this.stat = "INT";
        this.save = false;
        this.roll = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }

    public Boolean getRoll() {
        return roll;
    }

    public void setRoll(Boolean roll) {
        this.roll = roll;
    }
}
