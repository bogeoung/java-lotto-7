package lotto;

public enum ErrorMessage {

    INPUT_NOT_DIVIDED_BY_LOTTO_PRICE("구입금액은 1,000원으로 나누어 떨어져야 합니다."),
    LOTTO_HAS_SIX_NUMBERS("로또 번호는 6개여야 합니다."),
    LOTTO_HAS_DUPLICATE_NUMBER("로또 번호에 중복된 숫자가 존재합니다."),
    LOTTO_HAS_NON_VALID_NUMBER("로또 번호는 1~45 사이의 숫자만 가능합니다."),
    WINNING_NUMBERS_FORMAT_IS_WRONG("로또 당첨번호는 쉼표(,)로 구분되는 중복되지 않은 6개의 숫자가 입력되야 합니다."),
    BONUS_NUMBER_FORMAT_IS_WRONG("보너스 번호는 당첨번호와 중복되지 않는 숫자여야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String content;

    ErrorMessage(String content) {
        this.content = content;
    }

    public String getMessage() {
        return ERROR_PREFIX + content;
    }
}
