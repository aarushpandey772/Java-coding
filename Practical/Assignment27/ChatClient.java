package Practical.Assignment27;
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            String message;

            while (true) {
                System.out.print("Client: ");
                message = keyboard.readLine();

                output.println(message);

                if (message == null || message.equalsIgnoreCase("exit")) {
                    break;
                }

                message = input.readLine();

                if (message == null || message.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Server: " + message);
            }

            socket.close();
            System.out.println("Chat ended.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
