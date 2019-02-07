import model.*;
import config.ConfigLoader;
import input.InputLoader;
import processor.Processor;
import output.ResultPrinter;

public class Main {

    public static void main(String[] args) {

        ConfigLoader.loadConfigFile("resources/submissionFormat.txt");
        Order order = InputLoader.loadInputFile("resources/inputFormat.txt");
        ResultPrinter.printResult(Processor.process(order));
    }

}
