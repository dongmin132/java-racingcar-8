package racingcar.model.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.rule.MoveStrategy;
import racingcar.service.RacingService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RacingService 단위 테스트")
public class RacingServiceTest {

    @Test
    @DisplayName("주어진 횟수만큼 자동차가 움직여야 한다")
    void runRound_moveCarsForGivenRound() {
        MoveStrategy moveStrategy = () -> true;
        RacingService racingService = new RacingService("pobi,woni", moveStrategy);

        racingService.runRound(3);

        assertThat(racingService.getWinners()).
                containsExactlyInAnyOrder("pobi","woni");
    }

    @Test
    @DisplayName("시도 횟수가 0 이하인 경우 예외 발생")
    void runRound_thrownException_whenInvalidRoundCount() {
        MoveStrategy moveStrategy = () -> true;
        RacingService racingService = new RacingService("pobi,woni", moveStrategy);

        assertThatThrownBy(() -> racingService.runRound(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }



}
