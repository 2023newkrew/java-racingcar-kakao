package racing_car.view;

import racing_car.model.Car;
import racing_car.model.Cars;
import racing_car.model.Racer;

public class OutputView {

    public void printGameProcess(Cars all) {
        all.getCars().forEach(car -> System.out.printf("%s : %s\n", car.getRacer().getName(), displayDistance(car)));
        System.out.println();
    }

    private String displayDistance(Car car) {
        return "-".repeat(car.getDistance());
    }

    public void printGameResult(Cars winners) {
        String[] winnerNames = winners.getCars().stream()
                .map(Car::getRacer)
                .map(Racer::getName)
                .toArray(String[]::new);
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
