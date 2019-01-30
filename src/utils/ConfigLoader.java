package utils;

import com.oracle.tools.packager.Log;
import config.AvailableBundles;
import config.FmtCode;
import exception.UnknownException;
import model.Bundle;

import java.util.*;

import static java.util.Optional.ofNullable;

public class ConfigLoader {
    public static void loadConfigFile(String url){
        Optional<List<String>> configFile = ofNullable(FileReader.readFile(url));
        configFile.ifPresent(ConfigLoader::loadConfig);
    }

    private static void loadConfig(List<String> config){
        config.forEach(line->{
            try {
                // initiate Format Codes
                FmtCode.fmtCodes.add(line.split(",")[1].toUpperCase());
                // ======================= //
                // = 感觉写成链式可读性很差 = //
                // ======================= //
                // initiate Available Bundles
                Arrays.asList(line.split(",")[2].split(" ")).forEach(bundles -> {
                    Bundle bundle = new Bundle(Integer.parseInt(bundles.split("@\\$")[0]),
                            line.split(",")[1],
                            Double.parseDouble(bundles.split("@\\$")[1]));
                    Optional<List<Bundle>> bundleMap = ofNullable(
                            AvailableBundles.availableBundles.getOrDefault(bundle.getType(), new ArrayList<>()));
                    bundleMap.ifPresent(b->{
                        b.add(bundle);
                        AvailableBundles.availableBundles.put(bundle.getType(), b);
                    });
                });
            } catch (IndexOutOfBoundsException e){
                Log.info("[EXCEPTION] - Index Out of Bounds, please check submissionFormat.csv");
            } catch (NumberFormatException e){
                Log.info("[EXCEPTION] - Number Parsing Exception, please check submissionFormat.csv");
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
