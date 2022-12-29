package car_racing.domain;

public class RandomScoreStrategy implements ScoreStrategy {
    @Override
    public Integer generateScore() {
        return (int) (Math.random() * 9);
    }
}
