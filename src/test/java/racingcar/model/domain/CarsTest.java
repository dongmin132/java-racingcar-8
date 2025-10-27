package racingcar.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

@DisplayName("Cars 클래스 단위 테스트")
public class CarsTest {

    @Test
    @DisplayName("모든 자동차를 한칸씩 이동 시킨다.")
    void moveAll_MoveAllCarsOnce() {
        Cars cars = Cars.fromNames("pobi,woni");
        cars.moveAll(() -> true);

        assertThat(cars.asList())
                .extracting(Car::getPosition)
                .containsExactly(1,1);
    }

    @Test
    @DisplayName("동점일 경우 모든 자동차가 우승자에 포함된다.")
    void winnerNames_returnMultipleWinners() {
        Cars cars = Cars.fromNames("pobi,woni");
        cars.moveAll(() -> true);

        assertThat(cars.winnerNames()).containsExactlyInAnyOrder("pobi", "woni");
    }
}
