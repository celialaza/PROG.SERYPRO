public class MonitorInvernadero {
    private int temperatura;
    private  boolean medicionDisponile;

    public MonitorInvernadero() {
        this.medicionDisponile = false;
    }

    public void escribirTemperatura(int nuevaTemperatura){
        synchronized (this){
            while (medicionDisponile==true){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.temperatura = nuevaTemperatura;
            this.medicionDisponile = true;
            notifyAll();
        }
    }

    public int leerTemperatura(){
        synchronized (this){
            while (medicionDisponile==false){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int temperaturaLeida = this.temperatura;
            this.medicionDisponile = false;
            notifyAll();
            return temperaturaLeida;
        }
    }
}
