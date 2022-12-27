package car_racing;

public class RandomScoreStrategy implements ScoreStrategy {
    @Override
    public Integer generateScore() {
        return (int) (Math.random() * 9);
    }
}
