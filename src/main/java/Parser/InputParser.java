package Parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.Lotto;
import lotto.LottoHost;

public class InputParser {

    public static boolean validateInputPrice(String input) {
        return Pattern.matches("\\d+", input) && isInputDividedByLottoPrice(input);
    }

    public static boolean validateInputWinningNumbers(String input) {
        return checkWinningNumbersFormat(input) && validateDuplicateNumbers(input);
    }

    private static boolean checkWinningNumbersFormat(String input) {
        return Pattern.matches("[\\d,]+\\d", input);
    }

    private static boolean validateDuplicateNumbers(String input) {
        List<Integer> winningNumbers = parseWinningNumbers(input);
        for (Integer number : winningNumbers) {
            if (winningNumbers.indexOf(number) != winningNumbers.lastIndexOf(number)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateInputBonusNumbers(Lotto lotto, String input) {
        return Pattern.matches("\\d", input) && !checkDuplicateNumber(lotto, input);
    }

    private static boolean checkDuplicateNumber(Lotto lotto, String input) {
        return lotto.getNumbers().contains(Integer.parseInt(input));
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }

    private static boolean isInputDividedByLottoPrice(String input) {
        int price = Integer.parseInt(input);
        return (price % LottoHost.LOTTO_PRICE) == 0;
    }

}
