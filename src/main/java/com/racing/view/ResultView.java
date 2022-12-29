package com.racing.view;

import com.racing.model.Car;
import com.racing.model.Game;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    /**
     * 게임의 결과를 출력하는 메서드
     */
    public void printWinner(List<Car> winners) {
        // 모든 승자의 이름을 출력
        for (Car car : winners) {
            System.out.println(car.getCarName() + ", ");
        }
        // 마지막 ", " 빼주기
        System.out.println("가 최종 우승했습니다.");
    }
}