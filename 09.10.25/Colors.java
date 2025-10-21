import java.util.ArrayList;
import java.util.Collections;

public class Colors {
    public static void main(String[] args) {

        // 1
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("white");
        colors.add("blue");
        colors.add("grey");
        System.out.println("Initial list: " + colors);

        // 2
        for (String i : colors) {
            System.out.println(i);
        }

        // 3
        colors.add(0, "orange");
        System.out.println(colors);

        // 4
        String element = colors.get(2);
        System.out.println("Element at index 2: " + element);

        // 5
        colors.set(3, "purple");
        System.out.println("After replacing index 3: " + colors);

        // 6
        colors.remove(2);
        System.out.println("After removing 3rd element (index 2): " + colors);

        // 7
        String colorToFind = "grey";
        boolean found = colors.contains(colorToFind);
        if (found) {
            System.out.println("List contains color '" + colorToFind + "'");
        } else {
            System.out.println("List does NOT contain color '" + colorToFind + "'");
        }
        int index = colors.indexOf("red");
        System.out.println("Index of 'red': " + index);

        // 8
        Collections.sort(colors);
        System.out.println("List after sorting: " + colors);

        // 9
        ArrayList<String> colorsCopy = (ArrayList<String>) colors.clone();
        System.out.println("Original: " + colors);
        System.out.println("Copy:     " + colorsCopy);

        // 10
        Collections.reverse(colors);
        System.out.println("Reversed original: " + colors);
        System.out.println("Copy (remained unchanged): " + colorsCopy);

        // 11
        boolean isEqual = colors.equals(colorsCopy);
        System.out.println("Are 'colors' (reversed) and 'colorsCopy' (sorted) equal? " + isEqual);

        ArrayList<String> colorsCopy2 = (ArrayList<String>) colors.clone();
        boolean isEqual2 = colors.equals(colorsCopy2);
        System.out.println("Are 'colors' and 'colorsCopy2' (new copy) equal? " + isEqual2);

        // 12
        System.out.println("Copy before clear: " + colorsCopy);
        colorsCopy.clear();
        System.out.println("Copy after clear: " + colorsCopy);

        // 13
        System.out.println("Is 'colors' (original) empty? " + colors.isEmpty());
        System.out.println("Is 'colorsCopy' (copy) empty? " + colorsCopy.isEmpty());

        // 14
        colors.ensureCapacity(50);
        System.out.println("ensureCapacity(50) called.");
        System.out.println("Current size (size) unchanged: " + colors.size());

        // 15
        colors.trimToSize();
        System.out.println("trimToSize() called.");
        System.out.println("List: " + colors);
    }
}