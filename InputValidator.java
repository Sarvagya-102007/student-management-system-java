import java.util.Scanner;

public class InputValidator {

    public static String getNonEmptyString(
            Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty.");
        }
    }

    public static int getInt(
            Scanner scanner,
            String message,
            int min,
            int max) {

        while (true) {

            try {

                System.out.print(message);

                int value = Integer.parseInt(
                        scanner.nextLine().trim());

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println(
                        "Enter a value between "
                                + min + " and " + max + ".");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number.");
            }
        }
    }

    public static double getDouble(
            Scanner scanner,
            String message,
            double min,
            double max) {

        while (true) {

            try {

                System.out.print(message);

                double value = Double.parseDouble(
                        scanner.nextLine().trim());

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println(
                        "Enter a value between "
                                + min + " and " + max + ".");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number.");
            }
        }
    }

    public static String getEmail(
            Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            String email = scanner.nextLine().trim();

            if (email.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

                return email;
            }

            System.out.println(
                    "Please enter a valid email address.");
        }
    }

    public static String getPhone(
            Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            String phone = scanner.nextLine().trim();

            if (phone.matches("\\d{10}")) {
                return phone;
            }

            System.out.println(
                    "Phone number must contain 10 digits.");
        }
    }
}