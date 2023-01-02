package racingcar.view;

import racingcar.service.dto.CarResponse;

import java.util.List;

public class RoundResult {

    private List<CarResponse> carResponses;

    public RoundResult(List<CarResponse> carResponses) {
        this.carResponses = carResponses;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (CarResponse carResponse : carResponses) {
            result.append(String.format("%s : %s\n", carResponse.getName(), "-".repeat(carResponse.getPosition())));
        }

        return result.toString();
    }

}
