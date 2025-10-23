import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        // example below, replace it with your solution
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            int p = (n+m)*2;
            int s = n*m;
            System.out.printf("%d %d\n", p, s);
        }
    }
}
