import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote {
    public int sumar(int a, int b) throws RemoteException;
    public int restar(int a, int b) throws RemoteException;
    public int multiplicar(int a, int b) throws RemoteException;
    public double dividir(int a, int b) throws RemoteException;
    public double porcentaje(int a, int b) throws RemoteException;
    public double resto(int a, int b) throws RemoteException;
    public double media(int a, int b,int c) throws RemoteException;


}
