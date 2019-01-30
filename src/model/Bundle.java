package model;

public class Bundle {
    private int size;
    private String type;
    private double price;

    public Bundle(int size, String type, double price){
        this.size = size;
        this.price = price;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
