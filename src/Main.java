public class Main {
    public static void main(String[] args) {
        // Creează și lansează serverul într-un fir de execuție separat
        Thread serverThread = new Thread(() -> {
            Server server = new Server();
            server.main(args);
        });
        serverThread.start();

        // Creează și lansează clientul
        Client client = new Client();
        client.main(args);
    }
}