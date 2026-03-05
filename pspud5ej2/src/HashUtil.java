import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public String hash(String mensaje) {
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = md.digest(mensaje.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: Algoritmo no encontrado", e);
        }
    }
}