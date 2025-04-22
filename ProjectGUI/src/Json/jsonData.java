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
import java.io.InputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;

public class jsonData {
    // Used for storing information into the json files
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private Map<String, Integer> BaseStats;
    // Holds Directories and file names
    private final String configDir = "src/Json/jsonConfigs"; // Directory that holds created json files
    private String fileName  = "myConfig.json"; // String that will hold file names
    
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
    
    /**
     * Reads a JSON resource bundled on the classpath.
     *
     * @param resourcePath e.g. "/config.json" (leading slash = root of classpath)
     * @return the parsed JsonNode
     * @throws IOException if the resource isn't found or can't be parsed
     */

    public static JsonNode readJsonResource(String resourcePath) throws IOException {
        try (InputStream is = jsonData.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            return MAPPER.readTree(is);
        }
    }

    public static void JsonLoad(String filename) {
        File file = new File(filename);
    }
    
    /*
     * Reads a JSON file from disk and returns it as a JsonNode.
     *
     * @param path the filesystem path to the JSON file
     * @return the parsed JsonNode
     * @throws IOException if the file can't be read or parsed
     */
    public static JsonNode JsonSave(String path) throws IOException {
        return MAPPER.readTree(new File(path));
    }
    
    /**
     * Overwrites (or creates) the JSON file at {@code path} with the contents of {@code data}.
     *
     * @param path file system path to write to
     * @param data the JsonNode to serialize
     * @throws IOException if the file can't be written
     */
    public static void writeJsonFile(String path, JsonNode data) throws IOException {
        try {
        MAPPER.writerWithDefaultPrettyPrinter()
              .writeValue(new File(path), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}