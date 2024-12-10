package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message;

public class InputView {

    public String getPurchasePriceInput() {
        System.out.println(Message.GET_LOTTO_PRICE.getMessage());
        return readLine();
    }

    public String getWinningNumbers() {
        System.out.println(Message.GET_WINNING_NUMBERS.getMessage());
        return readLine();
    }

    public String getBonusNumbers() {
        System.out.println(Message.GET_BONUS_NUMBERS.getMessage());
        return readLine();
    }

    private String readLine() {
        return Console.readLine();
    }
}
