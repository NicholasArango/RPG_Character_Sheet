/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J.
 * 
 * Class: Menu Manager
 *  public
 * 
 * Responsibilities:
 *  Load menus based on data in a JSON file
 * 
 * Collaborators:
 *  Inventory, Character Sheet, Item, Player State, 
 *  Spell Book, Spell List, Basic Stat Manager, Skills Manager
 * 
 * Methods:
 *  JSON:
 *      public
 *      Parameters: None
 *      return: bool
 *      Reads from the JSON file
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

// BasicStatManager enum object names:
// attribute
// Throw
// skill

public class MenuManager {
    public static void allGet() {
        // name
        // race
        // class
        // level
        // xp
        // hp
        // DC
            // Calculation for DC based on stats
        // Attributes:
        BasicStatManager.Attributes attributeSTR = BasicStatManager.Attributes.STR;
        BasicStatManager.Attributes attributeDEX = BasicStatManager.Attributes.DEX;
        BasicStatManager.Attributes attributeCON = BasicStatManager.Attributes.CON;
        BasicStatManager.Attributes attributeINT = BasicStatManager.Attributes.INT;
        BasicStatManager.Attributes attributeWIS = BasicStatManager.Attributes.WIS;
        BasicStatManager.Attributes attributeCHA = BasicStatManager.Attributes.CHA;
        // Skills:
        BasicStatManager.Skills skillAcro = BasicStatManager.Skills.Acrobatics;
        BasicStatManager.Skills skillAniHand = BasicStatManager.Skills.AnimalHandling;
        BasicStatManager.Skills skillArca = BasicStatManager.Skills.Arcana;
        BasicStatManager.Skills skillAthl = BasicStatManager.Skills.Athletics;
        BasicStatManager.Skills skillDec = BasicStatManager.Skills.Deception;
        BasicStatManager.Skills skillHis = BasicStatManager.Skills.History;
        BasicStatManager.Skills skillIns = BasicStatManager.Skills.Insight;
        BasicStatManager.Skills skillIntim = BasicStatManager.Skills.Intimidation;
        BasicStatManager.Skills skillInv = BasicStatManager.Skills.Investigation;
        BasicStatManager.Skills skillMedi = BasicStatManager.Skills.Medicine;
        BasicStatManager.Skills skillNatr = BasicStatManager.Skills.Nature;
        BasicStatManager.Skills skillPerc = BasicStatManager.Skills.Perception;
        BasicStatManager.Skills skillPerf = BasicStatManager.Skills.Performance;
        BasicStatManager.Skills skillPers = BasicStatManager.Skills.Persuasion;
        BasicStatManager.Skills skillReli = BasicStatManager.Skills.Religion;
        BasicStatManager.Skills skillSoH = BasicStatManager.Skills.SleightOfHand;
        BasicStatManager.Skills skillStea = BasicStatManager.Skills.Stealth;
        BasicStatManager.Skills skillSurv = BasicStatManager.Skills.Survival;
        // Throws:
        BasicStatManager.Throws throwSTR = BasicStatManager.Throws.STRThrow;
        BasicStatManager.Throws throwDEX = BasicStatManager.Throws.DEXThrow;
        BasicStatManager.Throws throwCON = BasicStatManager.Throws.CONThrow;
        BasicStatManager.Throws throwINT = BasicStatManager.Throws.INTThrow;
        BasicStatManager.Throws throwWIS = BasicStatManager.Throws.WISThrow;
        BasicStatManager.Throws throwCHA = BasicStatManager.Throws.CHAThrow;
        
    } // Allget() ends ------------------------------------------------------
    
    public static void main(String[] args) {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        Character character;
        
        try {
            File file = new File("character.json");
            character = objectMapper.readValue(file, Character.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        allGet();
    }
}
