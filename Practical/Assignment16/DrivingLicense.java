import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class DrivingLicense {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            if (age < 18) {
                throw new InvalidAgeException("You are not eligible for a driving license");
            }

            System.out.println("You are eligible for a driving license");

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}