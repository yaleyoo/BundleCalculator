public class FlacProcessor extends Processor {
    @Override
    public void process(int num) {
        // Flac: 3 @ 427.5, 6 @ 810, 9 @ 1147.5
        int bundle_9 = num / 9;
        int rest_9 = num % 9;
        int bundle_6 = rest_9 / 6;
        int rest_6 = rest_9 % 6;
        int bundle_3 = rest_6 / 3;
        //int rest_3 = rest_6 % 3;
        double sum = bundle_9 * 1147.5 + bundle_6 * 810 + bundle_3 * 427.5;
        // print the result
        System.out.println(num + " FLAC $" + sum);
        if (bundle_9 != 0)
            System.out.println("    " + bundle_9 + " x 9 $1147.50");
        if (bundle_6 != 0)
            System.out.println("    " + bundle_6 + " x 6 $810");
        if (bundle_3 != 0)
            System.out.println("    " + bundle_3 + " x 3 $427.50");
    }
}
