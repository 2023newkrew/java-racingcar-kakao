package racing.service;

import racing.repository.RacingCarRepository;

import java.util.List;

public class RacingService {
    private final RacingCarRepository racingCarRepository;
    private final RacingSplitter racingSplitter;

    public RacingService(){
        racingSplitter = new RacingSplitter();
        racingCarRepository = new RacingCarRepository();
    }

    public void cycleProgress() {
        racingCarRepository.getCars()
                .tryMove();
    }

    public void insertCars(String carString){
        racingCarRepository.saveCars(
                racingSplitter.split(carString)
        );
    }
    public List<String> getCarStatusStrings(){
        return racingCarRepository.findAllCarStatus();
    }

    public List<String> getWinnerCarNames(){
        return racingCarRepository.findAllWinnerCarName();
    }

}
