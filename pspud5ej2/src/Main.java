import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        FakeKeyPair clavesAna = new FakeKeyPair();
        String pubAna = clavesAna.getPublicKey();
        String privAna = clavesAna.getPrivateKey();

        System.out.println("Clave pública de Ana: " + pubAna);

        String mensaje = "Paga 100 euros a Bernardo";
        FirmaDigital sistema = new FirmaDigital();
        String firma = sistema.firmar(mensaje, privAna);

        System.out.println("Mensaje: " + mensaje);
        System.out.println("Firma: " + firma);

        boolean esValida = sistema.verificar(mensaje, firma, pubAna);
        System.out.println("\n¿Es válida la firma original? " + esValida);

        String mensajeAlterado = "Paga 1000 euros a Bernardo";
        boolean esValidaPostAtaque = sistema.verificar(mensajeAlterado, firma, pubAna);
        System.out.println("Mensaje alterado: " + mensajeAlterado);
        System.out.println("¿Es válida tras el cambio? " + esValidaPostAtaque);
    }
}