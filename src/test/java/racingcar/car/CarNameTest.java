package racingcar.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.CarName;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"aasd", "asssz", "zzz"})
    void validName(String name) {
        assertThat(new CarName(name)).isEqualTo(new CarName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdasdasd", "azx1@!$", "afxvcx@3", "", " ", "ass "})
    void invalidName(String name) {
        assertThat(CarName.isValidName(name)).isFalse();
    }
}
