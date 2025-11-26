public class SensorTemperatura  extends Thread{
    private MonitorInvernadero monitorInvernadero;

    public SensorTemperatura(MonitorInvernadero monitorInvernadero) {
        this.monitorInvernadero = monitorInvernadero;
    }

    @Override
    public void run() {
        while (true) {
            int nuevaTemperatura = (int) (Math.random() * 51);
            System.out.println("Sensor: Nueva temperatura medida: " + nuevaTemperatura + "°C");
            monitorInvernadero.escribirTemperatura(nuevaTemperatura);

            try {
                Thread.sleep(1000); // Simula un retardo entre mediciones
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
