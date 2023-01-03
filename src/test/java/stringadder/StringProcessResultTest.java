package stringadder;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class StringProcessResultTest {
    @Test
    void splitNumString() {
        StringProcessResult stringProcessResult = new StringProcessResult(";", "1;2,3:4");
        int[] numbers = stringProcessResult.splitNumStrToIntArr();
        assertThat(numbers).isEqualTo(new int[]{1, 2, 3, 4});
    }

    @Test
    void validateNum() {
        StringProcessResult stringProcessResult = new StringProcessResult(";", "1;2,a:4");
        assertThrows(RuntimeException.class, () -> stringProcessResult.splitNumStrToIntArr());
    }

    @Test
    void validatePositive() {
        StringProcessResult stringProcessResult = new StringProcessResult(";", "1;-1,3:4");
        assertThrows(RuntimeException.class, () -> stringProcessResult.splitNumStrToIntArr());
    }

    @Test
    void validateNumberExist() {
        StringProcessResult stringProcessResult = new StringProcessResult(";", "1;,3:4");
        assertThrows(RuntimeException.class, () -> stringProcessResult.splitNumStrToIntArr());
    }
}