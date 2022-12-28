package racing.service;

import org.junit.jupiter.api.Test;
import racing.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingSplitterTest {
    private final RacingSplitter racingSplitter;

    RacingSplitterTest(){
        racingSplitter = new RacingSplitter();
    }

    @Test
    void givenRacingCarString_whenRacingCarSplit_thenReturnCarList(){
        String input = "aaa,bbb,ccc";
        List<Car> expected = new ArrayList<>();
        expected.add(new Car("aaa", 0));
        expected.add(new Car("bbb", 0));
        expected.add(new Car("ccc", 0));

        List<Car> result = racingSplitter.split(input);

        assertThat(result).hasSameElementsAs(expected);
    }
}
