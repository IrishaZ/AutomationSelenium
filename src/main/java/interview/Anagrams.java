package interview;

import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        String word1 = "Listen";
        String word2 = "Silent";
        boolean res = isAnagram(word1,word2);
        System.out.println(res);
    }

    private static boolean isAnagram(String word1, String word2) {
        if (word1.length()!=word2.length()){
            return false;
        }
        String w1 = word1.toUpperCase();
        String w2 = word2.toUpperCase();

        char[]arr1 = w1.toCharArray();
        char[]arr2 = w2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0;i< arr2.length; i++){
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
