package utils;

import config.AvailableBundles;
import model.*;

import java.util.Comparator;
import java.util.List;

public class Processor {

    public static Result process(Order order){
        Result result = new Result();
        order.getItemList().forEach(item -> result.add(processItem(item)));

        return result;
    }

    public static ResultItem processItem(OrderItem item){
        List<Bundle> bundleList = AvailableBundles.availableBundles.get(item.getFormatCode())
                .stream()
                .sorted(b -> b.getSize());
        return new ResultItem();
    }

}
