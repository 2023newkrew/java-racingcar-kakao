package racing.service;

import racing.repository.RacingCarRepository;

import java.util.List;

public class RacingService {
    private final RacingSplitter racingSplitter;

    public RacingService(){
        racingSplitter = new RacingSplitter();
    }

    public void cycleProgress() {
        RacingCarRepository.getCars()
                .tryMove();
    }

    public void insertCars(String carString){
        RacingCarRepository.saveCars(
                racingSplitter.split(carString)
        );
    }
    public List<String> getCarStatusStrings(){
        return RacingCarRepository.getCars()
                .getAllCarStatusStrings();
    }

    public List<String> getWinnerCarNames(){
        return RacingCarRepository.getCars()
                .getWinnerCarName();
    }

}
