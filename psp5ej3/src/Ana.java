public class Ana {
    private CifradoSimetrico cifrador;

    public Ana(CifradoSimetrico cifrador) {
        this.cifrador = cifrador;
    }

    public String enviarMensaje(String mensaje) {
        System.out.println("Ana quiere enviar (en claro): " + mensaje);
        String cifrado = cifrador.cifrar(mensaje);
        System.out.println("Ana cifra el mensaje y obtiene: " + cifrado);
        return cifrado;
    }
}
