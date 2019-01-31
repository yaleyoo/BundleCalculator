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
        Result r = Processor.process(order);
        System.out.println("ss");

    }

}
