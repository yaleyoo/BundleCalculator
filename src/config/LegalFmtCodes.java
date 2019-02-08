package config;

import java.util.ArrayList;
import java.util.List;

public class LegalFmtCodes {
    private List<String> fmtCodes;

    LegalFmtCodes(){
        fmtCodes = new ArrayList<>();
    }

    public void addFmtCode(String input) throws IndexOutOfBoundsException{
        fmtCodes.add(input.split(",")[1].toUpperCase());
    }

    public boolean containFmtCode(String fmtCode){
        return this.fmtCodes.contains(fmtCode.toUpperCase());
    }
}
