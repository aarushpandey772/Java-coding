
class NumberThread extends Thread {
    private int start;

    NumberThread(int start) {
        this.start = start;
    }

    public void run() {
        for (int i = start; i < start + 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " prints: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread(1);
        NumberThread t2 = new NumberThread(6);
        NumberThread t3 = new NumberThread(11);

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
