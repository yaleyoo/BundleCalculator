package model;

import java.util.Map;

public class ResultItem {
    private OrderItem orderItem;
    private double sum;
    private Map<Bundle, Integer> detail;


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
}
