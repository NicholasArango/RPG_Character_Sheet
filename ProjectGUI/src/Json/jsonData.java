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
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class jsonData {
    private Map<String, Integer> BaseStats;
    
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
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        
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
        Map<String, Integer> stats = new LinkedHashMap<>();
        stats.put("STR", 0);
        stats.put("DEX", 0);
        stats.put("CON", 0);
        stats.put("INT", 0);
        stats.put("WIS", 0);
        stats.put("CHA", 0);
        
        jsonData c = new jsonData();
        c.setBaseStats(stats);
        
        // Serialize
        try {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("baseStats.json"), c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void JsonLoad(String filename) {
        File file = new File(filename);
    }
    
    public static void JsonSave(String filename) {
        
    }
}
