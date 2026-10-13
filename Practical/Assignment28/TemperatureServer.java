package Practical.Assignment28;


import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

class TemperatureImpl extends UnicastRemoteObject
        implements TemperatureConverter {

    TemperatureImpl() throws RemoteException {
        super();
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}

public class TemperatureServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            TemperatureConverter converter = new TemperatureImpl();

            Naming.rebind(
                    "rmi://localhost/TemperatureConverter", converter);

            System.out.println("Temperature Server is ready.");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
