import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringVerifierTest {

    @Test
    void isIntegerTest() {
        StringVerifier sv = new StringVerifier();
        String[] s0 = new String[]{"1", "-1" ,"99999999"};
        for(String s: s0) {
            Assertions.assertThat(sv.isInteger(s)).isTrue();
        }

        String[] s1 = new String[]{"", "aa" ,"-"};
        for(String s: s1) {
            Assertions.assertThat(sv.isInteger(s)).isFalse();
        }
    }

    @Test
    void isPositiveTest() {
        StringVerifier sv = new StringVerifier();
        Integer[] intArr1 = new Integer[]{0, 1, 2 ,99999999};
        for(Integer i: intArr1) {
            Assertions.assertThat(sv.isPositive(i)).isTrue();
        }

        Integer[] intArr2 = new Integer[]{-1, -99999, -2222};
        for(Integer i: intArr2) {
            Assertions.assertThat(sv.isPositive(i)).isFalse();
        }
    }

    @Test
    void isNullOrEmpty() {
        StringVerifier sv = new StringVerifier();
        String[] s0 = new String[]{"", null};
        for(String s: s0) {
            Assertions.assertThat(sv.isNullOrEmpty(s)).isTrue();
        }

        String[] s1 = new String[]{"1", "-1" ,"99999999"};
        for(String s: s1) {
            Assertions.assertThat(sv.isNullOrEmpty(s)).isFalse();
        }
    }
}
