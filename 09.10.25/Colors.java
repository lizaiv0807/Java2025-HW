import java.util.ArrayList;
import java.util.Collections;

public class Colors {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("wite");
        colors.add("blue");
        colors.add("grey");

        Collections.sort(colors);

        System.out.println("--- ---");

        for (String i : colors) {
            System.out.println(i);
        }
        System.out.println("--- ---");
        colors.add(0, "orange");
        for (String i : colors) {
            System.out.println(i);
        }

        System.out.println("---4 ---");
        String element = colors.get(2);
        System.out.println("element with index 2 " + element);

        System.out.println("---5 ---");
        colors.set(3, "purple");
        System.out.println(" change with index 2  " + colors);

        System.out.println("---6 ---");
        colors.remove(4);
        System.out.println("delete 4  " + colors);

        System.out.println("--- 7---");

    }
}