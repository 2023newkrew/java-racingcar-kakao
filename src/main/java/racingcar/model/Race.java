package racingcar.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private final String nameStr;
    private final List<Car> cars = new ArrayList<>();

    public Race(String nameStr) {
        this.nameStr = nameStr;
    }

    public void verifyName(String input) {
        if (input.length() < 6) {
            return;
        }

        throw new IllegalArgumentException();
    }

    public String[] nameSplit() {
        return nameStr.split(",");
    }

    public void carInput(String[] nameSplit) {
        for (String name : nameSplit) {
            verifyName(name);
            cars.add(new Car(name));
        }
    }

    public void printRace() {
        for (Car car: cars) {
            car.printStatus();
        }

        System.out.println();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int raceMaxPosition() {
        int max = -1;

        for (Car car: cars) {
            max = Math.max(max, car.getPosition());
        }

        return max;
    }

    public void raceWinner() {
        int max = raceMaxPosition();
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(raceWinnerCheck(car, max));
        }

        System.out.println(sb.substring(0, sb.length()-2) + "가 최종 우승했습니다.");
    }

    public String raceWinnerCheck(Car car, int max){
        if (car.getPosition() == max) {
            return car.getName() + ", ";
        }

        return "";
    }

    public void playTurn() {
        for (Car car : cars) {
            if (RandomMoveNumber.getRandomMoveNumber() >= 4) {
                car.move();
            }
        }
    }

    public void playRace(int turn) {
        System.out.println("실행결과");

        printRace();

        for (int i = 0; i < turn; i++) {
            playTurn();
            printRace();
        }

        raceWinner();
    }

    public static void main(String[] args) throws IOException {
        String text;
        int turn;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        text = reader.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        turn = Integer.parseInt(reader.readLine());

        Race race = new Race(text);
        race.carInput(race.nameSplit());
        race.playRace(turn);
    }
}
