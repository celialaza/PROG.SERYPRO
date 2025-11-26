import java.util.LinkedList;

public class Ascensor extends Thread {
    private int pisoActual;
    private LinkedList<Usuario> colaPeticiones = new LinkedList<>();;
    private Boolean activo=true;

    public Ascensor() {}
    public synchronized void agregarUsuario(Usuario nuevoUsuario) {
        colaPeticiones.add(nuevoUsuario);
        notifyAll();
    }
    public void moverAscensorHacia( int pisoDestino){
        try{
            while(pisoActual < pisoDestino){
                Thread.sleep(1000);
                pisoActual++;
                System.out.println("Ascensor en piso "+pisoActual);
            }
            while(pisoActual > pisoDestino){
                Thread.sleep(1000);
                pisoActual--;
                System.out.println("Ascensor en piso "+pisoActual);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void run(){

        while(activo){
            //Este bloque asegura que solo unhilo puede ejecutar este código a la vez. Protege la colaPeticiones
            //para evitar que el hilo main intente añadir unusuario mientras el hhilo ascensor intenta sacarlo,
            //lo que podría corromper la lista.
            synchronized(this){
                try {
                    while(colaPeticiones.isEmpty()){
                        System.out.println("Ascensor en espera, sin peticiones");
                        /*Pone al hilo ascensor a dormir. al hacerlo, libera el cerrojo(synchronized lock)
                        permitiendo que otros hilos(como el main) puedan entrar al método agregarUsuario
                        para añadir una petición
                        NotifyAll(): En el método agregarUsuario, esta llamada es la que despierta
                        a cualquier hilo que estuviera en wait().Cuando el main añade un usuario, deespierta
                        al ascensor para que compruebe de nuevo la cola y vea que ahora sí hay trabajo
                         */
                        wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                Usuario usuarioActual= colaPeticiones.poll(); //Saca el primer usuario de la cola
                if (usuarioActual != null) {
                    System.out.println("Usuario: "+usuarioActual.getNombre()+" espera en el piso: "+usuarioActual.getPisoOrigen());
                    System.out.println("Ascensor en piso "+pisoActual);
                    moverAscensorHacia(usuarioActual.getPisoOrigen());
                    System.out.println("Usuario "+usuarioActual.getNombre()+" sube al ascensor.");
                    moverAscensorHacia(usuarioActual.getPisoDestino());
                    System.out.println("Usuario "+usuarioActual.getNombre()+" baja en piso: "+usuarioActual.getPisoDestino());
                }

            }
            System.out.println("No hay más usuarios pendientes");
            moverAscensorHacia(-1);
            System.out.println("Ascensor llegó al piso -1.");

        }



    }
}
