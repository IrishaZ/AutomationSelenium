package interview;

import java.util.HashSet;
import java.util.Set;

public class Duplicates {
    public static void main(String[] args) {
        int[]numbers = {1,342,23,435,567,87,8,786,9,8798,9,9,89,0,98,-9,12,9009,0,90,98,0,1,1,435,56,23};
        Set<Integer> set = new HashSet<>();

        for (int number:numbers){
            set.add(number);
        }

        for (int number:set){
            int count=0;
            for (int x:numbers){
                if (number==x){
                    count++;
                }
            }
            if(count>1){
                System.out.println(number+" -> "+count+" times");
            }
        }
    }
}
