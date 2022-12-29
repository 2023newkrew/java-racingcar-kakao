package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    RacingCarView racingCarView;
    CarListManager carListManager;

    public RacingCarGame() {
        racingCarView = new RacingCarView();
        carListManager = new CarListManager();
    }

    public void start() {
        ArrayList<RoundRecord> roundRecords = new ArrayList<>();
        List<String> carNamesInput = racingCarView.receiveCarNamesCsv();
        int runNumber = racingCarView.receiveRunNumber();
        for (String carName : carNamesInput) {
            carListManager.add(new Car(carName));
        }
        for (int i = 0; i < runNumber; i++) {
            ArrayList<CarStatusDto> carStatusList = new ArrayList<>();
            carListManager.moveAll();
            carListManager.getCars()
                    .stream()
                    .map(CarStatusDto::toDto)
                    .forEach(carStatusList::add);
            roundRecords.add(new RoundRecord(carStatusList));
        }
        racingCarView.printGameResult(new GameResult(roundRecords));
        racingCarView.printWinners(carListManager.selectWinners());
    }
}
