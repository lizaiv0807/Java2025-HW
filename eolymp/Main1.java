import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int y;
        if(number<5){
            y=number*number-3*number+4;

        } else {
            y=number+7;
        }
        System.out.printf("%d\n", y);

    }
}
