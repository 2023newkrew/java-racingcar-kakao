package racingcar;

@FunctionalInterface
public interface RandomNumberGenerator {
    int generate(int bound);
}
