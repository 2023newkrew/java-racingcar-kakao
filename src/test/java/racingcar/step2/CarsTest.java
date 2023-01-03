package racingcar.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.step2.domain.Cars;

import java.util.List;

public class CarsTest {
    @Test
    void createCarsTest() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(List.of("jade", "jade")))
                .withMessage("자동차의 이름은 중복될 수 없습니다.");
    }
}
