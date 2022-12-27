package car_racing.model;

public class RandomPlayerStrategy implements GamePlayerStrategy {

    @Override
    public Integer generateScore() {
        return (int) (Math.random() * 9);
    }
}
