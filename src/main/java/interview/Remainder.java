package interview;

public class Remainder {
    public static void main(String[] args) {
        int res = remainder(15,4);
        System.out.println(res);

        res = remainder2(15,4);
        System.out.println(res);

    }

    private static int remainder2(int a, int b) {
        while (a>=b){
            a=a-b;
        }
        return a;
    }

    private static int remainder(int a, int b) {
        int c = a/b;
        return a-c*b;
    }


}
