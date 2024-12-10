package lotto;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {

    private Map<Rank, Integer> resultRanks = new LinkedHashMap<>();

    public Result() {
        resultRanks.put(new Rank("FIFTH", 3, 0, 5_000), 0);
        resultRanks.put(new Rank("FOURTH", 4, 0, 50_000), 0);
        resultRanks.put(new Rank("THIRD", 5, 0, 1_500_000), 0);
        resultRanks.put(new Rank("SECOND", 5, 1, 30_000_000), 0);
        resultRanks.put(new Rank("FIRST", 6, 0, 2_000_000_000), 0);
    }

    public void addResult(int sameNumberCount, int bonusNumberCount) {
        for (Rank rank : resultRanks.keySet()) {
            if (rank.getSameNumberCount() == sameNumberCount && rank.getBonusNumberCount() == bonusNumberCount) {
                resultRanks.put(rank, resultRanks.get(rank) + 1);
            }
        }
    }


    public float getRateOfReturn(int purchasePrize) {
        BigDecimal totalPrize = getPrize();
        return totalPrize.divide(new BigDecimal(String.valueOf(purchasePrize))).floatValue() * 100;
    }

    public Map<Rank, Integer> getResultRanks() {
        return resultRanks;
    }

    private BigDecimal getPrize() {
        BigDecimal prize = BigDecimal.ZERO;
        for (Rank rank : resultRanks.keySet()) {
            BigDecimal curPrize = new BigDecimal(rank.getPrize());
            BigDecimal curPrizeCount = BigDecimal.valueOf(resultRanks.get(rank));
            prize = prize.add(curPrize.multiply(curPrizeCount));
        }
        return prize;
    }
}
