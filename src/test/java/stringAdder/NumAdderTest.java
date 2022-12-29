package stringAdder;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumAdderTest {
    @Test
    void add() {
        int[] numbers = new int[]{ 1, 2, 3 };
        int result = NumAdder.add(numbers);
        assertThat(result).isEqualTo(6);
    }
}
