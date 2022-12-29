package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.condition.InputParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class NamingAssignmentTest {

    @Test
    public void splitInput(){
        InputParser inputParser = new InputParser();
        String testString = "Car1,Car2,car3";
        Set<String> splittedNames = inputParser.splitNames(testString);
        Assertions.assertThat(splittedNames).isEqualTo(new HashSet<String>(Arrays.asList("Car1", "Car2", "car3")));
    }

    @Test
    public void duplicatedNames(){
        InputParser inputParser = new InputParser();
        String testString = "Car1,Car1,Car2";
        Set<String> splittedNames = inputParser.splitNames(testString);
        Assertions.assertThat(splittedNames.size()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Car1", "Car2", "car3"})
    public void validateCarNameLengthSuccess(String testString){
        InputParser inputParser = new InputParser();

        boolean result = inputParser.checkCarNameLength(testString);
        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Car123"})
    public void validateCarNameLengthFail(String testString){
        InputParser inputParser = new InputParser();

        boolean result = inputParser.checkCarNameLength(testString);
        Assertions.assertThat(result).isFalse();
    }

}
