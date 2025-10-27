package racingcar.model.domain;

import racingcar.model.rule.MoveStrategy;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public static RacingGame of(String names) {
        return new RacingGame(Cars.fromNames(names));
    }

    public void playRound(MoveStrategy strategy) {
        cars.moveAll(strategy);
    }

    public List<Car> getCars() {
        return cars.asList();
    }

    public List<String> getWinners() {
        return cars.winnerNames();
    }
}
