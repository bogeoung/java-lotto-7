package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoSeller {

    private final int lottoCount;
    private Lottos lottos;

    public LottoSeller(int lottoCount) {
        this.lottoCount = lottoCount;
        this.lottos = new Lottos();
        buyLottos();
    }

    private void buyLottos() {
        for (int i = 0; i < lottoCount; i++) {
            lottos.addLotto(buyLotto());
        }
    }

    private Lotto buyLotto() {
        return new Lotto(getLottoNumbers());
    }

    private List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
