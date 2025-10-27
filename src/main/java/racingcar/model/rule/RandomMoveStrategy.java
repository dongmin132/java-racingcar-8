package racingcar.model.rule;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy{

    private static final int MIN_VALUE = 4;

    @Override
    public boolean isMovable() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= MIN_VALUE;
    }
}
