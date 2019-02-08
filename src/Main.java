import model.*;
import config.ConfigLoader;
import processor.Processor;
import output.ResultPrinter;
import utils.FileReader;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        ConfigLoader configLoader = new ConfigLoader();
        ResultPrinter resultPrinter = new ResultPrinter();
        Processor processor = new Processor();

        Order order = new Order();
        configLoader.loadConfigFile("resources/submissionFormat.txt");
        Optional<List<String>> inputs = FileReader.readFile("resources/inputFormat.txt");
        inputs.ifPresent(input -> order.generateOrder(input, configLoader.getLegalFmtCodes()));

        resultPrinter.printResult(processor.process(order, configLoader));
    }

}
