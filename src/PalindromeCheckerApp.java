import java.util.Scanner;


public class PalindromeCheckerApp {


    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker Using Recursion (UC9) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional preprocessing
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = checkPalindrome(processedInput, 0, processedInput.length() - 1);

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Recursive method
    public static boolean checkPalindrome(String str, int start, int end) {

        // Base Condition: If pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Call
        return checkPalindrome(str, start + 1, end - 1);
            }
        }




