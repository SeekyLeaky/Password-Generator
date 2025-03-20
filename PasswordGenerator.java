import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Characters and letters
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        //Prompt user for password length
        System.out.print("Enter the length of the password: ");
        int passwordLength = scanner.nextInt();
        
        //Password length safety
        if (passwordLength <= 0) {
            System.out.println("Invalid password length. Please enter a positive number.");
            return;
        }

        //Prompt user for number of passwords
        System.out.print("Enter how many passwords you need: ");
        int numPasswords = scanner.nextInt();
        
        //Number of passwords safety
        if (numPasswords <= 0) {
            System.out.println("Invalid number of passwords. Please enter a positive number.");
            return;
        }

        //Prompt user for special characters 
        System.out.print("Do you want special characters in the password? (yes/no): ");
        scanner.nextLine();  // Consume newline left-over
        String includeSpecial = scanner.nextLine().trim().toLowerCase();

        //Build the character pool
        String characterPool = upperCase + lowerCase + numbers;
        if (includeSpecial.equals("yes")) {
            characterPool += specialCharacters;
        }

        //Generate passwords
        System.out.println("\nGenerated Passwords:");
        for (int i = 0; i < numPasswords; i++) {
            StringBuilder password = new StringBuilder();
            for (int j = 0; j < passwordLength; j++) {
                int index = random.nextInt(characterPool.length());
                password.append(characterPool.charAt(index));
            }
            System.out.println((i + 1) + ": " + password.toString());
        }

        //Close scanner
        scanner.close();
    }
}