package racing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.CarNameInvalidException;

import static org.assertj.core.api.Assertions.*;

public class RacingValidatorTest {
    private RacingValidator racingValidator;

    @BeforeEach
    void setUp(){
        racingValidator = new RacingValidator();
    }
    @ParameterizedTest
    @ValueSource(strings = {"hello", "ccc"})
    public void givenNormalCarName_whenCarNameValidate_thenOk(String input) {
        assertThatNoException().isThrownBy(() -> racingValidator.carNameValidate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    public void givenNullOrEmptyCarName_whenCarNameValidate_thenThrowException(String input){
        assertThatThrownBy(() -> racingValidator.carNameValidate(input))
                .isInstanceOf(CarNameInvalidException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "verylongcarname",
            "sixsix",
    })
    public void givenLongCarName_whenCarNameValidate_thenThrowException(String input){
        assertThatThrownBy(() -> racingValidator.carNameValidate(input))
                .isInstanceOf(CarNameInvalidException.class);
    }
}
