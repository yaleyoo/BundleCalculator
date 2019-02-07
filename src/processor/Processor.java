package processor;

import config.AvailableBundles;
import model.*;

import java.util.*;

public class Processor {
    private static ResultItem optimal;

    public static Result process(Order order){
        Result result = new Result();
        order.getItemList().forEach(item -> result.add(processItem(item)));

        return result;
    }

    private static ResultItem processItem(OrderItem item){
        // initialize the optimal result when processing every item
        optimal = new ResultItem();
        optimal.setOffset(999);
        List bundleList = Arrays.asList(AvailableBundles.availableBundles.get(item.getFormatCode())
                .stream()
                .map(Bundle::getSize)
                .sorted(Comparator.reverseOrder())
                .toArray());

        recursive(item.getQuantity(), bundleList, new ResultItem(item));

        optimal.getDetail().forEach(((bundle, integer) -> optimal.setSum(optimal.getSum() + bundle.getPrice() * integer)));

        return optimal;
    }

    /**
     *
     * @param remain Which need to be further decomposed
     * @param bundleList Using the list to decompose the remain
     * @param resultItem Result
     * @return Whether the optimal solution has been found?
     */
    private static boolean recursive(int remain, List bundleList, ResultItem resultItem){
        int max = (int) bundleList.get(0);
        ResultItem copy = deepCopy(resultItem);

        // 递归底部
        // The bottom of the recursion, when only ONE bundle left in the list
        if (bundleList.size() == 1){
            if (remain % (int) bundleList.get(0) != 0)
                copy.setOffset((int) bundleList.get(0) - remain % (int) bundleList.get(0));
            else {
                // return true (will ESCAPE the recursion), when found the best solution, which the remainder is 0.
                copy.getDetail().forEach((bundle, quantity) -> {
                    if (bundle.getSize() == max) {
                        copy.getDetail().put(bundle, remain/max);
                    }
                });
                copy.setOffset(0);
                optimal = copy;
                return true;
            }
            // return false (will CONTINUE the recursion), when found a better solution, but the remainder is greater than 0.
            if (copy.getOffset() < optimal.getOffset()) {
                copy.getDetail().forEach((bundle, quantity) -> {
                    if (bundle.getSize() == max) {
                        copy.getDetail().put(bundle, remain/max + 1);
                    }
                });
                optimal = copy;
                return false;
            }
            return false;
        }

        // 递归主体
        // MAIN BODY of RECURSION
        for (int i=0; i<=remain/max; i++){
            int finalI = i;
            copy.getDetail().forEach((bundle, quantity) -> {
                if (bundle.getSize() == max) {
                    copy.getDetail().put(bundle, finalI);
                }
            });

            // ESCAPE the recursion when the solution which remain 0 is found
            if (recursive(remain - (i * max), bundleList.subList(1, bundleList.size()), copy))
                break;
        }
        return false;
    }

    private static ResultItem deepCopy(ResultItem origin){
        ResultItem copy = new ResultItem();
        Map<Bundle, Integer> detail = new HashMap<>();
        origin.getDetail().forEach((detail::put));

        copy.setOffset(origin.getOffset());
        copy.setDetail(detail);
        copy.setOrderItem(origin.getOrderItem());
        copy.setSum(origin.getSum());

        return copy;
    }

}
