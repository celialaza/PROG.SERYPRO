
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorCliente implements Runnable {

    private Socket socket;
    private ServidorChat servidor;
    private PrintWriter out;
    private BufferedReader in;
    private String nombre;

    public ManejadorCliente(Socket socket, ServidorChat servidor) {
        this.socket = socket;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Bienvenido al chat! Por favor, escribe tu nombre:");
            this.nombre = in.readLine();

            System.out.println(this.nombre + " se ha unido al chat.");
            System.out.flush();

            servidor.retransmitirMensaje(this.nombre + " se ha unido al chat.", this);

            String mensajeCliente;
            while ((mensajeCliente = in.readLine()) != null) {
                System.out.println("Mensaje de " + this.nombre + ": " + mensajeCliente);
                System.out.flush();

                String mensajeCompleto = this.nombre + ": " + mensajeCliente;
                servidor.retransmitirMensaje(mensajeCompleto, this);
            }

        } catch (IOException e) {
            // Cliente se desconectó
        } finally {
            servidor.eliminarCliente(this);
            if (this.nombre != null) {
                System.out.println(this.nombre + " ha salido del chat.");
                System.out.flush();
                servidor.retransmitirMensaje(this.nombre + " ha salido del chat.", this);
            }

            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void enviarMensaje(String mensaje) {
        out.println(mensaje);
    }

    public String getNombre() {
        return nombre;
    }
}