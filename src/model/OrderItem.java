package model;

import config.LegalFmtCodes;
import exception.FormatNotFoundException;

public class OrderItem {
    private int quantity;
    private String formatCode;

    public void parseItem(String input, LegalFmtCodes legalFmtCodes) throws NumberFormatException, FormatNotFoundException, IndexOutOfBoundsException{
        String[] input_data = input.split(" ");
        String quantityStr = input_data[0];
        String fmtCode = input_data[1].toUpperCase();
        // extract 1st arg - number of items
        int num = Integer.parseUnsignedInt(quantityStr);
        // extract 2nd arg - submission format code
        if (!legalFmtCodes.containFmtCode(fmtCode)) {
            // ignore input, if no matching format is found
            throw new FormatNotFoundException();
        }
        this.quantity = num;
        this.formatCode = fmtCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFormatCode() {
        return formatCode;
    }

}
