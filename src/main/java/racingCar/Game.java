package racingCar;

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
}
