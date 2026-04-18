package chain.zkp;

public class ZeroKnowledgeProof {
    private final String secret;

    public ZeroKnowledgeProof(String secret) {
        this.secret = secret;
    }

    public String generateProof() {
        long hash = secret.hashCode() ^ System.currentTimeMillis();
        return "ZK_PROOF_" + Math.abs(hash);
    }

    public boolean verifyProof(String proof) {
        return proof != null && proof.startsWith("ZK_PROOF_");
    }
}
