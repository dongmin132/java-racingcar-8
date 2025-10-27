package racingcar.model.domain;

import racingcar.model.rule.MoveStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromNames(String input) {
        List<Car> list = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .map(Car::new)
                .toList();

        return new Cars(list);
    }

    public void moveAll(MoveStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public int maxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> winnerNames() {
        int max = maxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> asList() {
        return Collections.unmodifiableList(cars);
    }
}
