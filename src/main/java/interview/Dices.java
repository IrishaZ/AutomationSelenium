package interview;

import java.util.Arrays;
import java.util.Random;

public class Dices {
    public static void main(String[] args) {
        int n = 5;
        int[]dices = rollDices(n);
        System.out.println(Arrays.toString(dices));

        int steps = countDices(dices);
        System.out.println(steps);

    }

    private static int countDices(int[] dices) {
        int count = 0;
        for (int dice : dices) {
            if (dice == 6) {
                continue;
            }
            if (dice == 1) {
                count = count + 2;
                continue;
            }
            count++;
        }
        return count;
    }

    private static int[] rollDices(int n) {
        Random random = new Random();
        int[]d = new int[n];
        for (int i=0;i<n;i++){
            d[i]=random.nextInt(6)+1;
        }
        return d;
    }
}
