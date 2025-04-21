package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J.
 * 
 * Class: Basic Stat Manager
 *  public
 * 
 * Responsibilities:
 *  Manages the stats, variables, and possible bonuses for the specified character sheet
 * 
 * Collaborators:
 *  CharacterSheet and MenuManager
 * 
 * Methods:
 *  Attributes
 *      private
 *      Holds and manipulates the basic DND stats such as Strength, Wisdom, Charisma, Intelligence, Constitution, and Dexterity
 *  Saving Throws
 *      private
 *      Calculates and stores the values for saving throws, related to basic stats
 *  Skills:
 *      private
 *      Holds all DND skills for a character, an example is Acrobatics.
 */
import java.io.Serializable;

public class BasicStatManager implements Serializable {
     private static final long serialVersionUID = 1L;
    private int playerLevel = 1;

    // Core Attributes
    private int strength = 10;
    private int dexterity = 10;
    private int constitution = 10;
    private int intelligence = 10;
    private int wisdom = 10;
    private int charisma = 10;
    
    // Proficiency System
    private int proficiencyBonus = (int) (Math.ceil(playerLevel/4) + 2);
    private boolean[] skillProficiencies = new boolean[19];
    
    // Skill indices (matches D&D 5e skill order)
    public static final int ATHLETICS = 0;
    public static final int ACROBATICS = 1;
    public static final int SLEIGHT_OF_HAND = 2;
    public static final int STEALTH = 3;
    public static final int ARCANA = 4;
    public static final int HISTORY = 5;
    public static final int INVESTIGATION = 6;
    public static final int NATURE = 7;
    public static final int RELIGION = 8;
    public static final int ANIMAL_HANDLING = 9;
    public static final int INSIGHT = 10;
    public static final int MEDICINE = 11;
    public static final int PERCEPTION = 12;
    public static final int SURVIVAL = 13;
    public static final int DECEPTION = 14;
    public static final int INTIMIDATION = 15;
    public static final int PERFORMANCE = 16;
    public static final int PERSUASION = 17;
    public static final int FORTITUDE = 18;

    public BasicStatManager() {
        // initialize all proficiencies to false by default
        for(int i = 0; i < skillProficiencies.length; i++) {
            skillProficiencies[i] = false;
        }
    }
    
    public void setLevel(int level)
    {
       playerLevel = level; 
        
    }
    public int getLevel(){
        return playerLevel;
    }

    // attribute getters+setters
    public int getStrength() { return strength; }
    public void setStrength(int strength) {
        validateAttribute(strength);
        this.strength = strength;
    }

    public int getDexterity() { return dexterity; }
    public void setDexterity(int dexterity) {
        validateAttribute(dexterity);
        this.dexterity = dexterity;
    }
    
    public int getConstitution() { return constitution; }
    public void setConstitution(int constitution) {
        validateAttribute(constitution);
        this.constitution = constitution;
    }
    
    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int intelligence) {
        validateAttribute(intelligence);
        this.intelligence = intelligence;
    }
    
    public int getWisdom() { return wisdom; }
    public void setWisdom(int wisdom) {
        validateAttribute(wisdom);
        this.wisdom = wisdom;
    }
    
    public int getCharisma() { return charisma; }
    public void setCharisma(int charisma) {
        validateAttribute(charisma);
        this.charisma = charisma;
    }
    
    // proficiency 
    public int getProficiencyBonus() { return proficiencyBonus; }
    public void setProficiencyBonus(int bonus) {
        if(bonus < 0) throw new IllegalArgumentException("Proficiency bonus cannot be negative");
        this.proficiencyBonus = bonus;
    }

    public boolean isProficient(int skillIndex) {
        return skillProficiencies[skillIndex];
    }

    public void setProficiency(int skillIndex, boolean proficient) {
        skillProficiencies[skillIndex] = proficient;
    }

    // Skill Calculations
    public int getSkillValue(int skillIndex) {
        int baseModifier = 0;
        boolean proficient = skillProficiencies[skillIndex];
        
        switch(skillIndex) {
            // STR-based
            case ATHLETICS:
                baseModifier = calculateModifier(strength);
                break;
            case FORTITUDE:
                baseModifier = calculateModifier(strength);
                
            // DEX-based
            case ACROBATICS:
                baseModifier = calculateModifier(dexterity);
                break;
            case SLEIGHT_OF_HAND:
                baseModifier = calculateModifier(dexterity);
                break;
            case STEALTH:
                baseModifier = calculateModifier(dexterity);
                break;
                
            // INT-based
            case ARCANA:
                baseModifier = calculateModifier(intelligence);
                break;
            case HISTORY:
                baseModifier = calculateModifier(intelligence);
                break;
            case INVESTIGATION:
                baseModifier = calculateModifier(intelligence);
                break;
            case NATURE:
                baseModifier = calculateModifier(intelligence);
                break;
            case RELIGION:
                baseModifier = calculateModifier(intelligence);
                break;
                
            // WIS-based
            case ANIMAL_HANDLING:
                baseModifier = calculateModifier(wisdom);
                break;
            case INSIGHT:
                baseModifier = calculateModifier(wisdom);
                break;
            case MEDICINE:
                baseModifier = calculateModifier(wisdom);
                break;
            case PERCEPTION:
                baseModifier = calculateModifier(wisdom);
                break;
            case SURVIVAL:
                baseModifier = calculateModifier(wisdom);
                break;
                
            // CHA-based
            case DECEPTION:
                baseModifier = calculateModifier(charisma);
                break;
            case INTIMIDATION:
                baseModifier = calculateModifier(charisma);
                break;
            case PERFORMANCE:
                baseModifier = calculateModifier(charisma);
                break;
            case PERSUASION:
                baseModifier = calculateModifier(charisma);
                break;
                
            default:
                throw new IllegalArgumentException("Invalid skill index");
        }
        
        return baseModifier + (proficient ? proficiencyBonus : 0);
    }

    // modifier calculation
    private int calculateModifier(int abilityScore) {
        return (int) Math.floor((abilityScore - 10) / 2);
    }

    private void validateAttribute(int value) {
        if(value < 1 || value > 30) {
            throw new IllegalArgumentException("Ability scores must be between 1 and 30");
        }
    }

    // getters for UI 
    public int getStrengthModifier() { return calculateModifier(strength); }
    public int getDexterityModifier() { return calculateModifier(dexterity); }
    public int getConstitutionModifier() { return calculateModifier(constitution); }
    public int getIntelligenceModifier() { return calculateModifier(intelligence); }
    public int getWisdomModifier() { return calculateModifier(wisdom); }
    public int getCharismaModifier() { return calculateModifier(charisma); }
    
    public void getBaseStats() {
        getStrengthModifier();
        getDexterityModifier();
        getConstitutionModifier();
        getIntelligenceModifier();
        getWisdomModifier();
        getCharismaModifier();
    }
    
    public int setStrength() {
        return 0; 
    }
}