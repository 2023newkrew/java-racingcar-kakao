package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    List<Car> cars = new ArrayList<>();
    int roundNum;
    public boolean RegisterCarNames(String input) {
        String[] temp = input.split(",");
        for (String name : temp) {
            if(name.length() > 5)
                return false;
        }

        for (String name : temp){
            cars.add(new Car(name));
        }
        return true;
    }
    public boolean RegisterCarRoundNum(String input) {
        try{
            roundNum = Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException ex){
            return false;
        }
    }
    public int Run() {
        int i = 0;
        while(i < roundNum){
            Round();
            i++;
        }
        return i;

    }
    public boolean Round() {
        for (Car car : cars) {
            car.move(random());
        }
        return true;
    }
    private boolean random() {
        Random rand = new Random();
        return rand.nextInt(10) >= 4;
    }
}
