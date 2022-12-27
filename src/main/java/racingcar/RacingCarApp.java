package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCarGameImpl;

public class RacingCarApp {

    AppConfig appConfig;

    public RacingCarApp(AppConfig appConfig){
        this.appConfig = appConfig;
    }

    public void run(){
        RacingCarGame racingCarGame = new RacingCarGameImpl(appConfig);
        racingCarGame.play();

    }
}
