package Practical.Assignment3;
// class Calculator {

//     static int count = 0;

//     int add(int a, int b) {
//         count++;
//         return a + b;
//     }

//     double add(double a, double b) {
//         count++;
//         return a + b;
//     }

//     static void displayCount() {
//         System.out.println("Total Calculations = " + count);
//     }

//     public static void main(String[] args) {

//         Calculator c = new Calculator();

//         System.out.println("Integer Addition = " + c.add(20, 30));
//         System.out.println("Decimal Addition = " + c.add(12.5, 8.5));

//         displayCount();
//     }
// }

public class Restaurant {

    static int totalOrders = 0;

    void bill(double amount) {
        totalOrders++;
        System.out.println("Dine-In Bill = Rs. " + amount);
    }

    void bill(double amount, boolean takeaway) {
        totalOrders++;
        System.out.println("Takeaway Bill = Rs. " + (amount + 20));
    }

    void bill(double amount, double deliveryCharge) {
        totalOrders++;
        System.out.println("Delivery Bill = Rs. " + (amount + deliveryCharge));
    }

    static void displayOrders() {
        System.out.println("Total Orders = " + totalOrders);
    }

    public static void main(String[] args) {

        Restaurant r = new Restaurant();

        r.bill(450);
        r.bill(320, true);
        r.bill(600, 50);

        displayOrders();
    }
}