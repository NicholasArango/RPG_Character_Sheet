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
//import java.awt.*;
//import java.io.FileReader;
//import java.io.IOException;
// Importing of other classes not needed ??? I think

// BasicStatManager enum object names:
// Attribute
// Throw
// Skill

public class MenuManager extends JFrame {
    
    // The tabbed pane for the GUI
    private JTabbedPane tabbedPane;
    // Holds the JSON configuration loaded from the file
    //private JsonNode menuConfig; 
    
    // Constructor: Initializes the UI and loads the JSON configuration.
    public MenuManager() {
        //initUI();         // Setup the user interface
        //loadMenuConfig(); // Load JSON from the file using Jackson
        //initializeTabs(); // Create tabs based on JSON data
    }
    
    public static void newCharSetup(GUI gui){
        GUI.newSetup(gui);
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
    
    public void newCharacter() {
    String name = JOptionPane.showInputDialog(this, "Enter Character Name:");
    if (name != null && !name.trim().isEmpty()) {
        CharacterSheet newSheet = new CharacterSheet(name.trim());
        // Example: Store the character or update UI (add your logic here)
        JOptionPane.showMessageDialog(this, "Created character: " + newSheet.getCharacterName());
    }
}
    
    
    // Initializes tabs based on the loaded JSON configuration.
    // Assumes JSON file has an array "tabs", with each tab having "name" and "content".
    private void initializeTabs() {
        // Check if the JSON configuration was loaded successfully and contains tabs.
        if (menuConfig != null && menuConfig.has("tabs")) {
            for (JsonNode tabNode : menuConfig.get("tabs")) {
                String tabName = tabNode.get("name").asText();
                JPanel panel = createPanelFromConfig(tabNode);
                addTab(tabName, panel);
            }
        } else {
            // Fallback: Add default example tabs if JSON data is missing or malformed.
            addTab("Home", new JPanel());
            addTab("Settings", new JPanel());
            // Add a button here to quit -------------------
        }
    }
    
    /**
     * Create a panel from the JSON configuration for a tab.
     * Content property is important here (maybe)
     * Adjust this method based on application needs.
     *
     * @param tabNode A JsonNode representing the tab configuration.
     * @return A JPanel containing the tab's content.
     */
    /*private JPanel createPanelFromConfig(JsonNode tabNode) {
        JPanel panel = new JPanel();
        return panel;
    }
    
    /**
     * Adds a new tab to the tabbed pane.
     *
     * @param tabName The name (title) of the tab.
     * @param panel   The JPanel component for the tab's content.
     */
    /*public void addTab(String tabName, JPanel panel) {
        tabbedPane.addTab(tabName, panel);
    }
    
    /**
     * Removes a tab from the tabbed pane based on its title.
     *
     * @param tabName The title of the tab to remove.
     */
    public void removeTab(String tabName) {
        int index = tabbedPane.indexOfTab(tabName);
        if (index != -1) {
            tabbedPane.removeTabAt(index);
        } else {
            System.err.println("Tab with name " + tabName + " not found.");
        }
    }
    
    
    // Refreshes the tabbed pane.
    public void refreshTabs() {
        tabbedPane.revalidate();
        tabbedPane.repaint();
    }
    
   
    // The entry point of the application. Ensures the GUI is created on Event
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuManager manager = new MenuManager();
            manager.setVisible(true);
        });
    }
}
