
package securelogin;


import java.util.Scanner;

public class Securelogin {
    private String username;
    private String password;
    private String cellphone;
    private String firstName;
    private String lastName;

    public void registerUser(Scanner scanner) {
        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();

        // Username validation
        while (true) {
            System.out.print("Enter your username (must contain _ and be ≤5 characters): ");
            username = scanner.nextLine();
            if (checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        // Password validation
        while (true) {
            System.out.print("Enter your password (8+ chars, capital, number, special char): ");
            password = scanner.nextLine();
            if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // Cellphone validation
        while (true) {
            System.out.print("Enter your South African cellphone number (with +27 or 0027): ");
            cellphone = scanner.nextLine();
            if (checkCellPhoneNumber(cellphone)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        // Registration complete
        System.out.println("\nRegistration Complete!");
        System.out.println("Welcome, " + firstName + " " + lastName);
        System.out.println("Username: " + username);
        System.out.println("Cell: " + cellphone);
    }

    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) return false;

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^A-Za-z0-9].*");

        return hasUpper && hasDigit && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String cellphone) {
        if (cellphone == null) return false;
        return cellphone.matches("^(\\+27|0027)\\d{9}$");
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Securelogin userSignUp = new Securelogin();
            userSignUp.registerUser(scanner);
            
            // Login process
            System.out.println("\n=== Login ===");
            while (true) {
                System.out.print("Enter your username: ");
                String inputUsername = scanner.nextLine();
                
                System.out.print("Enter your password: ");
                String inputPassword = scanner.nextLine();
                
                if (userSignUp.loginUser(inputUsername, inputPassword)) {
                    System.out.println("Welcome " + userSignUp.firstName + " " + userSignUp.lastName + "! Great to see you again.");
                    break;
                } else {
                    System.out.println("Username or password incorrect, please try again.");
                }
            }
        }
    }
}
