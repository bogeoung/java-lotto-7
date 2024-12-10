package lotto;

import Parser.InputParser;
import view.InputView;
import view.OutputView;

public class LottoHost {

    private InputView inputView;
    private OutputView outputView;
    private Lotto lotto;
    public static final int LOTTO_PRICE = 1000;

    public LottoHost(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final int purchasePrice = getPurchasePrice();
        Lottos lottos = purchaseLottos(purchasePrice);
        judgeLottos(lottos, purchasePrice);
    }

    private int getPurchasePrice() {
        String purchasePrice;
        do {
            purchasePrice = inputView.getPurchasePriceInput();
            if (!InputParser.validateInputPrice(purchasePrice)) {
                outputView.inputNotDividedByLottoPrice();
            }
        } while (!InputParser.validateInputPrice(purchasePrice));
        return Integer.parseInt(purchasePrice);
    }

    private Lottos purchaseLottos(Integer purchasePrice) {
        LottoSeller lottoSeller = new LottoSeller(purchasePrice / LOTTO_PRICE);
        outputView.printLottos(lottoSeller.getLottos());
        return lottoSeller.getLottos();
    }

    private void judgeLottos(Lottos lottos, int purchasePrice) {
        LottoJudge lottoJudge = new LottoJudge(inputView, outputView);
        lottoJudge.judge(lottos, purchasePrice);
    }


}
