package com.racing.controller;

import com.racing.model.Game;
import com.racing.view.InputView;
import com.racing.view.ResultView;

public class GameController {

    public static void main(String[] args) {
        // 기본 game 객체를 생성
        Game game = new Game();

        // 사용자 입력
        InputView inputView = new InputView();
        // 자동차들의 이름 목록을 사용자 입력으로 받고 game을 초기화함
        String inputInitNames = inputView.inputInitNames();
        game.init(inputInitNames);

        // 게임의 진행횟수를 받고 game을 횟수만큼 진행시킴
        int runCount = inputView.runCount();
        // 게임 진행
        game.run(runCount);

        // game 결과를 출력함
        ResultView resultView = new ResultView();
        resultView.printWinner(game.getWinner());
    }
}