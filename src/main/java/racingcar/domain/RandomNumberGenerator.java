package racingcar.domain;

@FunctionalInterface
public interface RandomNumberGenerator {
    int generate(int bound);
}
