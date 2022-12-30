package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.AppConfig;
import racingcar.factory.CarFactory;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameImpl implements RacingCarGame {
    private final RandomNumberGenerator randomNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;

    public RacingCarGameImpl(AppConfig appConfig, String[] carNames) {
        randomNumberGenerator = appConfig.getRandomNumberGenerator();
        inputView = appConfig.getInputView();
        outputView = appConfig.getOutputView();
        this.cars = createCars(carNames);
    }

    @Override
    public Cars getCars() {
        return cars;
    }

    @Override
    public Cars createCars(String[] carNames) {
        return new Cars(Arrays.stream(carNames)
                .map(CarFactory::createCar)
                .collect(Collectors.toList()));
    }

    @Override
    public void run(int times) {

    }

    @Override
    public void add(String carName) {

    }

    @Override
    public void add(List<Car> multipleCar) {
        cars = new Cars(multipleCar);
    }

    @Override
    public void play() {

    }

}
