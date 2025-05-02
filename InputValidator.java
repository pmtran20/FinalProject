import java.util.Scanner;

public class InputValidator {
    static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Try again.");
            return getIntInput(prompt);
        }
    }
}
