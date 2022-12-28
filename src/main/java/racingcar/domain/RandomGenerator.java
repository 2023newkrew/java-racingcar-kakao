package racingcar.domain;

@FunctionalInterface
public interface RandomGenerator {
    int generate(int bound);
}
