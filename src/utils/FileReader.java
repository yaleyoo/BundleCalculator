package utils;

import com.oracle.tools.packager.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class FileReader {

    public static Optional<List<String>> readFile(String url){
        Path path = Paths.get(url);
        try {
            return Optional.ofNullable(Files.readAllLines(path));
        } catch (IOException e){
            Log.info("[EXCEPTION] - File not found, check input path.");
        } catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
