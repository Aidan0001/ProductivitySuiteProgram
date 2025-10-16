import java.util.Scanner;

public class InputValidator {
    /**
     * Gets a valid integer choice from the user for menu navigation
     * @param scanner The Scanner object to read input from
     * @return The user's choice as an integer, or -1 if invalid input
     */
    public static int getMenuChoice(Scanner scanner) {
        if(scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear buffer
            return choice;
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();  // Clear bad input
            return -1;  // Invalid choice
        }
    }
    
    /**
     * Validates that a string is not empty after trimming white space
     * @param input The string to validate
     * @param fieldName The name of the field (for error messages)
     * @return true if valid, false if empty
     */
    public static boolean isNotEmpty(String input, String fieldName) {
        if(input.trim().isEmpty()) {
            System.out.println(fieldName + " cannot be empty.");
            return false;
        }
        return true;
    }
    
    /**
     * Validates minimum length for a string
     * @param input The string to validate
     * @param minLength Minimum required length
     * @param fieldName The name of the field (for error messages)
     * @return true if valid, false if too short
     */
    public static boolean meetsMinLength(String input, int minLength, String fieldName) {
        if(input.length() < minLength) {
            System.out.println(fieldName + " must be at least " + minLength + " characters.");
            return false;
        }
        return true;
    }
    
    /**
     * Validates that a string doesn't contain commas (for CSV compatibility)
     * @param input The string to validate
     * @param fieldName The name of the field (for error messages)
     * @return true if valid, false if contains comma
     */
    public static boolean noCommas(String input, String fieldName) {
        if(input.contains(",")) {
            System.out.println(fieldName + " cannot contain commas.");
            return false;
        }
        return true;
    }
}
