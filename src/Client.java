import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Adresa IP a serverului
        int serverPort = 12345; // Portul la care serverul ascultă

        try {
            // Creează un socket pentru client și se conectează la server
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("[Client]Conectat la serverul " + serverAddress + ":" + serverPort);

            // Creează fluxuri pentru a citi și trimite date
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;

            while (true) {
                System.out.print("\n[Client]Introduceți un mesaj pentru server: ");
                message = userInput.readLine();

                // Trimite mesajul către server
                out.println(message);

                // Așteaptă răspunsul de la server
                String response = in.readLine();
                System.out.println("[Client]Răspuns de la server: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
