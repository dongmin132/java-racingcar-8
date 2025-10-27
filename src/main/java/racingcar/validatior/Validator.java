package racingcar.validatior;

@FunctionalInterface
public interface Validator<T> {
    void validate(T target);
}
