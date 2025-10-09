
/*Esta clase es el recurso compartido que gestiona el acceso a las dos pistas.
Contiene la lógica para que un vehículo solicite, ocupe y libere una pista.
 */


public class Pista {

    private boolean[] disponibles;

    public Pista(int numeroDePistas) {
        this.disponibles = new boolean[numeroDePistas];
    }

    //Con este método buscamos una pista libre y la ocupamos.
    public int ocuparPista(){
        int pistalibre;


            for (int i = 0; i < disponibles.length; i++){
                if (disponibles[i]==false){
                disponibles[i]=true;
                pistalibre=i;
                return pistalibre;
            }

                }
        return -1;
        }

     /*El método entrar llama al de ocuparPista, si no hay ninguna libre los hilos esperan con  wait()
     hasta que otro vehículo termine y notifique con notifyAll() que una pista ha quedado libre.
     Que el método esté sincronizado asegura que solo un hilo pueda ejecutar este método a la vez.*/
        public synchronized int entrar() throws InterruptedException {
            int pistaOcupada=ocuparPista();

        while(pistaOcupada==-1) {
            System.out.println("-> " + Thread.currentThread().getName() + " esperando: No hay pistas libres.");
            wait();

            pistaOcupada = ocuparPista();

        }
        return pistaOcupada;


        }
        /*Método sincronizadopara que un vehículo libere una pista.
        Tras liberarla, notifica a todos los hilos que están esperando
         */
        public synchronized void salir(int numeroPista){
        disponibles[numeroPista]=false;
        notifyAll();

        }


    }

