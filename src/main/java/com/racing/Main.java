package com.racing;

public class Main {
    public static void main(String[] args) {
        GameUI gameUI = new GameUI(System.in, System.out);
        gameUI.init();
        gameUI.run();
    }
}
