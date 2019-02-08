package model;

import config.LegalFmtCodes;
import exception.FormatNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static final Logger logger = LogManager.getLogger(Order.class);
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
                logger.error("The input should be in format of \"Integer FormatCode\"; " +
                        "Please check submissionFormat.txt in line: " + inputs.indexOf(item));
                e.printStackTrace();
            } catch (FormatNotFoundException e) {
                logger.error("The input Format Code is not exist; " +
                        "Please check submissionFormat.txt in line: " + inputs.indexOf(item));
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {
                logger.error("The input should contain exactly 2 arguments and separated by \" \"; " +
                        "Please check submissionFormat.txt in line: " + inputs.indexOf(item));
                e.printStackTrace();
            } catch (Exception e) {
                logger.error("Encounter unexpected exception in submissionFormat.txt in line: " + inputs.indexOf(item));
                e.printStackTrace();
            }
        });
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }
}
