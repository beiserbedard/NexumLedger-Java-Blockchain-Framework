package chain.governance;

import java.util.HashMap;
import java.util.Map;

public class GovernanceVote {
    private final String proposalId;
    private final Map<String, Integer> votes;
    private int totalVotes;

    public GovernanceVote(String proposalId) {
        this.proposalId = proposalId;
        this.votes = new HashMap<>();
        this.totalVotes = 0;
    }

    public void castVote(String voter, boolean approve) {
        votes.put(voter, approve ? 1 : 0);
        totalVotes++;
    }

    public double getApprovalRate() {
        if (totalVotes == 0) return 0.0;
        long approve = votes.values().stream().filter(v -> v == 1).count();
        return (double) approve / totalVotes * 100;
    }

    public boolean isPassed(double threshold) {
        return getApprovalRate() >= threshold;
    }

    public String getProposalId() {
        return proposalId;
    }
}
