package Practical.Assignment28;


import java.rmi.*;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) {
        try {
            TemperatureConverter converter = (TemperatureConverter)
                    Naming.lookup("rmi://localhost/TemperatureConverter");

            Scanner sc = new Scanner(System.in);

            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.print("Choose conversion: ");
            int choice = sc.nextInt();

            System.out.print("Enter temperature: ");
            double temperature = sc.nextDouble();

            if (choice == 1) {
                double result =
                        converter.celsiusToFahrenheit(temperature);

                System.out.printf("Fahrenheit: %.2f°F%n", result);
            } else if (choice == 2) {
                double result =
                        converter.fahrenheitToCelsius(temperature);

                System.out.printf("Celsius: %.2f°C%n", result);
            } else {
                System.out.println("Invalid choice.");
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
