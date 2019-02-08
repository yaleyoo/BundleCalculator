package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);


    public static Optional<List<String>> readFile(String url){
        Path path = Paths.get(url);
        try {
            return Optional.ofNullable(Files.readAllLines(path));
        } catch (IOException e){
            logger.error("File not found, please check the input path.");
        } catch (Exception e){
            logger.error("Encounter unexpected exception when reading file.");
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
