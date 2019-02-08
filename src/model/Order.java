package model;

import com.oracle.tools.packager.Log;
import config.LegalFmtCodes;
import exception.FormatNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> itemList;

    public Order(){
        itemList = new ArrayList<>();
    }

    public void generateOrder(List<String> inputs, LegalFmtCodes legalFmtCodes){
        inputs.forEach(item-> {
            OrderItem orderItem = new OrderItem();
            try {
                orderItem.parseItem(item, legalFmtCodes);
                this.itemList.add(orderItem);
            } catch (NumberFormatException e) {
                System.out.println("[EXCEPTION] - Number Parsing Exception, please check inputFormat.txt");
            } catch (FormatNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("[EXCEPTION] - Index Out of Bounds, please check inputFormat.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }
}
