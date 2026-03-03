import java.util.Scanner;


public class PalindromeCheckerApp {
    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker Using Singly Linked List (UC8) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional preprocessing
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        // Convert string to linked list
        Node head = null, tail = null;

        for (int i = 0; i < processedInput.length(); i++) {
            Node newNode = new Node(processedInput.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        boolean isPalindrome = checkPalindrome(head);

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Method to check palindrome using linked list
    public static boolean checkPalindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle using Fast & Slow pointers
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverse(slow);

        // Step 3: Compare first half and reversed second half
        Node firstHalf = head;
        Node tempSecond = secondHalf;

        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    // Method to reverse linked list
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
            }
        }




