package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StrCalTest {
    @Test
    void emptyString() {
        StrCal emptyStr = new StrCal("");
        assertThat(emptyStr.calculate()).isEqualTo(0);
    }

    @Test
    void nullString() {
        StrCal nullStr = new StrCal(null);
        assertThat(nullStr.calculate()).isEqualTo(0);
    }

    @Test
    void basicString() {
        StrCal basic = new StrCal("1,2:3");
        assertThat(basic.calculate()).isEqualTo(6);
    }

    @Test
    void numberString() {
        StrCal number = new StrCal("123123");
        assertThat(number.calculate()).isEqualTo(123123);
    }

    @Test
    void invalidString() {
        StrCal invalid = new StrCal("1[2,3:4");
        assertThatThrownBy(invalid::calculate).isInstanceOf(RuntimeException.class);
    }

    @Test
    void invalidCustomString() {
        StrCal invalid = new StrCal("//$", "1@2,3:4");
        assertThatThrownBy(invalid::calculate).isInstanceOf(RuntimeException.class);
    }

    @Test
    void customString() {
        StrCal custom = new StrCal("//[!$#&", "1,2:3[4");
        assertThat(custom.calculate()).isEqualTo(10);
    }
}
