package model;

import config.AvailableBundles;
import config.ConfigLoader;

import java.util.HashMap;
import java.util.Map;

public class ResultItem {
    private OrderItem orderItem;
    private double sum;
    private Map<Bundle, Integer> detail;
    private int offset;

    public ResultItem(){
        super();
    }

    public ResultItem(OrderItem orderItem, ConfigLoader configLoader){
        detail = new HashMap<>();
        this.orderItem = orderItem;
        configLoader.getAvailableBundles().getBundle(orderItem.getFormatCode())
                .forEach(bundle -> this.detail.put(bundle, 0));
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Map<Bundle, Integer> getDetail() {
        return detail;
    }

    public void setDetail(Map<Bundle, Integer> detail) {
        this.detail = detail;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
