package Practical.Assignment14;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 10000;

        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0 || amount > balance) {
                throw new Exception("Invalid withdrawal amount");
            }

            balance = balance - amount;
            System.out.println("Withdrawal successful");
            System.out.println("Remaining balance: " + balance);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}