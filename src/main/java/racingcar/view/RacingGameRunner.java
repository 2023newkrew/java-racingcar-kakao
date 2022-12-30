package racingcar.view;

import racingcar.model.Car;
import racingcar.view.condition.InputParser;
import racingcar.view.exceptions.InvalidFormatException;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGameRunner {
    private final Scanner scanner = new Scanner(System.in);
    private String carNames;
    private int numberOfGames;
    private Set<Car> carSet;

    public RacingGameRunner() {
        this.carNames = "";
        this.numberOfGames = 0;
    }

    public void inputData(){
        carNames = inputCarNames();
        carSet = registerCars(carNames);
        if (carSet.size() <= 1) {
            throw new InvalidFormatException("경주할 유효한 자동차가 없습니다. 각 자동차의 이름을 5자 이하로 2대 이상 작성해주세요.");
        }
        numberOfGames = inputTryCount();
    }

    public void run() {
        for (int i = 0; i < numberOfGames; i++) {
            this.move();
            this.printCars();
            System.out.println();
        }
        this.printWinners();
    }

    public void move() {
        for (Car car: carSet){
            car.move();
        }
    }

    public void registeredData(String carNames, int numberOfGames) {
        this.carNames = carNames;
        this.numberOfGames = numberOfGames;
        this.carSet = registerCars(carNames);
    }

    public Set<Car> getCarList() {
        return carSet;
    }

    public void printCars() {
        for (Car car : carSet) {
            car.print();
        }
    }

    public void printWinners() {
        List<Car> winners = pickWinners();

        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private int inputTryCount() throws InvalidFormatException{
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            numberOfGames = scanner.nextInt();
            return numberOfGames;
        } catch (InputMismatchException e) {
            throw new InvalidFormatException("정확한 숫자가 입력되어야 합니다");
        }
    }

    private Set<Car> registerCars(final String carNames){
        InputParser inputParser = new InputParser();
        Set<String> splitCarNames = inputParser.splitNames(carNames);
        return splitCarNames.stream()
                .map(Car::new)
                .collect(Collectors.toSet());
    }

    private List<Car> pickWinners(){
        int maxPosition = carSet.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carSet.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}