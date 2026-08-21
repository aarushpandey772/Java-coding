import java.util.Scanner;

public class ATMVerification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter ATM PIN: ");
            int pin = sc.nextInt();

            if (pin != 1234) {
                throw new Exception("Invalid PIN");
            }

            System.out.println("PIN verified successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Verification process has completed");
        }

        sc.close();
    }
}