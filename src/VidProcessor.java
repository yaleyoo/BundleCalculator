public class VidProcessor extends Processor{
    @Override
    public void process(int num) {
        // VID: 3 @ 570, 5 @ 900, 9 @ 1530
        int min = 999;
        int optimal = 0;
        int bundle_3 = 0;
        int bundle_5 = 0;
        int bundle_9 = 0;
        // 从0遍历到n/2+1，找到最理想（余数最小）的分割，穷举
        for (int i=0;i<num/2+1;i++){
            if (Math.min(i%3, i%5) + Math.min((num - i) % 3, (num - i) % 5) == 0){
                optimal = i;
                break;
            }
            if (Math.min(i%3, i%5) + Math.min((num - i) % 3, (num - i) % 5) < min){
                optimal = i;
            }
        }
        // 分割左部
        if (optimal%3 < optimal%5)
            bundle_3 = optimal/3;
        else
            bundle_5 = optimal/5;
        // 分割右部
        if ((num-optimal)%3 < (num-optimal)%5)
            bundle_3 += (num-optimal)/3;
        else
            bundle_5 += (num-optimal)/5;
        // 整合， 9*5 = 9*5， 3*3=1*9
        bundle_9 = (int)(bundle_5 / 9) * 5;
        bundle_5 = (bundle_5 * 5 - bundle_9 * 9) / 5;
        bundle_9 += bundle_3 / 3;
        bundle_3 %= 3;

        double sum = bundle_9 * 1530 + bundle_5 * 900 + bundle_3 * 570;
        // print the result
        System.out.println(num + " VID $" + sum);
        if (bundle_9!=0)
            System.out.println("    " + bundle_9 + " x 9 $1530");
        if (bundle_5!=0)
            System.out.println("    " + bundle_5 + " x 5 $900");
        if (bundle_3!=0)
            System.out.println("    " + bundle_3 + " x 3 $570");
    }
}
