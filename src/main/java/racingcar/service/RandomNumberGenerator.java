package racingcar.service;

@FunctionalInterface
public interface RandomNumberGenerator {
    int generate(int bound);
}
