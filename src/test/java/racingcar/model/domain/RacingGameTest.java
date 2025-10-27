package racingcar.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 클래스 단위 테스트")
public class RacingGameTest {

    @Test
    @DisplayName("모든 자동차가 각 라운드마다 이동한다")
    void playRound_moveAllCarsEachRound() {
        RacingGame game = RacingGame.of("pobi,woni");

        game.playRound(() -> true);     // 1라운드
        game.playRound(() -> true);     // 2라운드

        assertThat(game.getCars())
                .extracting(Car::getPosition)
                .containsExactly(2,2);
    }

    @Test
    @DisplayName("게임 종료 후 우승자 이름 목록 반환")
    void getWinners_returnWinnersList() {
        RacingGame game = RacingGame.of("pobi,woni");
        game.playRound(() -> true);     // 1라운드
        game.playRound(() -> false);     // 2라운드

        assertThat(game.getWinners())
                .containsExactlyInAnyOrder("pobi","woni");
    }
}
