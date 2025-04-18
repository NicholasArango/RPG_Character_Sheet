package Model;


import java.io.Serializable;
import java.util.Objects;

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
    private final String characterName;
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
    public BasicStatManager getBaseStats() { return basicStats; }
    public Inventory getInventory() { return inventory; }
    public PlayerState getPlayerState() { return playerState; }
    public SpellBook getSpellBook() { return spellBook; }

    
    
}
