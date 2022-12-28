package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.AppConfig;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameImpl implements RacingCarGame {
    private final RandomNumberGenerator randomNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;
    private final ArrayList<Car> cars = new ArrayList<>();

    public RacingCarGameImpl(AppConfig appConfig) {
        randomNumberGenerator = appConfig.getRandomNumberGenerator();
        inputView = appConfig.getInputView();
        outputView = appConfig.getOutputView();
    }

    @Override
    public void run(int times) {
        outputView.printRunResult();
        for (int i = 0; i < times; i++) {
            cars.forEach(car -> car.move(randomNumberGenerator.generator()));
            outputView.printEachRunResult(getCarResults());
        }
    }

    @Override
    public void add(String carName) {
        cars.add(new RacingCar(carName));
    }

    @Override
    public void add(Car... multipleCar) {
        cars.addAll(List.of(multipleCar));
    }

    @Override
    public List<Car> getWinner() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter(car -> maxDistance == car.getDistance())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getWinnerNames() {
        return getWinner().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCarResults() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    @Override
    public void play() {
        outputView.printStartMessage();
        String[] names = inputView.inputName();
        Arrays.stream(names)
                .forEach(this::add);
        outputView.printAskRunCount();
        int times = inputView.inputRunCount();
        run(times);
        outputView.printFinalResult(getWinnerNames());
    }

    private int getMaxDistance() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .orElseThrow()
                .getDistance();
    }
}
