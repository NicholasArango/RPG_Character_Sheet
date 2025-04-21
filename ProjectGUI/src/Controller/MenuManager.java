package Controller;

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
import Model.*;
import java.io.IOException;
import javax.swing.*;
import View.*;

// BasicStatManager enum object names:
// Attribute
// Throw
// Skill

public class MenuManager extends JFrame {
    
    // main GUI window
    private static MainScreen gui;
    private static CharacterSheet character;
    
    // Constructor: Initializes the UI and loads the JSON configuration.
    public MenuManager() {
    }
    
    /**
     * Opens a new GUI for a new character
     * It creates the GUI and calls the functions to initialize it to the default values
     * TODO: connect it to the CharacterSheet
     */
    public static void newCharSetup(){
        gui = new MainScreen();
        gui.setVisible(true);
        gui.map();
        character = new CharacterSheet("New Character");
    }
    /**
     * Opens the Stat Editor window
     */
    public static void openStatEdit(){
        EditChar edit1 = new EditChar();
        edit1.setVisible(true);
        edit1.map();
        
    }
    
    /**
     * validates the input
     * @return returns result of the check
     */
    public static boolean checkStatEdit(){
        boolean check = EditChar.inputValidate();
        return check;
    }
    
    public static void errorWindow(String text){
        ErrorScreen newError = new ErrorScreen();
        newError.setup(text);
        newError.setVisible(true);
    }
    
    /**
     * Calls the function to change a single label in the stat tab of the GUI
     * @param key the key to select the correct label from the statMap
     * @param value the value that will be input
     */
    public static void statEdit(String key, String value){
        MainScreen.editStats(key, value);
    }

    /**
     * Opens the Skill Editor window
     */
    public static void openSkillEdit(){
        EditSkills skill1 = new EditSkills();
        skill1.setVisible(true);
        skill1.map();
    }
    
    public static boolean checkSkillEdit(){
        boolean check = EditSkills.inputValidate();
        return check;
    }
    /**
     * Calls the function to change a single label in skill tab of the GUI
     * @param key the key to select the correct label from the statMap
     * @param value the value that will be input
     */
    public static void skillEdit(String key, String value){
        MainScreen.editSkills(key, value);
    }
    
    /**
     * Opens the Inventory editor window
     */
    public static void openInv(){
        EditInventory inv1 = new EditInventory();
        inv1.setVisible(true);
    }
    
    /**
     * Opens the Spellbook editor window
     */
    public static void openSpells(){
        EditSpellbook spells1 = new EditSpellbook();
        spells1.setVisible(true);
    }
    
    
    /*
    // Loads the JSON configuration file using the Jackson ObjectMapper.
    private void loadMenuConfig() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Change the path to the actual location of the JSON file if necessary.
            menuConfig = mapper.readTree(new File("menu_config.json"));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading configuration: " + e.getMessage());
        }
    }
    */
    // The entry point of the application. Ensures the GUI is created on Event
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuManager manager = new MenuManager();
            manager.setVisible(true);
        });
    }
}
