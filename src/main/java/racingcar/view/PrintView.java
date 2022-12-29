package racingcar.view;

import racingcar.domain.Car;

public interface PrintView {
    void printStart();
    void printCars(Car[] cars);
    void printWinners(Car[] winners);
}
