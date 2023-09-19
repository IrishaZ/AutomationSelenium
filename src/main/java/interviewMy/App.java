package interviewMy;

import java.util.*;

public class App {
    public static void main(String[] args) {
        String word1 = "word2word2";
        String word2 = "word2";

//        ArrayList<Character> arrayChar1= new ArrayList<>(word1.toCharArray);


        System.out.println(anagrams("say","aya"));
    }
    public static boolean anagrams (String word1, String word2){
        if(word1.length()!=word2.length()){
            return false;
        }
        char[] arrayChar1= word1.toCharArray();
        char[] arrayChar2= word2.toCharArray();
        Arrays.sort(arrayChar1);
        Arrays.sort(arrayChar2);
        for (int i=0; i<arrayChar1.length;i++){
            if (arrayChar1[i]!=arrayChar2[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean anagramsSet(String word1,String word2){
        char[] arrayChar1= word1.toCharArray();
        char[] arrayChar2= word2.toCharArray();
        Set<Character>  set1 = new HashSet<>();
        Set<Character>  set2 = new HashSet<>();
        for(char ch:arrayChar1){set1.add(ch);};
        for(char ch:arrayChar2){set2.add(ch);};
        if (set1.equals(set2)&& (arrayChar1.length==arrayChar2.length)){return  true;}
        return false;
    }
}