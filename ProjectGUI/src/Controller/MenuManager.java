package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J., Ellie R., N. Arango
 * 
 * Class: Menu Manager
 *  public
 * 
 * Responsibilities:
 *  Load menus based on given data
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
import javax.swing.*;
import View.*;

public class MenuManager extends JFrame {
    
    // main GUI window
    private static MainScreen gui;
    private static CharacterSheet sheet;
    
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
    }
    
    public static void newChar() {
        NewCharSetup setup = new NewCharSetup();
        setup.setVisible(true);
        setup.map();
    }
    
    public static void newWarning(){
        WarningScreenNew screen = new WarningScreenNew();
        screen.setVisible(true);
    }
    
    public static void loadWarning(){
        WarningScreenLoad screen = new WarningScreenLoad();
        screen.setVisible(true);
    }
    public static void newCharS(){
        gui.dispose();
        NewCharSetup setup = new NewCharSetup();
        setup.setVisible(true);
        setup.map();
    }
    
    public static boolean checkNewChar(){
        boolean check = NewCharSetup.inputValidate();
        return check;
    }
    
    public static void createNewChar(String name){
        sheet = new CharacterSheet(name);
    }
    
    /**
     * Load function from start screen
     */
    public static void loadCharS(){
        gui = new MainScreen();
        gui.setVisible(true);
        gui.map();
        loadChar();
    }
    
    public static void loadChar(){
        String value;
        int maxHP;
        int currHP;
        int lev;
        int xp;
        for(int i = 1; i < 8; i++){
            if(i == 1){
                value = showName();
                editChar(i, value);
            }
            else{
                int j = getChar(i);
                value = Integer.toString(j);
                editChar(i, value);
            }
            String key = "lab" + i;
            statEdit(key, value);
        }
        maxHP = getChar(8);
        currHP = getChar(9);
        value = currHP + "/" + maxHP;
        statEdit("lab8", value);
        lev = getChar(10);
        value = Integer.toString(lev);
        statEdit("lab9", value);
        xp = getChar(11);
        value = Integer.toString(xp) + "/" + (lev * 1000);
        statEdit("lab10", value);
        
        updateSkills();
        updateProf();
    }
    public static void updateSkills(){
        for(int i = 0; i < 19; i++){
            int num = sheet.getSkillValue(i);
            int j = i + 1;
            String key = Integer.toString(j);
            key = "lab" + key;
            String value = Integer.toString(num);
            MainScreen.editSkills(key, value);
        }
    }
    
    public static void updateEditSkills(){
        for(int i = 0; i < 19; i++){
            int num = sheet.getSkillValue(i);
            int j = i + 1;
            String key = Integer.toString(j);
            String value = Integer.toString(num);
            EditSkills.editSkills(key, value);
        }
    }
    
    public static void updateProf(){
        for(int k = 1; k < 7; k++){
            int num = sheet.getSkillProf(k);
            String key = Integer.toString(k);
            key = "lab" + key;
            String value = Integer.toString(num);
            if(num >= 0){
                value = "+" + value;
            }
            MainScreen.editProf(key, value);
        }
    }
    
    public static void editChar(int key, String value){
        int i;
        switch (key){
            case 1 -> sheet.setCharacterName(value);
            case 2 -> {
                i = Integer.parseInt(value);
                sheet.setStrength(i);
            }
            case 3 -> {
                i = Integer.parseInt(value);
                sheet.setDexterity(i);
            }
            case 4 -> {
                i = Integer.parseInt(value);
                sheet.setConstitution(i);
            }
            case 5 -> {
                i = Integer.parseInt(value);
                sheet.setIntelligence(i);
            }
            case 6 -> {
                i = Integer.parseInt(value);
                sheet.setWisdom(i);
            }
            case 7 -> {
                i = Integer.parseInt(value);
                sheet.setCharisma(i);
            }
            case 8 -> {
                i = Integer.parseInt(value);
                sheet.setMaxHealth(i);
            }
            case 9 -> {
                i = Integer.parseInt(value);
                sheet.setCurrentHealth(i);
            }
            case 10 -> {
                i = Integer.parseInt(value);
                sheet.setLevel(i);
            }
            case 11 -> {
                i = Integer.parseInt(value);
                sheet.setExperience(i);
            }
            default -> {
            }
        }
    }
    
    public static String showName(){
        String text = sheet.getCharacterName();
        return text;
    }
    
    public static int getChar(int key){
        int i;
        switch (key){
            case 2 -> {
                i = sheet.getStrength();
            }
            case 3 -> {
                i = sheet.getDexterity();
            }
            case 4 -> {
                i = sheet.getConstitution();
            }
            case 5 -> {
                i = sheet.getIntelligence();
            }
            case 6 -> {
                i = sheet.getWisdom();
            }
            case 7 -> {
                i = sheet.getCharisma();
            }
            case 8 -> {
                i = sheet.getMaxHealth();
            }
            case 9 -> {
                i = sheet.getCurrentHealth();
            }
            case 10 -> {
                i = sheet.getLevel();
            }
            case 11 -> {
                i = sheet.getExperience();
            }
            default -> {
                i = 0;
            }
        }
        return i;
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
        updateEditSkills();
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
     * Calls the function to change a single label in skill tab of the GUI
     * @param i the i holds the proficiency value
     */
    public static boolean isProf(int i){
        return sheet.isProficient(i);
    }
    
    public static void setProf(int i, boolean state){
        sheet.setProficiency(i, state);
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
    
    public static boolean[] saveProf(){
        return sheet.returnProf();
    }

    // The entry point of the application. Ensures the GUI is created on Event
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuManager manager = new MenuManager();
            manager.setVisible(true);
        });
    }
}
