package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Race;

public class Output {

    public static void printCarStatus(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(car.getName() + " : ");
        sb.append("-".repeat(car.getPosition()));

        System.out.println(sb);
    }

    public static void printRaceStatus(Race race) {
        for (Car car : race.getCars()) {
            Output.printCarStatus(car);
        }
    }
}
