import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class GestorTareasImpl extends UnicastRemoteObject implements IGestorTareas {
    private List<Tarea> listaTareas;
    private int contadorId;

    public GestorTareasImpl() throws RemoteException {
        super();
        this.listaTareas = new ArrayList<>();
        this.contadorId = 1;
    }

    @Override
    public void crearTarea(String descripcion) throws RemoteException {
        Tarea nuevaTarea = new Tarea(contadorId++, descripcion);
        listaTareas.add(nuevaTarea);
        System.out.println("Nueva tarea creada: " + descripcion);
    }

    @Override
    public List<Tarea> listarTareas() throws RemoteException {
        return listaTareas;
    }

    @Override
    public boolean marcarComoCompletada(int idTarea) throws RemoteException {
        for (Tarea t : listaTareas) {
            if (t.getId() == idTarea) {
                t.setCompletada(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public void eliminarTodas() throws RemoteException {
        listaTareas.clear();
        contadorId = 1;
        System.out.println("Todas las tareas han sido eliminadas.");
    }
}