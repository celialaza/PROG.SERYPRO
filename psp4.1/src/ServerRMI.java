import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerRMI extends UnicastRemoteObject implements RMI{
    public ServerRMI() throws RemoteException {
        super();
    }
    @Override
    public int sumar(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public int restar(int a, int b) throws RemoteException {
        return a-b;
    }

    @Override
    public int multiplicar(int a, int b) throws RemoteException {
        return a*b;
    }

    @Override
    public double dividir(int a, int b) throws RemoteException {
        return a/b;
    }

    @Override
    public double porcentaje(int a, int b) throws RemoteException {
        return a/b*100;
    }

    @Override
    public double resto(int a, int b) throws RemoteException {
        return a%b;
    }

    @Override
    public double media(int a, int b, int c) throws RemoteException {
        return (a+b+c)/3;
    }

    public static void main(String[] args) {
        try {
            Registry registro= LocateRegistry.createRegistry(7777);
            registro.rebind("RemotoRMI", new ServerRMI());
            System.out.println("Servidor activo");
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
}
    }
}
