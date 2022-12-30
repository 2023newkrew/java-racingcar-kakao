package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @DisplayName("생성자로 차 이름 리스트와 턴 수를 받는다.")
    @Test
    void constructRacingWithCarNamesAndTurn() {
        List<String> names = Arrays.asList("aa", "bb", "cc");
        int turn = 2;

        assertThatCode(() -> new Racing(names, turn)).doesNotThrowAnyException();
    }
}
