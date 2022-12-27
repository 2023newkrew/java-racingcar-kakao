package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private final List<Car> cars = new ArrayList<>();
    private int roundNum;
    boolean RegisterCarNames(String input) {
        String[] temp = input.split(",");
        if (!LengthCheck(temp)) return false;

        for (String name : temp){
            cars.add(new Car(name));
        }
        return true;
    }

    private boolean LengthCheck(String[] nameList) {
        boolean check = true;
        for (String name : nameList) {
            check &= (name.length() <= 5);
        }
        return check;
    }

    boolean RegisterCarRoundNum(String input) {
        try{
            roundNum = Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException ex){
            return false;
        }
    }
    boolean Round() {
        for (Car car : cars) {
            car.move(random());
        }
        return true;
    }

    String RoundResult(){
        String temp="";
        for (Car car : cars) {
            temp += car.getName()+","+car.getPosition()+",";
        }
        return temp;
    }
    private boolean random() {
        Random rand = new Random();
        return rand.nextInt(10) >= 4;
    }

    String GetWinner(){
        int maxPosition = 0;
        String winnerList = "";
        for (Car car : cars){
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        for (Car car : cars){
            winnerList += car.MatchPosition(maxPosition);
        }
        return winnerList;
    }
    int GetRoundNum(){
        return roundNum;
    }
}
