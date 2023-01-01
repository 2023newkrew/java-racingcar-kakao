package CarRacing.domain;

import CarRacing.util.StringUtil;
import java.util.Objects;

public class RacingCount {
    private final int racingCount;

    public RacingCount(String racingCount) {
        validateRacingCount(racingCount);
        this.racingCount = StringUtil.convertStringToInt(racingCount);
    }

    public RacingCount(int racingCount) {
        this.racingCount = racingCount;
    }

    public boolean isEnd() {
        return racingCount > 0;
    }

    public RacingCount decreaseCount(int count) {
        return new RacingCount(racingCount - count);
    }

    public void validateRacingCount(String racingCount) {
        try {
            StringUtil.convertStringToInt(racingCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수 입력이 숫자가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCount that = (RacingCount) o;
        return racingCount == that.racingCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCount);
    }
}
