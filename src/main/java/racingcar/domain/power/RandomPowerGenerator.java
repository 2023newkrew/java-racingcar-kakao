package racingcar.domain.power;

import java.util.Random;

public class RandomPowerGenerator implements PowerGeneratable{
    public int generate() {
        return new Random().nextInt(10);
    }
}
