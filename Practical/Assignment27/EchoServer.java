package Practical.Assignment27;
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5001);
            System.out.println("Echo Server waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            String message;

            while ((message = input.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Received: " + message);
                output.println(message);
            }

            socket.close();
            serverSocket.close();
            System.out.println("Echo Server closed.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
