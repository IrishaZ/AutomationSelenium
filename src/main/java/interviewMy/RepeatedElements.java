package interviewMy;

import java.util.ArrayList;
import java.util.Random;

public class RepeatedElements {
    public static void main(String[] args){
        int[] randomArray = {1,1,3,4,5,6,4,1,3,0};
        for (int ar:randomArray) {
            System.out.println(ar);
        }
        ArrayList<Integer> repeatedElements = repeatedElements(randomArray);
        System.out.println(repeatedElements);


    }
    public static ArrayList<Integer> repeatedElements(int[] array){
        ArrayList<Integer> arrayRepeatedElements = new ArrayList<>();
        System.out.println(arrayRepeatedElements);
        for(int i=0; i< array.length;i++){
            int count = 0;
            if(arrayRepeatedElements.contains(array[i])){continue;}
            for(int k=i+1; k<array.length;k++) {
                if (array[i] ==array[k]){
                    count++;
                }
            };
            if (count!=0){arrayRepeatedElements.add(array[i]);
            }
        }
        return arrayRepeatedElements;
    }
    public static int[] randomArray(int n){
        Random random = new Random();
        int[]array = new int[n];
        for (int i=0;i<n;i++){
            array[i]=random.nextInt(6)+1;
        }
        return array;
    }
}