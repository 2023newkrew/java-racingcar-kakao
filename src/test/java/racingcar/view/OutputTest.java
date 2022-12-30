package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputTest {
    @DisplayName("Print present car status")
    @Test
    void printCarStatusTest() {
        Car car = new Car("test");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Output.printCarStatus(car);

        String actual = out.toString();
        assertEquals(actual, "test : -\n");
    }

    @DisplayName("Print present race status")
    @Test
    void printRaceStatus() {
        Race race = new Race("test1,test2,test3");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Output.printRaceStatus(race);

        String actual = out.toString();
        assertEquals(actual, "test1 : -\n" +
                "test2 : -\n" +
                "test3 : -\n");
    }
}
