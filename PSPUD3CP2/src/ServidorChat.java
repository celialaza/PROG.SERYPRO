
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServidorChat {

    private final int PUERTO = 1234;
    private List<ManejadorCliente> clientesConectados = new CopyOnWriteArrayList<>();

    public void iniciar() {
        System.out.println("Servidor de chat iniciado en el puerto 1234");
        System.out.flush();

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {

            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + socketCliente.getInetAddress().getHostAddress());
                System.out.flush();

                ManejadorCliente manejador = new ManejadorCliente(socketCliente, this);
                clientesConectados.add(manejador);
                new Thread(manejador).start();
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    public void retransmitirMensaje(String mensaje, ManejadorCliente emisor) {
        for (ManejadorCliente cliente : clientesConectados) {
            if (cliente != emisor) {
                cliente.enviarMensaje(mensaje);
            }
        }
    }

    public void eliminarCliente(ManejadorCliente cliente) {
        clientesConectados.remove(cliente);
    }

    public static void main(String[] args) {
        ServidorChat servidor = new ServidorChat();
        servidor.iniciar();
    }
}