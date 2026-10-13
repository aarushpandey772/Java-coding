package Practical.Assignment28;


import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

class CalculatorImpl extends UnicastRemoteObject
        implements Calculator {

    CalculatorImpl() throws RemoteException {
        super();
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            Calculator calculator = new CalculatorImpl();

            Naming.rebind("rmi://localhost/Calculator", calculator);

            System.out.println("Calculator Server is ready.");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
