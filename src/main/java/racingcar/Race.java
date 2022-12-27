package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Race {
    private String carNameCsv;
    private ArrayList<Car> cars = new ArrayList<>();

    public Race(String carNameCsv) {
        this.carNameCsv = carNameCsv;
    }

    public void verifyName(String input) {
        if(input.length() < 6){
            return;
        }
        throw new IllegalArgumentException();
    }

    public String[] nameSplit() {
        return carNameCsv.split(",");
    }

    public void carInput(String[] nameSplit) {
        for (String name : nameSplit){
            verifyName(name);
            cars.add(new Car(name));
        }
    }

    public void printRace() {
        for(Car car: cars){
            car.printStatus();
        }
        System.out.println();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int raceMaxCnt() {
        int max = -1;

        for (Car car: cars) {
            max = Math.max(max, car.getCount());
        }

        return max;
    }

    public void raceWinner() {
        int max = raceMaxCnt();
        StringBuilder sb = new StringBuilder();
        for(Car car : cars){
            sb.append(raceWinnerCheck(car, max));
        }
        System.out.println(sb.substring(0, sb.length()-2) + "가 최종 우승했습니다.");
    }

    public String raceWinnerCheck(Car car, int max){
        if(car.getCount() == max){
            return car.getName() + ", ";
        }
        return "";
    }

    public void playTurn() {
        for (Car car : cars) {
            car.race();
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
