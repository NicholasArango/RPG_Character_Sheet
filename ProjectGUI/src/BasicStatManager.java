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
public class BasicStatManager {
    // NOTES:
    /*
    Attributes (Enum):
    STR var - Saving Throws
    DEX var - Saving Throws
    CON var - Saving Throws
    INT var - Saving Throws
    WIS var - Saving Throws
    CHA var - Saving Throws
    */
    
    
    public BasicStatManager() 
    {
    
    }
    
    
    enum Attributes {
        STR (0),
        DEX (0),
        CON (0),
        INT (0),
        WIS (0),
        CHA (0);
    
        private int value;
    
        Attributes (int value) {
            this.value = value;
        }
        
        public int getAttribute (int value){
            return value;
        }
        public int setAttribute (int x, Attributes attName) {
            if (x > 100 || x < 0) {
                System.out.println("Integer outside of Attribute bouds.\n");
                return 0;
            }
            for (Attributes A : Attributes.values()) {
                if (A == attName) {
                    A.value = x;
                }
            }
            return 0;
        }
    }

    // Skills (Enum):
    enum Skills {

        // List of Skills, type + Value
        Acrobatics      (0), // (DEX)
        AnimalHandling  (0), // (WIS)
        Arcana          (0), // (INT)
        Athletics       (0), // (STR)
        Deception       (0), // (CHA)
        History         (0), // (INT)
        Insight         (0), // (WIS)
        Intimidation    (0), // (CHA)
        Investigation   (0), // (INT)
        Medicine        (0), // (WIS)
        Nature          (0), // (INT)
        Perception      (0), // (WIS)
        Performance     (0), // (CHA)
        Persuasion      (0), // (CHA)
        Religion        (0), // (INT)
        SleightOfHand   (0), // (DEX)
        Stealth         (0), // (DEX)
        Survival        (0); // (WIS)
    
        // Private variables holding the value and name of the Skill
        private int value;
    
        // A constructor for value in the enum list
        Skills (int value) {
            this.value = value;
        }
    
        // Returns value for later use
        public int getSkill() { 
            return value;
        }
    
        // Function for changing the value of the Skills
        public int setSkill(int x, Skills skillName) {
            // If statement for making sure the value is not too large
            if (x > 100 || x < 0) {
                System.out.println("Integer outside of Skill bounds.\n");
                return 0;
            }
            
            // Changes the value for the Skill
            for (Skills s : Skills.values()) {
                if (s == skillName) {
                    s.value = x;
                }
            }
        
        return 0;
        }
    }

    enum Throws {
        STRThrow (0),
        DEXThrow (0),
        CONThrow (0),
        INTThrow (0),
        WISThrow (0),
        CHAThrow (0);
            
        private int value;
            
        Throws (int value) {
            this.value = value;
        }
            
        public int getThrow() {
            return value;
        }
        // Sets throw values based on functions
        // Functions are not yet implemented
        public int setThrow (int x, Throws throwName) {
            if (x > 50 || x < 0) {
                System.out.println("Integer is outide Throw bounds.\n");
                return -1;
            }
            for (Throws t : Throws.values()) {
                if (t == throwName) {
                    t.value = x;
                }
            }
            return 0;
        }
    }
}
