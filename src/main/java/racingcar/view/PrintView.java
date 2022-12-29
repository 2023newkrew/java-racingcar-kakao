package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public interface PrintView {
    void printStart();
    void printCars(Car[] cars);
    void printWinners(Car[] winners);
}
