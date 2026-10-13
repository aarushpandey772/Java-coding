
class Account {
    private int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()
                + " deposited: " + amount
                + " | Balance: " + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " withdrew: " + amount
                    + " | Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " cannot withdraw " + amount
                    + " | Insufficient balance: " + balance);
        }
    }

    int getBalance() {
        return balance;
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Account account = new Account();

        Thread depositThread = new Thread(() -> {
            account.deposit(500);
            account.deposit(300);
            account.deposit(200);
        }, "Deposit Thread");

        Thread withdrawThread = new Thread(() -> {
            account.withdraw(400);
            account.withdraw(600);
            account.withdraw(300);
        }, "Withdrawal Thread");

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final Balance: "
                + account.getBalance());
    }
}
