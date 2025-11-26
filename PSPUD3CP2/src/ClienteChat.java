
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteChat implements Runnable {

    private final String HOST = "localhost";
    private final int PUERTO = 1234;
    private String nombre;


    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private Thread hiloReceptor;

    public ClienteChat(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {

            socket = new Socket(HOST, PUERTO);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            hiloReceptor = new Thread(() -> {
                try {
                    String mensajeServidor;
                    while ((mensajeServidor = in.readLine()) != null) {
                        System.out.println("[" + this.nombre + "] " + mensajeServidor);
                    }
                } catch (IOException e) {

                    System.out.println("Conexión cerrada por servidor para " + this.nombre);
                }
            });

            hiloReceptor.start();

            // 3. Hilo Emisor
            out.println(this.nombre);

            for (int i = 1; i <= 3; i++) {
                String mensajeSimulado = "Mensaje " + i + " de " + this.nombre;
                out.println(mensajeSimulado);
                Thread.sleep(500);
            }

            Thread.sleep(2000);

        } catch (Exception e) {
            System.err.println("[" + this.nombre + "] Error en el cliente: " + e.getMessage());
        } finally {

            try {

                if (socket != null) {
                    socket.close();
                }


                if (hiloReceptor != null) {
                    hiloReceptor.join();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}