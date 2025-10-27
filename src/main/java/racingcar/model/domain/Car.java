package racingcar.model.domain;

import racingcar.model.rule.MoveStrategy;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(MoveStrategy strategy) {
        if (strategy.isMovable()) {
            position++;
        }
    }

    public String getName() {
        return name;

    }
    public int getPosition() {
        return position;
    }
}
