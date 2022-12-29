package racingCar;

import java.util.ArrayList;

public class Game {
    private final int totalTurns;
    private int curTurn = 0;
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

    public void play() {
        for (int i = 0; i < cars.length; i++) {
            moveCar(i, RandomNumGenerator.generateRandomNum());
        }
        printCars();
        curTurn++;
    }

    public boolean isEnd() {
        return curTurn == totalTurns;
    }

    public void printCars() {
        for (Car car : cars) {
            car.print();
        }
        System.out.println();
    }

    private static String carsToNames(Car[] cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car: cars) {
            sb.append(car.getName()).append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public void printWinners() {
        Car[] winners = this.findWinners();
        System.out.printf("%s가 최종 우승했습니다.\n", Game.carsToNames(winners));
    }
}
