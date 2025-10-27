package racingcar.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.rule.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스 단위 테스트")
public class CarTest {

    @Test
    @DisplayName("전진 조건이 true면 위치가 1 증가")
    void move_whenStrategyTrue_thenPositionIncreases() {
        Car car = new Car("pobi");
        MoveStrategy alwaysMove = () -> true;

        car.move(alwaysMove);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건이 false이면 위치가 그대로 유지")
    void move_whenStrategyFalse_thenPositionStays() {
        Car car = new Car("pobi");
        MoveStrategy neverMove = () -> false;

        car.move(neverMove);

        assertThat(car.getPosition()).isZero();
    }
}
