package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarListTest {

    @Test
    void duplicatedNameException() {
        CarList carList = new CarList();
        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    carList.add(new Car("lion"));
                    carList.add(new Car("lion"));
                });
    }
}
