package Practical.Assignment27;
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            String message;

            while (true) {
                message = input.readLine();

                if (message == null || message.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Client: " + message);

                System.out.print("Server: ");
                message = keyboard.readLine();

                output.println(message);

                if (message == null || message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();
            serverSocket.close();
            System.out.println("Chat ended.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
