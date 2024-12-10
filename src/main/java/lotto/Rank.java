package lotto;

public class Rank {

    private String rankName;
    private int sameNumberCount;
    private int bonusNumberCount;
    private int prize;

    public Rank(String rankName, int sameNumberCount, int bonusNumberCount, int prize) {
        this.rankName = rankName;
        this.sameNumberCount = sameNumberCount;
        this.bonusNumberCount = bonusNumberCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public String getRankName() {
        return rankName;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getBonusNumberCount() {
        return bonusNumberCount;
    }
}
