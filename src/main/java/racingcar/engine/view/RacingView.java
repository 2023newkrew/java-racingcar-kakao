package racingcar.engine.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import racingcar.Console;
import racingcar.engine.domain.Car;

public class RacingView {
    private final Console console;

    public RacingView(Console console) {
        this.console = console;
    }

    public List<Car> getCars() {
        return requestUntilSuccess(getCarsSupplier());
    }

    public int getCount() {
        return requestUntilSuccess(getCountSupplier());
    }

    public void showCurrentStatus(List<Car> cars) {
        console.printOutput("\n");
        cars.forEach((car) -> console.printOutput(car.toString()));
    }

    public void showResult(List<String> winners) {
        console.printOutput(String.join(", ", winners) + "(이)가 최종 우승했습니다.");
    }

    private Supplier<List<Car>> getCarsSupplier() {
        return () -> {
            String input = console.input("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String[] carNames = InputParser.splitByComma(input);
            List<Car> cars = new ArrayList<>();
            for (String carName : carNames) {
                cars.add(new Car(carName));
            }
            return cars;
        };
    }

    private Supplier<Integer> getCountSupplier() {
        return () -> {
            String countInput = console.input("시도할 회수는 몇회인가요?");
            return InputParser.parseStringToPositiveInt(countInput);
        };
    }

    private <T> T requestUntilSuccess(Supplier<T> getT) {
        Optional<T> result = wrapTryCatch(getT);
        while (result.isEmpty()) {
            result = wrapTryCatch(getT);
        }
        return result.get();
    }

    private <T> Optional<T> wrapTryCatch(Supplier<T> getT) {
        try {
            return Optional.of(getT.get());
        } catch (RuntimeException e) {
            console.printError(e.getMessage());
            return Optional.empty();
        }
    }
}
