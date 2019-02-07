package output;

import model.Result;

public class ResultPrinter {

    public static void printResult(Result result) {
        result.getResultItemList().forEach(resultItem -> {
            System.out.println(resultItem.getOrderItem().getQuantity() + " " + resultItem.getOrderItem().getFormatCode() + " $" + resultItem.getSum());
            resultItem.getDetail().forEach(((bundle, integer) -> {
                if (integer != 0)
                    System.out.println("    " + integer + " x " + bundle.getSize() + " $" + bundle.getPrice());
            }));
        });
    }
}
