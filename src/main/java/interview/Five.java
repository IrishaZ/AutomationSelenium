package interview;

public class Five {
    public static void main(String[] args) {
        printFive(200);
    }

    private static void printFive(int border) {
        for (int i=0;i<=border;i++){
            String number = i+"";
            if(number.contains("5")){
                System.out.println(i);
            }
        }
    }
}
