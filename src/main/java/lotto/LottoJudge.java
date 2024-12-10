package lotto;

import Parser.InputParser;
import view.InputView;
import view.OutputView;

public class LottoJudge {

    private Lotto winningLotto;
    private int bonusNumber;
    private InputView inputView;
    private OutputView outputView;

    public LottoJudge(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.winningLotto = getWinningNumbers();
        this.bonusNumber = getBonusNumbers(winningLotto);
    }

    private Lotto getWinningNumbers() {
        String winningNumbers;
        do {
            winningNumbers = inputView.getWinningNumbers();
            if (!InputParser.validateInputWinningNumbers(winningNumbers)) {
                outputView.winningNumberNotValid();
            }
        } while (!InputParser.validateInputWinningNumbers(winningNumbers));
        return new Lotto(InputParser.parseWinningNumbers(winningNumbers));
    }

    private int getBonusNumbers(Lotto winningLotto) {
        String bonusNumber;
        while (true) {
            bonusNumber = inputView.getBonusNumbers();
            if (!InputParser.validateInputBonusNumbers(winningLotto, bonusNumber)) {
                outputView.bonusNumberNotValid();
                continue;
            }
            if (Integer.parseInt(bonusNumber) < Lotto.MINIMUM_NUMBER
                    || Integer.parseInt(bonusNumber) > Lotto.MAXIMUM_NUMBER) {
                outputView.numberNotValidRange();
                continue;
            }
            break;
        }
        return Integer.parseInt(bonusNumber);
    }

    public void judge(Lottos lottos, int purchasePrice) {
        Result result = new Result();
        for (Lotto lotto : lottos.getLottos()) {
            result.addResult(countSameNumber(winningLotto, lotto), countBonusNumber(bonusNumber, lotto));
        }
        outputView.printResult(result, result.getRateOfReturn(purchasePrice));

    }

    private int countSameNumber(Lotto winningLotto, Lotto lotto) {
        int sameNumberCount = 0;
        for (int lottoNum : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(lottoNum)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    private int countBonusNumber(int bonusNumber, Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }
}
