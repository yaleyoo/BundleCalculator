package utils;

import com.oracle.tools.packager.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public static List<String> readFile(String url){
        Path path = Paths.get(url);
        try {
            return Files.readAllLines(path);
        } catch (IOException e){
            Log.info("[EXCEPTION] - File not found, check input path.");
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
