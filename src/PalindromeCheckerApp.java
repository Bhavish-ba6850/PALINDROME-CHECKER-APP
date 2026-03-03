import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker Using Queue + Stack (UC6) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional preprocessing: remove spaces and convert to lowercase
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into both Stack and Queue
        for (int i = 0; i < processedInput.length(); i++) {
            char ch = processedInput.charAt(i);
            stack.push(ch);     // LIFO
            queue.add(ch);      // FIFO (Enqueue)
        }

        boolean isPalindrome = true;

        // Compare dequeue (FIFO) with pop (LIFO)
        while (!stack.isEmpty()) {
            char fromStack = stack.pop();      // LIFO
            char fromQueue = queue.remove();  // FIFO (Dequeue)

            if (fromStack != fromQueue) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
            }
        }




