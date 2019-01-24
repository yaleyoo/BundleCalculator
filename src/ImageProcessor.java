public class ImageProcessor extends Processor{
    @Override
    public void process(int num) {
        // IMG: 5 @ 450, 10 @ 800
        int bundle_10 = num / 10;
        int rest_10 = num % 10;
        int bundle_5 = rest_10 / 5;
        int sum = 800 * bundle_10 + 450 * bundle_5;
        // print the result
        System.out.println(num + " IMG $" + sum);
        if (bundle_10!=0)
            System.out.println("    " + bundle_10 + " x 10 $800");
        if (bundle_5!=0)
            System.out.println("    " + bundle_5 + " x 5 $450");
    }
}
