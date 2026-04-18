package chain.transaction;

import java.security.*;
import java.util.Base64;

public class TransactionSigner {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public TransactionSigner() {
        generateKeyPair();
    }

    private void generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            keyGen.initialize(256, new SecureRandom());
            KeyPair keyPair = keyGen.generateKeyPair();
            this.privateKey = keyPair.getPrivate();
            this.publicKey = keyPair.getPublic();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String signTransaction(String transactionData) {
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign(privateKey);
            signature.update(transactionData.getBytes());
            byte[] signedBytes = signature.sign();
            return Base64.getEncoder().encodeToString(signedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifyTransaction(String transactionData, String signature) {
        try {
            Signature sig = Signature.getInstance("SHA256withECDSA");
            sig.initVerify(publicKey);
            sig.update(transactionData.getBytes());
            byte[] signatureBytes = Base64.getDecoder().decode(signature);
            return sig.verify(signatureBytes);
        } catch (Exception e) {
            return false;
        }
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
