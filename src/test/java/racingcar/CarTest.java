package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    private final Car car =  new Car("pobi");

    @Test
    public void 랜덤값이_4이상이면_전진() {
        car.moveWithPower(4);
        Assertions.assertThat(car.getCurrentStatus()).isEqualTo("pobi : --");
    }

    @Test
    public void 랜덤값이_3이하면_정지() {
        car.moveWithPower(3);
        Assertions.assertThat(car.getCurrentStatus()).isEqualTo("pobi : -");
    }
}
