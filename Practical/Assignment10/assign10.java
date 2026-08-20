package Practical.Assignment10;
// abstract class Payment {

//     abstract void pay(double amount);
// }

// class CreditCard extends Payment {

//     void pay(double amount) {
//         System.out.println("Payment through Credit Card");
//         System.out.println("Amount Paid : Rs. " + amount);
//     }
// }

// class UPI extends Payment {

//     void pay(double amount) {
//         System.out.println("Payment through UPI");
//         System.out.println("Amount Paid : Rs. " + amount);
//     }
// }

// public class PaymentDemo {

//     public static void main(String[] args) {

//         Payment p1 = new CreditCard();
//         Payment p2 = new UPI();

//         p1.pay(2500);
//         System.out.println();
//         p2.pay(1800);
//     }
// }


abstract class FoodOrder {

    double amount;

    FoodOrder(double amount) {
        this.amount = amount;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {

    DineInOrder(double amount) {
        super(amount);
    }

    void calculateBill() {
        double total = amount + amount * 0.05;
        System.out.println("Dine-In Bill : Rs. " + total);
    }
}

class TakeAwayOrder extends FoodOrder {

    TakeAwayOrder(double amount) {
        super(amount);
    }

    void calculateBill() {
        double total = amount + 30;
        System.out.println("Takeaway Bill : Rs. " + total);
    }
}

public class assign10 {

    public static void main(String[] args) {

        FoodOrder d = new DineInOrder(600);
        FoodOrder t = new TakeAwayOrder(600);

        d.calculateBill();
        t.calculateBill();
    }
}