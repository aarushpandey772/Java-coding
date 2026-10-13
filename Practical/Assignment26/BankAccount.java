
class Bank {
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
                    + " failed to withdraw: " + amount
                    + " | Insufficient balance: " + balance);
        }
    }

    int getBalance() {
        return balance;
    }
}

class DepositTask implements Runnable {
    private Bank bank;

    DepositTask(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        bank.deposit(500);
        bank.deposit(300);
        bank.deposit(200);
    }
}

class WithdrawalTask implements Runnable {
    private Bank bank;

    WithdrawalTask(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        bank.withdraw(400);
        bank.withdraw(600);
        bank.withdraw(300);
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Thread depositThread =
                new Thread(new DepositTask(bank), "Deposit Thread");

        Thread withdrawalThread =
                new Thread(new WithdrawalTask(bank), "Withdrawal Thread");

        depositThread.start();
        withdrawalThread.start();

        try {
            depositThread.join();
            withdrawalThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final Balance: " + bank.getBalance());
    }
}
