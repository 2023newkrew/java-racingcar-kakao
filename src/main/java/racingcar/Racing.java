package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    List<Car> cars = new ArrayList<Car>();
    int roundNum;
    Racing() {
        //동적할당
    }
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
}
