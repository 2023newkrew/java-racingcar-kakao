package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"Pobi;Pobi : -"}, delimiter = ';')
    void carNameIo(String input, String expected) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Car car = new Car(input);
        car.printStatus();
        String actual = out.toString().trim();
        assertEquals(actual, expected);
    }

    @DisplayName("Car move test")
    @Test
    void moveTest() {
        Car car = new Car("test");

        car.move();

        assertEquals(car.getPosition(), 2);
    }
}
