import model.*;
import exception.*;
import utils.ConfigLoader;
import utils.InputLoader;
import utils.Processor;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ConfigLoader.loadConfigFile("./submissionFormat.csv");
        Order order = InputLoader.loadInputFile("./inputFormat.csv");
        System.out.println(order.getItemList().size());
//        Scanner sc = new Scanner(System.in);
//        Order order = new Order();
//        // capturing user inputs, escape when capture empty line
//        while (true) {
//            String input = sc.nextLine();
//            //ESC
//            if (input.equals("")) break;
//            // generate order
//            try{
//                order.addItem(OrderItem.parseItem(input));
//            } catch (IndexOutOfBoundsException e) {
//                System.out.println("Index Out Of Bound. Please check the input format at: " + e.getMessage());
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid Number. Please check the input number: " + e.getMessage());
//            } catch (FormatNotFoundException e){
//                e.printStackTrace();
//            }
//        }
//
//        Result result = Processor.process(order);
    }

}
