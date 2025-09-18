
package securelogin;


import java.util.Scanner;

public class loginAccount {
    private String username;
    private String password;
    private String cellphone;
    private String firstName;
    private String lastName;

    // Method: Validates username format
    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // Method: Validates password complexity
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) return false;

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^A-Za-z0-9].*");

        return hasUpper && hasDigit && hasSpecial;
    }

    // Method: Validates South African cellphone format
    public boolean checkCellPhoneNumber(String cellphone) {
        if (cellphone == null) return false;
        return cellphone.matches("^(\\+27|0027)\\d{9}$");
    }

    // Method: Handles registration and returns feedback
    public String registerUser(Scanner scanner) {
        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();

        // Username
        while (true) {
            System.out.print("Enter username (must contain _ and be ≤5 characters): ");
            username = scanner.nextLine();
            if (checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        // Password
        while (true) {
            System.out.print("Enter password (8+ chars, capital, number, special char): ");
            password = scanner.nextLine();
            if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // Cellphone
        while (true) {
            System.out.print("Enter South African cellphone number (with +27 or 0027): ");
            cellphone = scanner.nextLine();
            if (checkCellPhoneNumber(cellphone)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        return "Registration Complete!\nWelcome, " + firstName + " " + lastName +
               "\nUsername: " + username + "\nCell: " + cellphone;
    }

    // Method: Verifies login credentials
    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    // Method: Returns login status message
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loginAccount system = new loginAccount();

        System.out.println("=== User Registration ===");
        System.out.println(system.registerUser(scanner));

        System.out.println("\n=== Login ===");
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Enter your username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Enter your password: ");
            String inputPassword = scanner.nextLine();

            loggedIn = system.loginUser(inputUsername, inputPassword);
            System.out.println(system.returnLoginStatus(loggedIn));
        }

        scanner.close();
    }
}
