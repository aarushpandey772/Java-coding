package Java.Practical.Assignment15;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (!password.equals("admin123")) {
                throw new Exception("Invalid password");
            }

            System.out.println("Login successful");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Login process completed");
        }

        sc.close();
    }
}