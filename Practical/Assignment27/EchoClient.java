package Practical.Assignment27;
import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5001);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            String message;

            while (true) {
                System.out.print("Enter message: ");
                message = keyboard.readLine();

                if (message == null || message.equalsIgnoreCase("exit")) {
                    output.println("exit");
                    break;
                }

                output.println(message);

                String response = input.readLine();
                System.out.println("Echo from server: " + response);
            }

            socket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
