package Model;


import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner; // For user I/O

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Robert J., N Arango
 * @version %I%
 * @since 1.0
 */
public class CharacterSheet implements Serializable {
    private static final long serialVersionUID = 1L;
    private String characterName;
    private final BasicStatManager basicStats;
    private final Inventory inventory;
    private final PlayerState playerState;
    private final SpellBook spellBook;
    
    /**
     * Opens all relevant information regarding the charcter
     * This includess the the character's stats, inventory, spells, and player state
     * 
     * @param name 
     */
    public CharacterSheet(String name) {
        this.characterName = Objects.requireNonNull(name, "Character must have a name");
        this.basicStats = new BasicStatManager();
        this.inventory = new Inventory();
        this.playerState = new PlayerState();
        this.spellBook = new SpellBook();
    }

    public String getCharacterName() { return characterName; }
    public void setCharacterName(String name){
        characterName = name;
    }
    public BasicStatManager getBaseStats() { return basicStats; }
    public Inventory getInventory() { return inventory; }
    public PlayerState getPlayerState() { return playerState; }
    public SpellBook getSpellBook() { return spellBook; }
    
    
    // Sets the Basic Stat values in BasicStatManager based on user input
    public void initializeBaseStats() {
        Scanner in = new Scanner(System.in);
        System.out.print("Give your strength value between 1-30: ");
        
        // Goes to the embedded prompt function to get the user-inputed value
        basicStats.setStrength(prompt("Enter Strength(1-30):", in, 1, 30));
        basicStats.setDexterity(prompt("Enter Dexterity(1-30):", in, 1, 30));
        basicStats.setConstitution(prompt("Enter Constitution(1-30):", in, 1, 30));
        basicStats.setIntelligence(prompt("Enter Intelligence(1-30):", in, 1, 30));
        basicStats.setWisdom(prompt("Enter Wisdom(1-30):", in, 1, 30));
        basicStats.setCharisma(prompt("Enter Charisma(1-30):", in, 1, 30));
    }
    
    // Prompt function for new Character base stats
    private int prompt(String label, Scanner in, int min, int max) {
        int val = 0;
        
        do {
            System.out.print(label);
            while (!in.hasNextInt()) {
                System.out.print("  → Please enter a number: ");
                in.next();
            }
            val = in.nextInt();
        } while (val < min || val > max);
        in.nextLine(); // consume end‑of‑line
        return val;
    }
    
    public void setStrength(int i){
        basicStats.setStrength(i);
    }
    
    public int getStrength(){
        int i = basicStats.getStrength();
        return i;
    }
    
    public void setDexterity(int i){
        basicStats.setDexterity(i);
    }
    
    public int getDexterity(){
        int i = basicStats.getDexterity();
        return i;
    }
    
    public void setConstitution(int i){
        basicStats.setConstitution(i);
    }
    
    public int getConstitution(){
        int i = basicStats.getConstitution();
        return i;
    }
    
    public void setIntelligence(int i){
        basicStats.setIntelligence(i);
    }
    
    public int getIntelligence(){
        int i = basicStats.getIntelligence();
        return i;
    }
    
    public void setWisdom(int i){
        basicStats.setWisdom(i);
    }
    
    public int getWisdom(){
        int i = basicStats.getWisdom();
        return i;
    }
    
    public void setCharisma(int i){
        basicStats.setCharisma(i);
    }
    
    public int getCharisma(){
        int i = basicStats.getCharisma();
        return i;
    }
    
    public void setMaxHealth(int i){
        playerState.setMaxHealth(i);
    }
    
    public int getMaxHealth(){
        int i = playerState.getMaxHealth();
        return i;
    }
    
    public void setCurrentHealth(int i){
        playerState.setCurrentHealth(i);
    }
    
    public int getCurrentHealth(){
        int i = playerState.getCurrentHealth();
        return i;
    }
    
    public void setLevel(int i){
        basicStats.setLevel(i);
    }
    
    public int getLevel(){
        int i = basicStats.getLevel();
        return i;
    }
    
    public void setExperience(int i){
        basicStats.setExperience(i);
    }
    
    public int getExperience(){
        int i = basicStats.getExperience();
        return i;
    }
    
    public int getSkillValue(int i){
        int j = basicStats.getSkillValue(i);
        return j;
    }
    
    public void setProficiency(int i, boolean state){
        basicStats.setProficiency(i, state);
    }
    
    public boolean isProficient(int i){
        return basicStats.isProficient(i);
    }
    
    public boolean[] returnProf(){
        return basicStats.returnProf();
    }
    
    public int getSkillProf(int key){
        int j;
        switch (key){
            case 1 -> j = basicStats.getStrengthModifier();
            case 2 -> j = basicStats.getDexterityModifier();
            case 3 -> j = basicStats.getConstitutionModifier();
            case 4 -> j = basicStats.getIntelligenceModifier();
            case 5 -> j = basicStats.getWisdomModifier();
            case 6 -> j = basicStats.getCharismaModifier();
            default -> j = 0;
        }
        return j;
    }
}
