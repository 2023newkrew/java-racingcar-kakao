package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringVerifierTest {

    @DisplayName("isInteger 검증 작동 확인")
    @Test
    void isIntegerTest() {
        String[] s0 = new String[]{"1", "-1" ,"99999999"};
        for(String s: s0) {
            Assertions.assertThat(StringVerifier.isInteger(s)).isTrue();
        }

        String[] s1 = new String[]{"", "aa" ,"-"};
        for(String s: s1) {
            Assertions.assertThat(StringVerifier.isInteger(s)).isFalse();
        }
    }

    @DisplayName("isPositive 검증 작동 확인")
    @Test
    void isPositiveTest() {
        Integer[] intArr1 = new Integer[]{0, 1, 2 ,99999999};
        for(Integer i: intArr1) {
            Assertions.assertThat(StringVerifier.isPositive(i)).isTrue();
        }

        Integer[] intArr2 = new Integer[]{-1, -99999, -2222};
        for(Integer i: intArr2) {
            Assertions.assertThat(StringVerifier.isPositive(i)).isFalse();
        }
    }

    @DisplayName("isNullOrEmpty 검증 작동 확인")
    @Test
    void isNullOrEmpty() {
        String[] s0 = new String[]{"", null};
        for(String s: s0) {
            Assertions.assertThat(StringVerifier.isNullOrEmpty(s)).isTrue();
        }

        String[] s1 = new String[]{"1", "-1" ,"99999999"};
        for(String s: s1) {
            Assertions.assertThat(StringVerifier.isNullOrEmpty(s)).isFalse();
        }
    }
}
