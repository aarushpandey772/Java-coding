

import java.util.Scanner;

public class OnlineShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter product quantity: ");
            int quantity = sc.nextInt();

            if (quantity <= 0) {
                throw new Exception("Invalid quantity. Quantity must be greater than zero.");
            }

            System.out.println("Product quantity accepted: " + quantity);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}