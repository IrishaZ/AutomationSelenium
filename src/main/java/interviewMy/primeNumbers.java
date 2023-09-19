package interviewMy;

import java.util.ArrayList;

public class primeNumbers {
    public static void main(String[] args) {
//        System.out.println(primeNumbers(10));
        printPrime(20);
    }
    public static ArrayList<Integer> primeNumbers(Integer n){
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for(int i =1; i<=n; i++){
            int count = 0;
            for (int k =1; k<=i; k++){
                if(i%k==0){count++;}
            }
            if (count==2){primeNumbers.add(i);};
        }
        return primeNumbers;
    }
    public static void printPrime(int n){
        for(int i=2; i<=n;i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int k=2; k<n; k++){
            if(n%k ==0){ return false;}
        }
        return true;
    }
}