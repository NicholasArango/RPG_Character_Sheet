/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Json;

/**
 *
 * @author Robert J.
 * @author N Arango
 * @version %I%
 * @since 1.0
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
//import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
//import java.util.List;
//import java.util.ArrayList;
//import java.awt.event.ActionEvent;
//import javax.swing.JTable;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
import Controller.*;

public class jsonData {

    // Used for storing information into the json files
    private static final ObjectMapper MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    public static ObjectNode root = MAPPER.createObjectNode();
    //private Map<String, Integer> BaseStats;
    //private List<Map<String, Integer>> dataList;

    // Holds Directories and file names
    //private final String configDir = "src/Json/jsonConfigs"; // Directory that holds created json files
    //private final JTable table = new JTable();
    private File currentJsonFile; // Holds current file
    private final Map<String, Object> dataMap = new HashMap<>();
    private boolean[] profs = new boolean[19]; 
    /**
     * JsonData empty Constructor
     */
    public jsonData() {
        // not neccesssary for jackson
    }
    /*
    public Map<String, Integer> getBaseStats() {
        return BaseStats;
    }

    public void setBaseStats(Map<String, Integer> baseStats) {
        this.BaseStats = baseStats;
    }

    public static void jsonCreateBaseStats() throws IOException {
        // Base Info
        root.put("name", "characterName");
        root.put("health", 10);
        root.put("xp", 0);
        root.put("class", "none");
        root.put("race", "none");
        root.putArray("skills")
                .add("fireball")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("");
        root.putArray("inventory")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("")
                .add("");

        // Create base stat data
        Map<String, Integer> baseStats = new LinkedHashMap<>();
        baseStats.put("STR", 0);
        baseStats.put("DEX", 0);
        baseStats.put("CON", 0);
        baseStats.put("INT", 0);
        baseStats.put("WIS", 0);
        baseStats.put("CHA", 0);

        jsonData c = new jsonData();
        c.setBaseStats(baseStats);
        // Put root information into c

        // Serialize
        try {
            MAPPER.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("baseStats.json"), c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private void onNewCharacter(ActionEvent ev) {
        String name = JOptionPane.showInputDialog(
                null,
                "Enter new character name (no extension):",
                "Create New Character",
                JOptionPane.PLAIN_MESSAGE);
        if (name == null || name.isBlank())
            return;

        File folder = new File(configDir);
        folder.mkdirs();
        File file = new File(folder, name.trim() + ".json");
        if (file.exists()) {
            JOptionPane.showMessageDialog(
                    null,
                    "A file named \"" + file.getName() + "\" already exists.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // write an empty root array so loadData() can parse it
            MAPPER.writeValue(file, new ArrayList<>());
            currentJsonFile = file;
            dataList = new ArrayList<>(); // start with empty data
            refreshTableFromData(); // your method to repopulate the JTable
            JOptionPane.showMessageDialog(
                    null,
                    "Created " + file.getName(),
                    "Successfully",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Could not create file:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }*/

    /**
     * Sets character data and places inside a Hash Map for saving as a json.
     */
    public void setDataMap(){
        dataMap.put("name", MenuManager.showName());
        profs = MenuManager.saveProf();
        for(int i = 0;i < 19;i++){
            String key = Integer.toString(i);
            boolean state = profs[i];
            dataMap.put(key, state);
        }
        dataMap.put("Strength", MenuManager.getChar(2));
        dataMap.put("Dexterity", MenuManager.getChar(3));
        dataMap.put("Constitution", MenuManager.getChar(4));
        dataMap.put("Intelligence", MenuManager.getChar(5));
        dataMap.put("Wisdom", MenuManager.getChar(6));
        dataMap.put("Charisma", MenuManager.getChar(7));
        dataMap.put("MaxHP", MenuManager.getChar(8));
        dataMap.put("CurrentHP", MenuManager.getChar(9));
        dataMap.put("Level", MenuManager.getChar(10));
        dataMap.put("XP", MenuManager.getChar(11));
    }

    /**
     * Extracts character data from a Hash Map when loading from a json.
     */
    public void loadCharacter() {
        MenuManager.editChar(1, (String) dataMap.get("name"));
        String value = Integer.toString((int) dataMap.get("Strength"));
        MenuManager.editChar(2, value);
        value = Integer.toString((int) dataMap.get("Dexterity"));
        MenuManager.editChar(3, value);
        value = Integer.toString((int) dataMap.get("Constitution"));
        MenuManager.editChar(4, value);
        value = Integer.toString((int) dataMap.get("Intelligence"));
        MenuManager.editChar(5, value);
        value = Integer.toString((int) dataMap.get("Wisdom"));
        MenuManager.editChar(6, value);
        value = Integer.toString((int) dataMap.get("Charisma"));
        MenuManager.editChar(7, value);
        value = Integer.toString((int) dataMap.get("MaxHP"));
        MenuManager.editChar(8, value);
        value = Integer.toString((int) dataMap.get("CurrentHP"));
        MenuManager.editChar(9, value);
        value = Integer.toString((int) dataMap.get("Level"));
        MenuManager.editChar(10, value);
        value = Integer.toString((int) dataMap.get("XP"));
        MenuManager.editChar(11, value);
        for(int i = 0; i < 19; i++){
            String key = Integer.toString(i);
            boolean state = (boolean) dataMap.get(key);
            MenuManager.setProf(i, state);
        }
    }

    /**
     * Function to load a character from a json file.
     * 
     * @param file the file selected by the file chooser
     */
    public void loadData(File file) {
        currentJsonFile = file;
        try {
            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            Map<String, Object> readMap = MAPPER.readValue(currentJsonFile, typeRef);
            dataMap.clear();
            dataMap.putAll(readMap);
            // refreshTableFromData();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Failed to load JSON:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        loadCharacter();
    }

    /**
     * Function to save a character to a json file.
     * 
     * @param file file chosen by the file chooser
     */
    public void saveData(File file) {
        setDataMap();
        currentJsonFile = file;
        String path = currentJsonFile.getAbsolutePath();
        if (!path.toLowerCase().endsWith(".json")) {
            path += ".json";
            currentJsonFile = new File(path);
        }
        try {
            MAPPER.writeValue(currentJsonFile, dataMap);
            JOptionPane.showMessageDialog(
                    null,
                    "Data saved to " + currentJsonFile.getName(),
                    "Saved",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Failed to save JSON:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    /*
    private void refreshTableFromData() {
        // if there’s no data, clear the table
        if (dataList == null || dataList.isEmpty()) {
            table.setModel(new DefaultTableModel());
            return;
        }

        // use the first map’s key‑set as your column names
        List<String> columnNames = new ArrayList<>(dataList.get(0).keySet());

        // build a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames.toArray());

        // add one row per map
        for (Map<String, Integer> rowMap : dataList) {
            Object[] rowData = new Object[columnNames.size()];
            for (int i = 0; i < columnNames.size(); i++) {
                rowData[i] = rowMap.getOrDefault(columnNames.get(i), 0);
            }
            model.addRow(rowData);
        }

        // swap it into the JTable
        table.setModel(model);
    }*/
}