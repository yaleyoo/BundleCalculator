import java.util.*;

enum FmtCode{
    IMG, FLAC, VID;

    public static boolean contains(String type){
        for(FmtCode typeEnum : FmtCode.values()){
            if(typeEnum.name().equalsIgnoreCase(type)){
                return true;
            }
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> input_list = new ArrayList<>();
        // capturing user inputs, escape when capture empty line
        while (true) {
            String input = sc.nextLine();
            //ESC
            if (input.equals("")) break;
            input_list.add(input);
        }

        for (String input:input_list){
            try{
                String[] input_data = input.split(" ");
                // extract 1st arg - number of items
                int num = Integer.parseInt(input_data[0]);
                // extract 2nd arg - submission format code
                FmtCode fmt;
                if (!FmtCode.contains(input_data[1])){
                    // ignore input, if no matching format is found
                    System.out.println("Format not found. Skipped.");
                    continue;
                }
                else{
                    fmt = FmtCode.valueOf(input_data[1]);
                }

                // calculate and print the result
                printResult(num, fmt);
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Index Out Of Bound. Please check the input format at: " + e.getMessage());
            }
            catch (NumberFormatException e){
                System.out.println("Invalid Number. Please check the input number: " + e.getMessage());
            }
        }
    }

    private static void printResult(int num, FmtCode fmt){
        Map<FmtCode, Processor> dispatcher = new HashMap<>();
        dispatcher.put(FmtCode.IMG, new ImageProcessor());
        dispatcher.put(FmtCode.FLAC, new FlacProcessor());
        dispatcher.put(FmtCode.VID, new VidProcessor());
        dispatcher.get(fmt).process(num);
    }
}
