import model.*;
import utils.ConfigLoader;
import utils.InputLoader;
import utils.Processor;
import utils.ResultPrinter;

public class Main {

    public static void main(String[] args) {

        ConfigLoader.loadConfigFile("resources/submissionFormat.txt");
        Order order = InputLoader.loadInputFile("resources/inputFormat.txt");
        ResultPrinter.printResult(Processor.process(order));
    }

}
