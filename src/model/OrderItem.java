package model;

import config.FmtCode;
import exception.FormatNotFoundException;

public class OrderItem {
    private int quantity;
    private String formatCode;

    public OrderItem(int quantity, String formatCode){
        this.quantity = quantity;
        this.formatCode = formatCode;
    }

    public static OrderItem parseItem(String input) throws NumberFormatException, FormatNotFoundException, IndexOutOfBoundsException{
        String[] input_data = input.split(" ");
        // extract 1st arg - number of items
        int num = Integer.parseInt(input_data[0]);
        // extract 2nd arg - submission format code
        String fmt;
        if (!FmtCode.fmtCodes.contains(input_data[1].toUpperCase())) {
            // ignore input, if no matching format is found
            throw new FormatNotFoundException();
        } else {
            fmt = input_data[1];
        }

        return new OrderItem(num, fmt);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFormatCode() {
        return formatCode;
    }

    public void setFormatCode(String formatCode) {
        this.formatCode = formatCode;
    }
}
