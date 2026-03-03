import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;


public class PalindromeCheckerApp {
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker Using Deque (UC7) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional preprocessing: remove spaces and convert to lowercase
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new LinkedList<>();

        // Insert characters into Deque
        for (int i = 0; i < processedInput.length(); i++) {
            deque.addLast(processedInput.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear elements
        while (deque.size() > 1) {

            char front = deque.removeFirst();  // Remove from front
            char rear = deque.removeLast();    // Remove from rear

            if (front != rear) {
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




