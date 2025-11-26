public class ControladorAmbiental extends Thread{
    private MonitorInvernadero monitorInvernadero;
    private final int UMBRAL_TEMPERATURA=28;

    public ControladorAmbiental(MonitorInvernadero monitorInvernadero) {
        this.monitorInvernadero = monitorInvernadero;
    }

    @Override
    public void run() {
        while (true) {
            int temperaturaLeida = monitorInvernadero.leerTemperatura();
            System.out.println("Controlador: Temperatura recibida: " + temperaturaLeida + "°C");

            if (temperaturaLeida > UMBRAL_TEMPERATURA) {
                System.out.println("Controlador: La temperatura es alta (" + temperaturaLeida + "°C). Activando sistema de enfriamiento.");
            } else {
                System.out.println("Controlador: La temperatura es adecuada (" + temperaturaLeida + "°C). No se requiere acción.");
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
