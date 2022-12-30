package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {
    @DisplayName("Return input name string test")
    @Test
    void nameStringInputTest() throws IOException {
        System.setIn(new ByteArrayInputStream("test1,test2,test3\n".getBytes()));

        assertEquals(Input.nameStringInput(), "test1,test2,test3");
    }
}
