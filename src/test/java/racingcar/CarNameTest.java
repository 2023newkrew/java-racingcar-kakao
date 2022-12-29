package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;


public class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"Car1", "Car2", "car3"})
    public void validateCarNameLengthSuccess(String testString){
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Car(testString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Car123"})
    public void validateCarNameLengthFail(String testString){
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(testString));

    }
}
