/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Json;

/**
 *
 * @author Robert J.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jsonData {
    
    // Used for storing information into the json files
    private static final ObjectMapper MAPPER = new ObjectMapper()
        .enable(SerializationFeature.INDENT_OUTPUT);
    private Map<String, Integer> BaseStats;
    public static ObjectNode root = MAPPER.createObjectNode();
    
    // Holds Directories and file names
    private final String configDir = "src/Json/jsonConfigs"; // Directory that holds created json files
    private File currentJsonFile; // Holds current file
    private List<Map<String, Integer>> dataList;
    private final JTable table = new JTable();
    
    public jsonData() {
        // nothing for jackson
    }
    
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
    /*
    // TODO inside of the GUI, Buttons will listen and then call these functions
    private final JButton saveButton = new JButton("Save");
    private final JButton loadButton = new JButton("Load");
    private final JButton newCharButton = new JButton("New Character");
    
    private void bindSaveAction() {
        saveButton.addActionListener((ActionEvent ev) -> saveData());
    }
    
    private void bindSaveAction() {
        loadButton.addActionListener((ActionEvent ev) -> loadData());
    }
    */
    
    private void onNewCharacter(ActionEvent ev) {
        String name = JOptionPane.showInputDialog(
            null,
            "Enter new character name (no extension):",
            "Create New Character",
            JOptionPane.PLAIN_MESSAGE
        );
        if (name == null || name.isBlank()) return;

        File folder = new File("src/json/jsonConfigs");
        folder.mkdirs();
        File file = new File(folder, name.trim() + ".json");
        if (file.exists()) {
            JOptionPane.showMessageDialog(
                null,
                "A file named \"" + file.getName() + "\" already exists.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            // write an empty root array so loadData() can parse it
            MAPPER.writeValue(file, new ArrayList<>());
            currentJsonFile = file;
            dataList = new ArrayList<>();       // start with empty data
            refreshTableFromData();             // your method to repopulate the JTable
            JOptionPane.showMessageDialog(
                null,
                "Created " + file.getName(),
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                null,
                "Could not create file:\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    
    public void loadData() {
        try {
            dataList = MAPPER.readValue(
                currentJsonFile,
                new com.fasterxml.jackson.core.type.TypeReference<List<Map<String, Integer>>>() {}
            );
            refreshTableFromData();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                null,
                "Failed to load JSON:\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void saveData() {
        // TODO ▶ read your JTable back into dataList
        try {
            MAPPER.writeValue(currentJsonFile, dataList);
            JOptionPane.showMessageDialog(
                null,
                "Data saved to " + currentJsonFile.getName(),
                "Saved",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                null,
                "Failed to save JSON:\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
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
    }
}