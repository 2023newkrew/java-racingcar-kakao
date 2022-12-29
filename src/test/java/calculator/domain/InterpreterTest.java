package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InterpreterTest {

    private Interpreter interpreter;

    @BeforeEach
    void setUp() {
        interpreter = new Interpreter();
    }

    @Test
    void 비어있는_문자열을_넘기면_기본값의_Command를_반환한다() {
        Command command = interpreter.decode("");
        assertThat(command.getInputStringNumbers()).isEqualTo("0");
    }

    @Test
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다() {
        Command command = interpreter.decode("1");
        assertThat(command.getInputStringNumbers()).isEqualTo(("1"));
    }

    @Test
    void 커스텀_구분자를_파싱할_수_있다() {
        Command command = interpreter.decode("//;\n1;2;3");
        assertThat(command.getDelimiters().size()).isEqualTo(3);
    }

}