package carracing;

import carracing.domain.Car;
import carracing.domain.CarCreator;
import carracing.domain.Cars;
import carracing.domain.StringParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;


class CarCreatorTest {
    CarCreator carCreator;

    @BeforeEach
    void init() {
        StringParser stringParser = new StringParser();
        carCreator = new CarCreator(stringParser);
    }

    @DisplayName("Car 객체 생성 후 이름 올바른지 검사")
    @Test
    void createCars_validInput() {
        //given
        String playerNames = "a,b,c";
        //when
        Cars cars = carCreator.createCars(playerNames);
        List<String> carNames = cars.getCarList().stream().map(Car::getCarName).collect(Collectors.toList());
        //then
        Assertions.assertThat(carNames).containsExactly("a", "b", "c");
    }
}