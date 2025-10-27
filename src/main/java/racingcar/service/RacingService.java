package racingcar.service;

import racingcar.model.domain.Car;
import racingcar.model.domain.RacingGame;
import racingcar.model.rule.MoveStrategy;

import java.util.List;

public class RacingService {

    private final RacingGame racingGame;
    private final MoveStrategy moveStrategy;

    public RacingService(String carNames, MoveStrategy moveStrategy) {
        this.racingGame = RacingGame.of(carNames);
        this.moveStrategy = moveStrategy;
    }

    public void runRound() {
            racingGame.playRound(moveStrategy);
    }

    public List<String> getWinners() {
        return racingGame.getWinners();
    }

    public List<Car> getCars() {
        return racingGame.getCars();
    }

    private void validateRoundCount(int count) {
        if(count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
