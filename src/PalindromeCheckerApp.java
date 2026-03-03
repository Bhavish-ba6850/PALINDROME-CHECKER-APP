import java.util.*;
interface PalindromeStrategy {
    boolean check(String input);
}

// Concrete Strategy 1: Stack आधारित Algorithm
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : processed.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Concrete Strategy 2: Deque आधारित Algorithm
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (char ch : processed.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
    }
}

public class PalindromeCheckerApp {


    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Strategy Pattern Palindrome Checker (UC12) ===");
        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.execute(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
            }
        }




