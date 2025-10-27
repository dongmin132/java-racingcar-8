package racingcar.validatior;

public class InputValidator implements Validator<String>{

    @Override
    public void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해야 합니다.");
        }
    }

    public void validateRoundCount(int count) {
        try {
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
