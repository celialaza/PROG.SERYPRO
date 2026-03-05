public class FirmaDigital {
    private HashUtil util = new HashUtil();

    public String firmar(String mensaje, String clavePrivada) {
        return util.hash(mensaje + clavePrivada);
    }

    public boolean verificar(String mensaje, String firma, String clavePublica) {
        String firmaEsperada = util.hash(mensaje + clavePublica.replace("PUB-", "PRIV-"));
        return firmaEsperada.equals(firma);
    }
}