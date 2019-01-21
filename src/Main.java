import java.util.*;

enum FmtCode{
    IMG, FLAC, VID;

    public static boolean contains(String type){
        for(FmtCode typeEnum : FmtCode.values()){
            if(typeEnum.name().equals(type)){
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
                System.out.println("Index Out Of Bound. Plz check the input format at: " + e.getMessage());
            }

        }
    }

    private static void printResult(int num, FmtCode fmt){
        double sum;
        switch (fmt){
            // IMG: 5 @ 450, 10 @ 800
            case IMG:
                int bundle_10 = num / 10;
                int rest_10 = num % 10;
                int bundle_5 = rest_10 / 5;
                sum = 800 * bundle_10 + 450 * bundle_5;
                // print the result
                System.out.println(num + " " + fmt + " $" + sum);
                if (bundle_10!=0)
                    System.out.println("    " + bundle_10 + " x 10 $800");
                if (bundle_5!=0)
                    System.out.println("    " + bundle_5 + " x 5 $450");
                break;
            // Flac: 3 @ 427.5, 6 @ 810, 9 @ 1147.5
            case FLAC:
                int bundle_9 = num / 9;
                int rest_9 = num % 9;
                int bundle_6 = rest_9 / 6;
                int rest_6 = rest_9 % 6;
                int bundle_3 = rest_6 / 3;
                //int rest_3 = rest_6 % 3;
                sum = bundle_9 * 1147.5 + bundle_6 * 810 + bundle_3 * 427.5;
                // print the result
                System.out.println(num + " " + fmt + " $" + sum);
                if (bundle_9!=0)
                    System.out.println("    " + bundle_9 + " x 9 $1147.50");
                if (bundle_6!=0)
                    System.out.println("    " + bundle_6 + " x 6 $810");
                if (bundle_3!=0)
                    System.out.println("    " + bundle_3 + " x 3 $427.50");
                break;
            // VID: 3 @ 570, 5 @ 900, 9 @ 1530
            case VID:
                int bundle_9_vid = num / 9;
                int rest_9_vid = num % 9;
                int bundle_5_vid = rest_9_vid / 5;
                int rest_5_vid = rest_9_vid % 5;
                int bundle_3_vid = rest_5_vid / 3;
                sum = bundle_9_vid * 1530 + bundle_5_vid * 900 + bundle_3_vid * 570;
                // print the result
                System.out.println(num + " " + fmt + " $" + sum);
                if (bundle_9_vid!=0)
                    System.out.println("    " + bundle_9_vid + " x 9 $1530");
                if (bundle_5_vid!=0)
                    System.out.println("    " + bundle_5_vid + " x 5 $900");
                if (bundle_3_vid!=0)
                    System.out.println("    " + bundle_3_vid + " x 3 $570");
                break;
        }
    }
}
