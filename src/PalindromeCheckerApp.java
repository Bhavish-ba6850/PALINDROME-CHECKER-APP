import java.util.Scanner;


public class PalindromeCheckerApp {


    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Case-Insensitive & Space-Ignored Palindrome Checker (UC10) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Normalize string
        // Remove all spaces and non-alphanumeric characters
        // Convert to lowercase
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Apply palindrome logic (Two-pointer approach)
        boolean isPalindrome = checkPalindrome(normalized);

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    public static boolean checkPalindrome(String str) {

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




