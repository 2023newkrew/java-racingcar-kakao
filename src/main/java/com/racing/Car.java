package com.racing;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Car {
    private int innerLocation = 0;
    private String innerName = "";

    private Car() {
    }

    public static Factory factory() {
        return new Factory();
    }

    public String name() {
        return this.innerName;
    }

    public int location() {
        return this.innerLocation;
    }

    public void setLocation(int location) {
        this.innerLocation = location;
    }

    /**
     * 자동차의 location을 업데이트하는 메서드. 입력된 값에 따라 location을 적당히 조절한다.
     *
     * @param userInput 0~9 사이의 값을 입력받는다 4 이상이면 location 을 1 증가시킨다.
     */
    public void move(int userInput) {
        if (userInput < 0 || 9 < userInput) {
            throw new InvalidParameterException("user input must be in 0..9");
        }
        if (userInput >= 4) {
            this.innerLocation += 1;
        }
    }

    /**
     * 자동차를 생성하는 팩토리.
     * 주 역활은 특정 조건을 만족하지 못하는 자동차 객체가 생성되는 것을 방지하는 것이다.
     */
    public static class Factory {
        Car temporary;

        private Factory() {
            this.temporary = new Car();
        }

        public Factory withName(String name) {
            if (Objects.isNull(name)) {
                throw new InvalidParameterException("name not nullable");
            }
            if (name.isEmpty()) {
                throw new InvalidParameterException("car name must not be empty");
            }
            if (name.length() > 5) {
                throw new InvalidParameterException("car name length over 5");
            }
            this.temporary.innerName = name;
            return this;
        }

        public Car build() {
            Car result = temporary;
            this.temporary = null;
            return result;
        }
    }
}
