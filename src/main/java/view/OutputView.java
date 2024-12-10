package view;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.ErrorMessage;
import lotto.Lotto;
import lotto.Lottos;
import lotto.Rank;
import lotto.Result;

public class OutputView {

    public void inputNotDividedByLottoPrice() {
        System.out.println(ErrorMessage.INPUT_NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
    }

    public void printLottos(Lottos lottos) {
        int lottoCount = lottos.getLottoSize(); // 왜 여기서 size()로 접근 안되는지?
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void winningNumberNotValid() {
        System.out.println(ErrorMessage.WINNING_NUMBERS_FORMAT_IS_WRONG.getMessage());
    }

    public void bonusNumberNotValid() {
        System.out.println(ErrorMessage.BONUS_NUMBER_FORMAT_IS_WRONG.getMessage());
    }

    public void numberNotValidRange() {
        System.out.println(ErrorMessage.LOTTO_HAS_NON_VALID_NUMBER.getMessage());
    }

    public void printResult(Result result, float rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printRankResult(result);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    private void printRankResult(Result result) {
        DecimalFormat prizeFormat = new DecimalFormat("###,###");
        Map<Rank, Integer> resultRanks = result.getResultRanks();
        for (Rank rank : resultRanks.keySet()) {
            if (rank.getRankName() != "SECOND") {
                System.out.println(rank.getSameNumberCount() + "개 일치 (" + prizeFormat.format(rank.getPrize()) + "원) - "
                        + resultRanks.get(rank) + "개");
            }
            if (rank.getRankName() == "SECOND") {
                System.out.println(
                        rank.getSameNumberCount() + "개 일치, 보너스 볼 일치 (" + prizeFormat.format(rank.getPrize()) +
                                "원) - "
                                + resultRanks.get(rank) + "개");
            }
        }
    }
}
