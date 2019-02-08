package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.FileReader;

import java.util.*;

public class ConfigLoader {
    private static final Logger logger = LogManager.getLogger(ConfigLoader.class);
    private LegalFmtCodes legalFmtCodes;
    private AvailableBundles availableBundles;

    public void loadConfigFile(String url){
        Optional<List<String>> configFile = FileReader.readFile(url);
        configFile.ifPresent(this::loadConfig);
    }

    private void loadConfig(List<String> config){
        this.legalFmtCodes = new LegalFmtCodes();
        this.availableBundles = new AvailableBundles();
        config.forEach(line->{
            try {
                // initiate Format Codes
                legalFmtCodes.addFmtCode(line);
                // initiate Available Bundles
                availableBundles.addBundle(line);
            } catch (IndexOutOfBoundsException e){
                logger.error("The input should contain exactly 3 arguments and separated by \",\";  " +
                        "Please check submissionFormat.txt in line: " + config.indexOf(line));
                e.printStackTrace();
            } catch (NumberFormatException e){
                logger.error("The input of bundle details should be in format of Integer@$Double. " +
                        "Please check submissionFormat.txt in line: " + config.indexOf(line));
                e.printStackTrace();
            } catch (Exception e){
                logger.error("Encounter unexpected exception in submissionFormat.txt in line: " + config.indexOf(line));
                e.printStackTrace();
            }
        });
    }

    public LegalFmtCodes getLegalFmtCodes() {
        return legalFmtCodes;
    }

    public AvailableBundles getAvailableBundles() {
        return availableBundles;
    }
}
