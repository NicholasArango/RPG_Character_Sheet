/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ellie R
 */
package Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper()
        .enable(SerializationFeature.INDENT_OUTPUT);

    public static void serializeToFile(CharacterSheet character, String filePath) throws IOException {
        mapper.writeValue(new File(filePath), character);
    }

    public static CharacterSheet deserializeFromFile(String filePath) throws IOException {
        return mapper.readValue(new File(filePath), CharacterSheet.class);
    }
}