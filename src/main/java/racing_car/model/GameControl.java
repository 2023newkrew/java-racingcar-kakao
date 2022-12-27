package racing_car.model;

import java.util.Random;

public class GameControl {
    public int generateRandomNumber() {
        return new Random().nextInt(10);
    }

    public void carControl(Car car, int number) {
        if (number >= 4){
            car.move(1);
        }
    }
}
