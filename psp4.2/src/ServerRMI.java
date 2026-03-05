import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerRMI extends UnicastRemoteObject implements RMI{
    public ServerRMI() throws RemoteException {
        super();
    }

    @Override
    public float librasEuros(float libras) throws RemoteException {
        return libras * 1.16f;
    }

    @Override
    public float eurosLibras(float euros) throws RemoteException {
        return euros / 1.16f;
    }

    @Override
    public float dolaresEuros(float dolares) throws RemoteException {
        return dolares * 0.88f;
    }

    @Override
    public float eurosDolares(float euros) throws RemoteException {
        return euros / 0.88f;
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
