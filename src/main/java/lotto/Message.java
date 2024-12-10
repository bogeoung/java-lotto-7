package lotto;

public enum Message {
    GET_LOTTO_PRICE("구입금액을 입력해 주세요."),
    GET_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBERS("보너스 번호를 입력해 주세요");

    private final String content;

    Message(String content) {
        this.content = content;
    }

    public String getMessage() {
        return content;
    }

}
