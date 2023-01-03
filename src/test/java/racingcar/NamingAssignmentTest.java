package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;
import racingcar.view.condition.InputParser;
import racingcar.view.exceptions.DuplicatedNameException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class NamingAssignmentTest {

    @Test
    public void splitInputTest(){
        String testString = "Car1,Car2,car3";
        InputParser inputParser = new InputParser();
        List<String> splittedNames = inputParser.splitNames(testString);
        Assertions.assertThat(splittedNames).isEqualTo(Arrays.asList("Car1", "Car2", "car3"));
    }

    @Test
    public void duplicatedNamesTest(){
        assertThrows(DuplicatedNameException.class, (() -> {
            InputView inputView = new InputView();
            String testString = "Car1,Car1,Car2";
            inputView.registerCarsName(testString);
        }));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Car1", "Car2", "car3"})
    public void validateInputParserLengthSuccessTest(String testString){
        InputParser inputParser = new InputParser();

        boolean result = inputParser.carNameLimitLength(testString);
        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Car123"})
    public void validateInputParserLengthFailTest(String testString){
        InputParser inputParser = new InputParser();

        boolean result = inputParser.carNameLimitLength(testString);
        Assertions.assertThat(result).isFalse();
    }
}
