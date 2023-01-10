package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {
    @Test
    @DisplayName("can validate incorrect length of name")
    void can_validate_incorrect_length_of_name() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(""));
        assertThrows(IllegalArgumentException.class, () -> new CarName("123456"));
    }
}
