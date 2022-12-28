package racingcar.dto;

import racingcar.domain.GameSetting;

public class CarDto {

    private String name;
    private int position;

    public CarDto(String name) {
        this(name, GameSetting.INITIAL_POSITION);
    }

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
