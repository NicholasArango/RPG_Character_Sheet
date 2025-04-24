package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J.
 * @author Ellie R
 * @author N Arango
 * 
 * Class: Player State
 * public
 * 
 * Collaborators:
 *  Character Sheet, Menu Manager
 * 
 * Responsibilities:
 *  Changes real time effects and stats such as:
 *  Current Health, Status (Ex: Poison), and Experience Points
 * 
 * Methods:
 *  CurreentHealth:
 *      private
 *      Receives and gives data on the characters health based on user input
 *  ExperiencePoints(EXP Experience):
 *      private
 *      parameters: inputs the experience type through the EXP object
 *      return:
 *      Receives and gives data on the character's Experience Points or Milestone
 *  Status Enum:
 *      private
 *      parameters: none
 *      return: none
 *      Holds all available status effects and their values
 *  StatusEffect:
 *      Gives and receives data to the character's stats, 
 *      altering them based on input (Status given).
 */
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class PlayerState {

    private int currentHealth;
    private int maxHealth;
    private final Set<Status> activeStatuses = EnumSet.noneOf(Status.class);

    public PlayerState() {
        currentHealth = 1;
        maxHealth = 1;
    }

    // Status effect enumeration remains unchanged
    public enum Status {
        ENCUMBERED("Encumbered", "STR", -1);
        //add more later, not even sure this is the right stat modifier for overencumbered, just an example
        
        private final String displayName;
        private final String affectedStat;
        private final int modifier;

        Status(String displayName, String affectedStat, int modifier) {
            this.displayName = displayName;
            this.affectedStat = affectedStat;
            this.modifier = modifier;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getAffectedStat() {
            return affectedStat;
        }

        public int getModifier() {
            return modifier;
        }
    }
    
    /**
     * Setter for maxHealth
     * 
     * @param amount new Max Health
     */
    public void setMaxHealth(int amount) {
        maxHealth = amount;
    }

    /**
     * Setter for currentHealth
     * 
     * @param amount new currentHealth
     */
    public void setCurrentHealth(int amount) {
        currentHealth = amount;
    }

    public void addStatus(Status status) {
        activeStatuses.add(status);
    }

    public void removeStatus(Status status) {
        activeStatuses.remove(status);
    }

    public boolean hasStatus(Status status) {
        return activeStatuses.contains(status);
    }

    public Set<Status> getActiveStatuses() {
        return Collections.unmodifiableSet(activeStatuses);
    }

    /**
     * Getter for currentHealth
     * 
     * @return current currentHealth
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Getter for maxHealth
     * 
     * @return current maxHealth
     */
    public int getMaxHealth(){
        return maxHealth;
    }
}
