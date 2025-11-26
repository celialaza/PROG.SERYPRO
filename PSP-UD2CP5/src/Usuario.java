public class Usuario {

    private String nombre;
    private int pisoOrigen;
    private int pisoDestino;

    public Usuario(String nombre, int pisoOrigen, int pisoDestino) {
        this.nombre = nombre;
        this.pisoOrigen = pisoOrigen;
        this.pisoDestino = pisoDestino;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPisoOrigen() {
        return pisoOrigen;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }
}