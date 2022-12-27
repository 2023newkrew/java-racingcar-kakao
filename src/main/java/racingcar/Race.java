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
        if(input.length() < 6 && input.length() > 0){
            return;
        }
        throw new IllegalArgumentException();
    }

    public String[] nameSplit() {
        return carNameCsv.split(",");
    }

    public void ready(){
        this.carNamesCheck(nameSplit());
    }
    public void carNamesCheck(String[] nameSplit) {
        for (String carName : nameSplit){
            carInput(carName);
        }
        if (cars.size() == 1){
            System.out.println("경주할 자동차는 2대 이상이어야 합니다.");
            cars = new ArrayList<>();
        }
    }

    public void carInput(String carName){
        try {
            verifyName(carName);
        } catch (IllegalArgumentException e){
            cars = new ArrayList<>();
            System.out.println("자동차 이름은 1자 이상 5자 이하여야 합니다. : '" + carName + "'");
            return;
        }
        cars.add(new Car(carName));
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int turn;
        Race race = null;

        while (race == null || race.getCars().isEmpty()){
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            race = new Race(reader.readLine());
            race.ready();
        }

        System.out.println("시도할 회수는 몇회인가요?");
        turn = Integer.parseInt(reader.readLine());

        race.playRace(turn);
    }
}
