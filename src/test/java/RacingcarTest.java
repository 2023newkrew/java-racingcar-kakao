import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {

    @Test
    @DisplayName("빈 문자열을 입력할 경우 0을 반환한다.")
    void returnZeroIfEmptyString() {
        RacingCarGame racingCarGame = new RacingCarGame();

        int result = racingCarGame.play("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("null 값을 입력할 경우 0을 반환한다.")
    void returnZeroIfNull() {
        RacingCarGame racingCarGame = new RacingCarGame();

        int result = racingCarGame.play(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void returnOneIfNumberCharacter() {
        RacingCarGame racingCarGame = new RacingCarGame();
        String input = "1";
        int expectedResult = Integer.parseInt(input);

        int result = racingCarGame.play(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("")
    void throwExceptionIfCharacterIsNotNumber() {
        RacingCarGame racingCarGame = new RacingCarGame();
        String input = "-";
        
        assertThatThrownBy(() -> racingCarGame.play(input))
                .isInstanceOf(RuntimeException.class);
    }

}
