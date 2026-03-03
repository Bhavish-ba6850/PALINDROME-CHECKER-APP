import java.util.Scanner;
import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main(String[] args){


            Scanner scanner = new Scanner(System.in);

            System.out.println("=== Palindrome Checker Using Stack (UC5) ===");
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Remove spaces and convert to lowercase (optional enhancement)
            String processedInput = input.replaceAll("\\s+", "").toLowerCase();

            Stack<Character> stack = new Stack<>();

            // Push all characters onto stack
            for (int i = 0; i < processedInput.length(); i++) {
                stack.push(processedInput.charAt(i));
            }

            // Pop characters to build reversed string
            String reversedString = "";
            while (!stack.isEmpty()) {
                reversedString += stack.pop();
            }

            // Compare original and reversed strings
            if (processedInput.equals(reversedString)) {
                System.out.println("Result: The given string is a Palindrome.");
            } else {
                System.out.println("Result: The given string is NOT a Palindrome.");
            }

            scanner.close();
            }
        }




