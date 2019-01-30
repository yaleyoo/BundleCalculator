package utils;

import com.oracle.tools.packager.Log;
import exception.FormatNotFoundException;
import model.Order;
import model.OrderItem;

import java.util.List;

public class InputLoader {

    public static Order loadInputFile(String url){
        Order order = new Order();
        List<String> inputs = FileReader.readFile(url);
        inputs.forEach(item-> {
            try {
                order.addItem(OrderItem.parseItem(item));
            } catch (NumberFormatException e){
                Log.info("[EXCEPTION] - Number Parsing Exception, please check inputFormat.csv");
            } catch (FormatNotFoundException e){
                Log.info(e.getMessage());
            } catch (IndexOutOfBoundsException e){
                Log.info("[EXCEPTION] - Index Out of Bounds, please check inputFormat.csv");
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        return order;
    }
}
