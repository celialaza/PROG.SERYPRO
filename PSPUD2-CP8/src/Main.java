//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class  Main {
 public static void main(String[] args) {
     MonitorInvernadero monitorInvernadero = new MonitorInvernadero();
     SensorTemperatura sensorTemperatura = new SensorTemperatura(monitorInvernadero);
     ControladorAmbiental controladorAmbiental = new ControladorAmbiental(monitorInvernadero);

     sensorTemperatura.start();
     controladorAmbiental.start();
  }
}
