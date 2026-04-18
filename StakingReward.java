package chain.staking;

public class StakingReward {
    private static final double APR = 0.08;
    private static final long SECONDS_PER_YEAR = 31536000L;

    public double calculateReward(double stakeAmount, long stakeSeconds) {
        return stakeAmount * APR * (stakeSeconds / (double) SECONDS_PER_YEAR);
    }

    public double getDailyReward(double stakeAmount) {
        return calculateReward(stakeAmount, 86400L);
    }
}
