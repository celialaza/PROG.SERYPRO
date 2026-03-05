import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IGestorTareas extends Remote {
    void crearTarea(String descripcion) throws RemoteException;
    List<Tarea> listarTareas() throws RemoteException;
    boolean marcarComoCompletada(int idTarea) throws RemoteException;
    void eliminarTodas() throws RemoteException;
}