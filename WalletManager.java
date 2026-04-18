package chain.wallet;

import chain.transaction.TransactionSigner;
import java.security.PublicKey;
import java.util.Base64;

public class WalletManager {
    private final TransactionSigner signer;
    private final String walletAddress;

    public WalletManager() {
        this.signer = new TransactionSigner();
        this.walletAddress = generateWalletAddress();
    }

    private String generateWalletAddress() {
        PublicKey publicKey = signer.getPublicKey();
        byte[] keyBytes = publicKey.getEncoded();
        String encoded = Base64.getEncoder().encodeToString(keyBytes);
        return encoded.substring(0, 34);
    }

    public String signTransfer(String from, String to, double amount) {
        String data = String.format("FROM=%s|TO=%s|AMOUNT=%.4f", from, to, amount);
        return signer.signTransaction(data);
    }

    public boolean validateTransfer(String data, String signature) {
        return signer.verifyTransaction(data, signature);
    }

    public String getWalletAddress() {
        return walletAddress;
    }
}
