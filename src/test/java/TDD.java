import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TDD {
    private Calculator calculator = new Calculator();
    @Test
    public void testEmptyString() {
        int result = calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }
}
