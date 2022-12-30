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
    @DisplayName("Print notice for name string input")
    @Test
    void printNoticeNameStringTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Output.printNoticeNameString();

        String actual = out.toString();
        assertEquals(actual, "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
    }

    @DisplayName("Print notice for turn input")
    @Test
    void printNoticeTurnTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Output.printNoticeTurn();

        String actual = out.toString();
        assertEquals(actual, "시도할 회수는 몇회인가요?\n");
    }

    @DisplayName("Print notice for race result")
    @Test
    void printNoticeResultTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Output.printNoticeResult();

        String actual = out.toString();
        assertEquals(actual, "실행결과\n");
    }

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
    void printRaceStatusTest() {
        Race race = new Race("test1,test2,test3");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Output.printRaceStatus(race);

        String actual = out.toString();
        assertEquals(actual, "test1 : -\n" +
                "test2 : -\n" +
                "test3 : -\n");
    }

    @DisplayName("Print winner of race")
    @Test
    void printRaceWinnerTest() {
        Race race = new Race("test1,test2,test3");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Output.printRaceWinner(race);

        String actual = out.toString();
        assertEquals(actual, "test1, test2, test3가 최종 우승했습니다.\n");
    }
}
