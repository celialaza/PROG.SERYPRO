public class BancoDePruebas {
    public static void main(String[] args) {
        Pista pista = new Pista(2);
        Vehiculo v1 = new Vehiculo("vehículo1", pista);
        Vehiculo v2 = new Vehiculo("vehículo2", pista);
        Vehiculo v3 = new Vehiculo("vehículo3", pista);
        Vehiculo v4 = new Vehiculo("vehículo4", pista);

        v1.start();
        v2.start();
        v3.start();
        v4.start();
    }
}