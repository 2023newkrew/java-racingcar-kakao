package com.racing.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * 사용자 입력으로부터 자동차의 이름 목록을 받는 메서드
     */
    public String inputInitNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        // 초기화
        return(this.scanner.nextLine());
    }

    /**
     * 사용자 입력으로부터 게임을 n회 진행시키는 메서드
     */
    public int runCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        // n회의 게임 단계 진행횟수를 받음
        int runCount = this.scanner.nextInt();
        return runCount;
    }
}