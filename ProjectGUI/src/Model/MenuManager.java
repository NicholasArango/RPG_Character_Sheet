package Model;

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
import projectgui.GUI;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.File;
import javax.swing.*;
import projectgui.EditChar;
import projectgui.EditInventory;
import projectgui.EditSkills;
import projectgui.EditSpellbook;
//import java.awt.*;
//import java.io.FileReader;
//import java.io.IOException;
// Importing of other classes not needed ??? I think

// BasicStatManager enum object names:
// Attribute
// Throw
// Skill

public class MenuManager extends JFrame {
    
    // main GUI window
    private static GUI gui;
    
    // Constructor: Initializes the UI and loads the JSON configuration.
    public MenuManager() {
        //initUI();         // Setup the user interface
        //loadMenuConfig(); // Load JSON from the file using Jackson
        //initializeTabs(); // Create tabs based on JSON data
    }
    
    /**
     * Opens a new GUI for a new character
     * It creates the GUI and calls the functions to initialize it to the default values
     * TODO: call the 
     */
    public static void newCharSetup(){
        gui = new GUI();
        gui.setVisible(true);
        gui.map();
    }
    /**
     * Opens the Stat Editor window
     * 
     */
    public static void openStatEdit(){
        EditChar edit1 = new EditChar();
        edit1.setVisible(true);
        edit1.map();
    }
    
    public static void statEdit(String key, String value){
        GUI.editStats(key, value);
    }

    public static void openSkillEdit(){
        EditSkills skill1 = new EditSkills();
        skill1.setVisible(true);
        skill1.map();
    }
    
    public static void skillEdit(String key, String value){
        GUI.editSkills(key, value);
    }
    
    public static void openInv(){
        EditInventory inv1 = new EditInventory();
        inv1.setVisible(true);
    }
    
    public static void openSpells(){
        EditSpellbook spells1 = new EditSpellbook();
        spells1.setVisible(true);
    }
    
    
    /*
    // Set up the user interface.
    private void initUI() {
        setTitle("Menu Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Initialize the tabbed pane and add it to the frame.
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
        
        // Set window size and center it.
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
    */
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
