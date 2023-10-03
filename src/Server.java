import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Portul la care serverul ascultă

        try {
            // Creează un server socket
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("[Server]Serverul este activ și ascultă la portul " + port);

            // Așteaptă conexiuni de la clienți
            Socket clientSocket = serverSocket.accept();
            System.out.println("[Server]Conexiune acceptată de la " + clientSocket.getInetAddress().getHostAddress());

            // Creează fluxuri pentru a citi și trimite date
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("[Server]Mesaj primit de la client: " + message);
                // Trimite un răspuns către client
                out.println("Sunt server-ul si am primit mesajul '" + message + "'");
            }

            // Închide conexiunea cu clientul
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
