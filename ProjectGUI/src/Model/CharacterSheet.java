package Model;


import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner; // For user I/O

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J.
 */

    public class CharacterSheet implements Serializable {
    private static final long serialVersionUID = 1L;
    private String characterName;
    private final BasicStatManager basicStats;
    private final Inventory inventory;
    private final PlayerState playerState;
    private final SpellBook spellBook;

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
    
    public void setDexterity(int i){
        basicStats.setDexterity(i);
    }
    
    public void setConstitution(int i){
        basicStats.setConstitution(i);
    }
    
    public void setIntelligence(int i){
        basicStats.setIntelligence(i);
    }
    
    public void setWisdom(int i){
        basicStats.setWisdom(i);
    }
    
    public void setCharisma(int i){
        basicStats.setCharisma(i);
    }
    
    public void setMaxHealth(int i){
        playerState.setMaxHealth(i);
    }
    
    public void setCurrentHealth(int i){
        playerState.setCurrentHealth(i);
    }
}
