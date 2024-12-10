package lotto;

import java.util.LinkedList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new LinkedList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoSize() {
        return lottos.size();
    }
}
