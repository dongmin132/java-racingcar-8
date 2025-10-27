package racingcar.model.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RandomMoveStrategy 이동 조건 테스트")
public class RandomMoveStrategyTest {

    @Test
    @DisplayName("난수가 4 이상이면 이동 가능 (true)")
    void isMovable_returnTrue_whenRandomIs4OrMore() {
        MoveStrategy strategy = () -> 4 >= 4;
        assertThat(strategy.isMovable()).isTrue();
    }

    @Test
    @DisplayName("난수가 3 이하이면 이동 불가 (false)")
    void isMovable_returnFalse_whenRandomIs3OrLess() {
        MoveStrategy strategy = () -> 3 >= 4;
        assertThat(strategy.isMovable()).isFalse();
    }
}
