package racingcar;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCarController {
    private RacingCarModel model;
    private final RacingCarView view;

    public static RacingCarController create() {
        return new RacingCarController();
    }

    private RacingCarController() {
        view = RacingCarView.create();
    }

    public void start() {
        createModel();
        simulate();
        printWinner();
    }

    private void createModel() {
        while (Objects.isNull(model)) {
            tryCreateModel();
        }
    }

    private void tryCreateModel() {
        try {
            createModelByInput();
        } catch (RuntimeException ex) {
            view.printError(ex.getMessage());
        }
    }

    private void createModelByInput() {
        List<String> names = inputNames();
        List<Car> cars = createCarsFromNames(names);
        model = RacingCarModel.from(cars);
    }

    private List<String> inputNames() {
        String nameLine = view.inputNameLine();
        return RacingCarModel.parseNames(nameLine);
    }

    private static List<Car> createCarsFromNames(List<String> names) {
        return names.stream()
                .map(RacingCarController::createCar)
                .collect(Collectors.toList());
    }

    private static Car createCar(String name) {
        return Car.from(name, Engine.defaultEngine);
    }

    private void simulate() {
        int count = inputCount();
        view.printResultText();
        for (int i = 0; i < count; ++i) {
            model.progress();
            view.printProgressResult(model.getCarInfos());
        }
    }

    //Todo:범위를 벗어날 경우 다시 입력
    private int inputCount() {
        return view.inputCount();
    }

    private void printWinner() {
        view.printWinners(model.getWinners());
    }
}
