package racing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.car.Name;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @ParameterizedTest
    @DisplayName("5글자 이하의 이름만 사용 가능하다.")
    @ValueSource(strings = {"java", "clang", "swift", "ruby", "mysql"})
    public void validName(String input) {
        assertThatCode(() -> new Name(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("5글자가 넘는 이름은 사용할 수 없다.")
    @ValueSource(strings = {"python", "kotlin", "spring", "mongodb"})
    public void invalidName(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(RuntimeException.class);
    }
}
