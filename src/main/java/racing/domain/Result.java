package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    public List<String> getWinner(Car[] cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (int index = 0; index < cars.length; index++) {
            maxPosition = cars[index].getMaxPosition(maxPosition);
        }
        for (int index = 0; index < cars.length; index++) {
            String winnerName = cars[index].getWinnerName(maxPosition);
            winners = addWinner(winners, winnerName);
        }
        return winners;
    }

    public List<String> addWinner(List<String> winners, String name) {
        if(name != null) {
            winners.add(name);
        }
        return winners;
    }

}
