import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(7777);
            GestorTareasImpl gestor = new GestorTareasImpl();
            registry.rebind("GestorTareasService", gestor);

            System.out.println("Registro RMI creado en puerto 1099");
            System.out.println("Servidor de Gestor de Tareas iniciado");
            System.out.println("Esperando clientes...");

        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}