package com.racing.Service;

import java.util.Random;

public class RandomService {

    /**
     * 0 ~ MAX_RANDOM 사이의 랜덤 정수 반환
     * @return random값
     */
    public int makeRandom(int randomRange){
        Random random = new Random();
        return random.nextInt(randomRange);
    }
}
