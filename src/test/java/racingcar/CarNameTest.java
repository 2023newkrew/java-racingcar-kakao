package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;


public class CarNameTest {

    @Test
    public void splitInput(){
        InputParser inputParser = new InputParser();
        String testString = "Car1,Car2,car3";
        List<String> splittedNames = inputParser.splitNames(testString);
        Assertions.assertThat(splittedNames).isEqualTo(Arrays.asList("Car1", "Car2", "car3"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Car1", "Car2", "car3"})
    public void validateCarNameLengthSuccess(String testString){
        InputParser inputParser = new InputParser();

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Car(testString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Car123"})
    public void validateCarNameLengthFail(String testString){
        InputParser inputParser = new InputParser();

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(testString));

    }
}
