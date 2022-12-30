package racingcar;

import racingcar.config.AppConfig;

public class RacingCarApp {

    private final AppConfig appConfig;

    public RacingCarApp(AppConfig appConfig){
        this.appConfig = appConfig;
    }

    public void run(){
        appConfig.getRacingCarGameController().play();
    }
}
