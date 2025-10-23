import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        // example below, replace it with your solution
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i<n; i++){
            array[i] = in.nextInt();
        }
        for(int i = n-1; i>=0; i--){
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }
}
