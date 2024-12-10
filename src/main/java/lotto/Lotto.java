package lotto;

import java.util.List;

public class Lotto {

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ErrorMessage.LOTTO_HAS_SIX_NUMBERS.getMessage());
        }
        if (!checkDuplicateNumber(numbers)) {
            System.out.println(ErrorMessage.LOTTO_HAS_DUPLICATE_NUMBER.getMessage());
        }
        if (!checkValidNumberRange(numbers)) {
            System.out.println(ErrorMessage.LOTTO_HAS_NON_VALID_NUMBER.getMessage());
        }
    }

    private boolean checkDuplicateNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkValidNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
