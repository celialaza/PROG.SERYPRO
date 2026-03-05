import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.connectServer();
    }
    private void connectServer() {
        Scanner sc = new Scanner(System.in);
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 7777);
            RMI interfaz = (RMI) registro.lookup("RemotoRMI");

            int opcion = 1;
            while (opcion != 0) {
                System.out.println("Seleccione una operacion: ");

                System.out.println("1. Convertir de libras  a euros");
                System.out.println("2. Convertir de euros a libras");
                System.out.println("3. Convertir de dolares a euros");
                System.out.println("4. Convertir de euros a dolares");
                System.out.println("0. Salir");
                opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad en libras: ");
                    float libras = sc.nextFloat();
                    float eurosFromLibras = interfaz.librasEuros(libras);
                    System.out.println(libras + " libras son " + eurosFromLibras + " euros.");
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad en euros: ");
                    float euros = sc.nextFloat();
                    float librasFromEuros = interfaz.eurosLibras(euros);
                    System.out.println(euros + " euros son " + librasFromEuros + " libras.");
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad en dolares: ");
                    float dolares = sc.nextFloat();
                    float eurosFromDolares = interfaz.dolaresEuros(dolares);
                    System.out.println(dolares + " dolares son " + eurosFromDolares + " euros.");
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad en euros: ");
                    float euros2 = sc.nextFloat();
                    float dolaresFromEuros = interfaz.eurosDolares(euros2);
                    System.out.println(euros2 + " euros son " + dolaresFromEuros + " dolares.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
            }sc.close();
        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        } catch (NotBoundException ex) {
            throw new RuntimeException(ex);

        }
    }
}


