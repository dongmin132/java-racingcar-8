package racingcar.controller;

import racingcar.model.rule.RandomMoveStrategy;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void run() {
        String carNames = InputView.readCarNames();
        int roundCount = InputView.readCount();

        RacingService racingservice = new RacingService(carNames, new RandomMoveStrategy());

        OutputView.printStartMessage();
        for (int i = 0; i < roundCount; i++) {
            racingservice.runRound(i);
            OutputView.printRoundResult(racingservice.getCars());
        }

        OutputView.printWinners(racingservice.getWinners());
    }
}
