package Practical.Assignment9;
// class BankAccount {

//     final int accountNumber;
//     String customerName;
//     double balance;

//     BankAccount(int accountNumber, String customerName, double balance) {
//         this.accountNumber = accountNumber;
//         this.customerName = customerName;
//         this.balance = balance;
//     }

//     void display() {
//         System.out.println("Account Number : " + accountNumber);
//         System.out.println("Customer Name : " + customerName);
//         System.out.println("Balance : " + balance);
//     }

//     public static void main(String[] args) {

//         BankAccount b = new BankAccount(123456, "Aarush", 25000);

//         b.display();
//     }
// }

class Book {

    final String isbn;
    String title;
    String author;
    double price;

    Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("ISBN : " + isbn);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
    }

    public static void main(String[] args) {

        Book b = new Book("9788131701625", "Java Programming", "Herbert Schildt", 699);

        b.display();
    }
}