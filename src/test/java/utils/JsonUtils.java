package utils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    public static String readJsonFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}