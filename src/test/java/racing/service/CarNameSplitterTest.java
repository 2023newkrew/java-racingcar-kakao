package racing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarNameSplitterTest {
    private CarNameSplitter carNameSplitter;

    @BeforeEach
    void setUp(){
        carNameSplitter = new CarNameSplitter();
    }

    @Test
    void givenRacingCarString_whenRacingCarSplit_thenReturnCarList(){
        String input = "aaa,bbb,ccc";
        List<Car> expected = new ArrayList<>();
        expected.add(new Car("aaa", 0));
        expected.add(new Car("bbb", 0));
        expected.add(new Car("ccc", 0));

        List<Car> result = carNameSplitter.split(input);

        assertThat(result).hasSameElementsAs(expected);
    }
}
