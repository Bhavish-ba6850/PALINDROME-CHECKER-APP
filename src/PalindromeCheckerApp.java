import java.util.*;

public class PalindromeCheckerApp {


    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Performance Comparison (UC13) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize once
        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Stack Approach
        long startStack = System.nanoTime();
        boolean stackResult = checkUsingStack(processed);
        long endStack = System.nanoTime();

        // Deque Approach
        long startDeque = System.nanoTime();
        boolean dequeResult = checkUsingDeque(processed);
        long endDeque = System.nanoTime();

        // Two Pointer Approach
        long startTwoPointer = System.nanoTime();
        boolean twoPointerResult = checkUsingTwoPointer(processed);
        long endTwoPointer = System.nanoTime();

        System.out.println("\n=== Results ===");
        System.out.println("Stack Result: " + stackResult +
                " | Time: " + (endStack - startStack) + " ns");

        System.out.println("Deque Result: " + dequeResult +
                " | Time: " + (endDeque - startDeque) + " ns");

        System.out.println("Two Pointer Result: " + twoPointerResult +
                " | Time: " + (endTwoPointer - startTwoPointer) + " ns");

        scanner.close();
    }


    public static boolean checkUsingStack(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }


    public static boolean checkUsingDeque(String str) {

        Deque<Character> deque = new LinkedList<>();

        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    // Two Pointer Method (Most Optimized)
    public static boolean checkUsingTwoPointer(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
            }
        }




