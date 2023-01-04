package racingcar.view;

import racingcar.service.dto.CarResponse;

import java.util.List;
import java.util.stream.Collectors;

public class FinalResult {

    private List<CarResponse> carResponses;

    public FinalResult(List<CarResponse> carResponses) {
        this.carResponses = carResponses;
    }

    public String toString() {
        String winners = carResponses.stream()
                .map(CarResponse::getName)
                .collect(Collectors.joining(", "));

        return String.format("%s가 최종 우승했습니다.", winners);
    }
}
