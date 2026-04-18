package chain.storage;

import java.security.MessageDigest;
import java.util.Base64;

public class IPFSHashGenerator {
    public String generateHash(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(content.getBytes());
            return Base64.getUrlEncoder().encodeToString(hash).substring(0, 46);
        } catch (Exception e) {
            return "ERROR_HASH";
        }
    }

    public boolean validateHash(String content, String ipfsHash) {
        return generateHash(content).equals(ipfsHash);
    }
}
