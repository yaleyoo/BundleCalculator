package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> itemList;

    public Order(){
        itemList = new ArrayList<>();
    }

    public void addItem(OrderItem item){
        itemList.add(item);
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }
}
