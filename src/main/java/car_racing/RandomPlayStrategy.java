package car_racing;

public class RandomPlayStrategy implements GamePlayStrategy {
    @Override
    public Integer generateScore() {
        return (int) (Math.random() * 9);
    }
}
