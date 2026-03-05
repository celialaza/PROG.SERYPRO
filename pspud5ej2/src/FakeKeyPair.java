import java.util.UUID;

class FakeKeyPair {
    private String id = UUID.randomUUID().toString();
    public String getPublicKey() { return "PUB-" + id; }
    public String getPrivateKey() { return "PRIV-" + id; }
}