package racingCar;

import java.util.ArrayList;

public class Game {
    private final int totalTurns;
    private final Car[] cars;

    public Game(int totalTurns, Car[] cars) {
        this.totalTurns = totalTurns;
        this.cars = cars;
    }

    public void moveCar(int carIdx, int randomNumber) {
        if (randomNumber >= 4) {
            cars[carIdx].move();
        }
    }

    private void addIfAhead(ArrayList<Car> winners, Car car) {
        if (winners.size() == 0 || car.getPosition() == winners.get(0).getPosition()) {
            winners.add(car);
            return;
        }
        if (car.getPosition() > winners.get(0).getPosition()) {
            winners.clear();
            winners.add(car);
        }
    }

    public Car[] findWinners() {
        ArrayList<Car> winnersList = new ArrayList<>();
        for (Car car: cars) {
            addIfAhead(winnersList, car);
        }
        return winnersList.toArray(new Car[winnersList.size()]);
    }
}
