package interviewMy;

public class BizzBuzz {
    public static void main(String[] args) {
        bizzBuzz(15);
    }
    public static void bizzBuzz(int n){
        for (int i=1; i<=n;i++){
            if (i%3==0 && i%5==0){
                System.out.println("fizzBuzz");
                continue;
            };
            if(i%5==0){
                System.out.println("buzz");
                continue;
            }
            if (i%3==0) {
                System.out.println("fizz");
            }
            System.out.println(i);
        }
    }
}
