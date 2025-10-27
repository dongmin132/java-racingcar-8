package racingcar.view;

import racingcar.model.domain.Car;
import racingcar.model.domain.Cars;

import java.util.List;

public class OutputView {

    public static void printStartMessage() {
        System.out.println("\n실행결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();   // 빈 줄 추가
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
