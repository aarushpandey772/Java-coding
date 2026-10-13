package Practical.Assignment28;


import java.rmi.*;

public interface TemperatureConverter extends Remote {
    double celsiusToFahrenheit(double celsius)
            throws RemoteException;

    double fahrenheitToCelsius(double fahrenheit)
            throws RemoteException;
}
