
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 7777);

            IGestorTareas servicio = (IGestorTareas) registry.lookup("GestorTareasService");

            System.out.println("Conectado al Gestor de Tareas");

            Scanner sc = new Scanner(System.in);
            int opcion = 1;

            while (opcion != 0) {
                System.out.println("\n=== GESTOR DE TAREAS ===");
                System.out.println("1. Crear nueva tarea");
                System.out.println("2. Listar todas las tareas");
                System.out.println("3. Marcar tarea como completada");
                System.out.println("4. Eliminar todas las tareas");
                System.out.println("0. Salir");

                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese la descripción de la tarea: ");
                        String desc = sc.nextLine();
                        servicio.crearTarea(desc);
                        System.out.println("✓ Tarea creada exitosamente");
                        break;

                    case 2:
                        List<Tarea> tareas = servicio.listarTareas();
                        if (tareas.isEmpty()) {
                            System.out.println("No hay tareas registradas");
                        } else {
                            System.out.println("LISTA DE TAREAS");
                            for (Tarea t : tareas) {
                                System.out.println(t);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el ID de la tarea a completar: ");
                        int id = sc.nextInt();
                        boolean exito = servicio.marcarComoCompletada(id);
                        if (exito) {
                            System.out.println("Tarea marcada como completada");
                        } else {
                            System.out.println("No se encontró una tarea con ese ID");
                        }
                        break;

                    case 4:
                        System.out.print("¿Está seguro de eliminar todas las tareas? (S/N): ");
                        String confirm = sc.next();
                        if (confirm.equalsIgnoreCase("S")) {
                            servicio.eliminarTodas();
                            System.out.println("✓ Todas las tareas han sido eliminadas");
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo del programa.");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
            sc.close();

        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        } catch (NotBoundException ex) {
            throw new RuntimeException(ex);
        }
    }


}