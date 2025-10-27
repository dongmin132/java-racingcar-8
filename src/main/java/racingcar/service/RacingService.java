package racingcar.service;

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

    public void runRound(int roundCount) {
        validateRoundCount(roundCount);
        for (int i = 0; i < roundCount; i++) {
            racingGame.playRound(moveStrategy);
        }
    }

    public List<String> getWinners() {
        return racingGame.getWinners();
    }

    private void validateRoundCount(int count) {
        if(count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
