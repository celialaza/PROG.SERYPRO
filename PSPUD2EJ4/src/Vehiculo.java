
import java.util.Random;
/*
* La clase vehículo hereda de thread lo que permite que cada objeto que se instancia de esta clase
* se ejecute en su propio hilo.
* El comportamiento de cada vehículo será intentar entrar en una pista, realizar su prueba y salir.*/
public class Vehiculo extends Thread {

    private final Pista pista;

    public Vehiculo( String nombre, Pista pista) {
        super(nombre);
        this.pista=pista;
    }
    public void run() {
        try {
            int pistaAsignada=pista.entrar();
            System.out.println("El vehículo " +getName()+ "ha entrado en la pista: "+pistaAsignada);
            System.out.println("=======Comprobando vehículo======");
            long tiempoPrueba = (new Random().nextInt(3000) + 2000);
            Thread.sleep(tiempoPrueba);
            System.out.println("El vehículo " +getName()+"terminó la prueba en: "+tiempoPrueba/1000.0);
            pista.salir(pistaAsignada);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
