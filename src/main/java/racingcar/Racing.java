package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private final List<Car> cars = new ArrayList<>();
    private int roundNum;
    boolean registerCarNames(String input) {
        String[] temp = input.split(",");
        if (!lengthCheck(temp)) return false;

        for (String name : temp) {
            cars.add(new Car(name));
        }
        return true;
    }

    private boolean lengthCheck(String[] nameList) {
        boolean check = true;
        for (String name : nameList) {
            check &= (name.length() <= 5);
        }
        return check;
    }

    boolean registerCarRoundNum(String input) {
        try {
            roundNum = Integer.parseInt(input);
            return positiveCheck(roundNum);
        }
        catch (NumberFormatException ex){
            return false;
        }
    }
    private boolean positiveCheck(int roundNum) {
        return roundNum > 0;
    }
    boolean round() {
        for (Car car : cars) {
            car.move(random());
        }
        return true;
    }

    String roundResult() {
        String temp="";
        for (Car car : cars) {
            temp += car.getName()+","+car.getPosition()+",";
        }
        return temp;
    }
    protected boolean random() {
        Random rand = new Random();
        return rand.nextInt(10) >= 4;
    }
    String getWinner() {
        int maxPosition = 0;
        String winnerList = "";
        for (Car car : cars){
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        for (Car car : cars){
            winnerList += car.matchPosition(maxPosition);
        }
        return winnerList;
    }
    int getRoundNum(){
        return roundNum;
    }
    Car getCar(int index) {
        try {
            return cars.get(index);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
            throw ex;
        }
    }
}
