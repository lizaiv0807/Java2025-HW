import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers for list1, separated by spaces (e.g.: 1 2 4):");
        List<Integer> numbers1 = readNumbersFromInput(scanner);

        System.out.println("Enter numbers for list2, separated by spaces (e.g.: 1 3 4):");
        List<Integer> numbers2 = readNumbersFromInput(scanner);

        System.out.println("--- LeetCode Task (Points 4, 5) ---");

        ListNode list1 = createListNodeList(numbers1);
        ListNode list2 = createListNodeList(numbers2);

        Solution solution = new Solution();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        System.out.print("Merged result: ");
        printList(mergedList);

        System.out.println("\n--- Alternative Solution (Point 7) ---");

        LinkedList<Integer> javaList1 = new LinkedList<>(numbers1);
        LinkedList<Integer> javaList2 = new LinkedList<>(numbers2);

        javaList1.addAll(javaList2);
        Collections.sort(javaList1);

        System.out.println("Merged result (java.util.LinkedList): " + javaList1);

        scanner.close();
    }

    private static List<Integer> readNumbersFromInput(Scanner scanner) {
        String line = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();

        if (line == null || line.trim().isEmpty()) {
            return numbers;
        }

        String[] numberStrings = line.trim().split("\\s+");

        for (String numStr : numberStrings) {
            try {
                numbers.add(Integer.parseInt(numStr));
            } catch (NumberFormatException e) {

            }
        }
        return numbers;
    }

    private static ListNode createListNodeList(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int val : numbers) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}