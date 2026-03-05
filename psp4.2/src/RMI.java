import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote {
    public float librasEuros (float libras) throws RemoteException;
    public float eurosLibras (float euros) throws RemoteException;
    public float dolaresEuros (float dolares) throws RemoteException;
    public float eurosDolares (float euros) throws RemoteException;
}
