public class Bernardo {
    private CifradoSimetrico cifrador;

    public Bernardo(CifradoSimetrico cifrador) {
        this.cifrador = cifrador;
    }

    public void recibirMensaje(String mensaje) {
        System.out.println("Bernardo recibe el mensaje cifrado: " + mensaje);
        String descifrado = cifrador.descifrar(mensaje);
        System.out.println("Bernardo descifra y obtiene: " + descifrado);
    }
}
