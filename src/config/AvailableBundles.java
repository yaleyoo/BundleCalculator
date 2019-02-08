package config;

import model.Bundle;

import java.util.*;

import static java.util.Optional.ofNullable;

public class AvailableBundles {
    // (VID, [bundle1, bundle2, bundle3])
    private Map<String, List<Bundle>> availableBundles;

    AvailableBundles(){
        this.availableBundles = new HashMap<>();
    }

    /**
     * Parsing input String, and insert available bundle.
     * @param input In the format "Image,IMG,5@$450 10@$800"
     * @throws IndexOutOfBoundsException The input format is wrong.
     * @throws NumberFormatException The input format is wrong. Shall be Int@$Double.
     */
    public void addBundle(String input) throws IndexOutOfBoundsException, NumberFormatException{
        String[] inputClips = input.split(",");
        String bundleName = inputClips[1].toUpperCase();
        String bundleDetails = inputClips[2];
        Arrays.asList(bundleDetails.split(" ")).forEach(bundleItem -> {
            String[] bundleStr = bundleItem.split("@\\$");
            String bundleScale = bundleStr[0];
            Bundle bundle = new Bundle(Integer.parseInt(bundleScale),
                    bundleName,
                    Double.parseDouble(bundleStr[1]));
            Optional<List<Bundle>> bundleMap = ofNullable(
                    this.availableBundles.getOrDefault(bundle.getType(), new ArrayList<>()));
            bundleMap.ifPresent(b->{
                b.add(bundle);
                this.availableBundles.put(bundle.getType(), b);
            });
        });
    }

    public List<Bundle> getBundle(String fmtCode){
        return this.availableBundles.get(fmtCode);
    }
}
