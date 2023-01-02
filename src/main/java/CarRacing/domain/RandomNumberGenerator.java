package CarRacing.domain;

import CarRacing.util.RandomUtil;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber(int randomNumberRange) {
        return RandomUtil.generateRandomNumber(randomNumberRange);
    }
}
