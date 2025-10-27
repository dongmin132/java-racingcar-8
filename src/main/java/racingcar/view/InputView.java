package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validatior.InputValidator;

public class InputView {

    public static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        new InputValidator().validate(input);
        return input;
    }

    public static int readCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int count = Integer.parseInt(input);
        new InputValidator().validateRoundCount(count);
        return count;
    }
}
