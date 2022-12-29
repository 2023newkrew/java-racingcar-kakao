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
     * @param userInput 0~9 사이의 값을 입력받는다 4 이상이면 location을 1 증가시킨다.
     */
    public void move(int userInput) {
        if (userInput < 0 || 9 < userInput) {
            throw new InvalidParameterException("user input must be in 0..9");
        }
        if (userInput >= 4) {
            this.innerLocation += 1;
        }
    }

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
