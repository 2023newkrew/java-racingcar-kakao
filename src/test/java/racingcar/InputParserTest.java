package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    public void 입력값_파싱() {
        InputParser inputParser = new InputParser();
        String[] carNames = inputParser.splitByComma("pobi,jaws,jayde");
        Assertions.assertThat(carNames).containsExactly("pobi", "jaws", "jayde");
    }
}
