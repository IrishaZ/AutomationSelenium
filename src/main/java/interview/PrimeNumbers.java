package interview;

public class PrimeNumbers {
    public static void main(String[] args) {
        printPrime(1000000);
    }

    private static void printPrime(int border) {
        for (int i = 2;i<=border;i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
