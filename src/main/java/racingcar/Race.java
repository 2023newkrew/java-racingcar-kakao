package racingcar;

import java.util.ArrayList;

public class Race {
    String nameStr;
    ArrayList<Car> cars = new ArrayList<>();

    public Race() {
        this.nameStr = "pobi,crong,honux";
    }

    public Race(String nameStr) {
        this.nameStr = nameStr;
    }

    public void verifyName(String input) {
        if(input.length() < 6){
            return;
        }
        throw new IllegalArgumentException();
    }

    public String[] nameSplit() {
        return nameStr.split(",");
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
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int raceMaxCnt() {
        int max = -1;

        for (Car car: cars) {
            max = Math.max(max, car.getCnt());
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
        if(car.getCnt() == max){
            return car.getName() + ", ";
        }
        return "";
    }
}
