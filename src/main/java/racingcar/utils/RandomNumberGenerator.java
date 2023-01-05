package racingcar.utils;

@FunctionalInterface
public interface RandomNumberGenerator {
    int generate(int bound);
}
