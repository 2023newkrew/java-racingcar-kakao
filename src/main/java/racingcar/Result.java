package racingcar;

import java.util.Map;

public class Result {

    private final Map<String, Integer> positions;

    public Result(Map<String, Integer> positions) {
        this.positions = positions;
    }

    public int getPositionByName(String name) {
        return positions.get(name);
    }
}
