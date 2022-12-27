package car_racing.model;

import car_racing.model.GamePlayStrategy;

public class RandomPlayStrategy implements GamePlayStrategy {

    @Override
    public Integer generateScore() {
        return (int) (Math.random() * 9);
    }
}
