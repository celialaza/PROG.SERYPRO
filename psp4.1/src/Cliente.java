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
            int num1, num2, num3;
            while(opcion!=0){
                System.out.println("Seleccione una operacion:");
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar");
                System.out.println("4. Dividir");
                System.out.println("5. Porcentaje");
                System.out.println("6. Resto");
                System.out.println("7. Media");
                System.out.println("0. Salir");
                System.out.println("Ingrese su opcion: ");
                opcion = sc.nextInt();

            switch(opcion){

                case 1:
                    System.out.println("Ingrese el primer número para sumar:");
                    num1=sc.nextInt();
                    System.out.println("Ingrese el segundo número para sumar:");
                    num2= sc.nextInt();

                    System.out.println("El resultado de la suma es: " + interfaz.sumar(num1, num2));
                    break;
                case 2:
                    System.out.println("Ingrese el primer número para restar:");
                    num1=sc.nextInt();
                    System.out.println("Ingrese el segundo número para restar:");
                    num2= sc.nextInt();
                    System.out.println("El resultado de la resta es: " + interfaz.restar(num1, num2));
                    break;
                case 3:
                    System.out.println("Ingrese el primer número para multiplicar:");
                    num1=sc.nextInt();
                    System.out.println("Ingrese el segundo número para multiplicar:");
                    num2= sc.nextInt();
                    System.out.println("El resultado de la multiplicacion es: " + interfaz.multiplicar(num1, num2));
                    break;
                case 4:
                    System.out.println("Ingrese el primer número para dividir:");
                    num1=sc.nextInt();
                    System.out.println("Ingrese el segundo número para dividir:");
                    num2= sc.nextInt();
                    System.out.println("El resultado de la division es: " + interfaz.dividir(num1, num2));
                    break;
                case 5:
                    System.out.println("Ingrese el primer número para calcular el porcentaje:");
                    num1=sc.nextInt();
                    System.out.println("Ingrese el segundo número para calcular el porcentaje:");
                    num2= sc.nextInt();
                    System.out.println("El resultado del porcentaje es: " + interfaz.porcentaje(num1, num2));
                    break;
                case 6:
                    System.out.println("Ingrese el primer número para calcular el resto:");
                    num1=sc.nextInt();
                    System.out.println("Ingrese el segundo número para calcular el resto:");
                    num2= sc.nextInt();
                    System.out.println("El resultado del resto es: " + interfaz.resto(num1, num2));
                    break;
                case 7:
                    System.out.println("Ingrese el primer número para calcular la media:");
                    num1=sc.nextInt();
                    System.out.println("Ingrese el segundo número para calcular la media:");
                    num2= sc.nextInt();
                    System.out.println("Ingrese el tercer número para calcular la media:");
                    num3= sc.nextInt();
                    System.out.println("El resultado de la media es: " + interfaz.media(num1, num2, num3));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }


    }    sc.close();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}



