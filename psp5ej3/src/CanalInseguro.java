public class CanalInseguro {
    private Atacante atacante;

    public CanalInseguro(Atacante atacante) {
        this.atacante = atacante;
    }

    public String enviar(String mensaje) {
        atacante.interceptar(mensaje);
        return mensaje;
    }
}
