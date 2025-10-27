package racingcar.validatior;

public class CarValidator implements Validator<String> {
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
