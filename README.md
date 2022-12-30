# java-racingcar-kakao
## Model

### InvalidInputException
* `racingcar.view.InputView`및 하위 클래스, `racingcar.domain.Car`에서 입력이 잘못 된 경우 생성하는 예외

### InvalidRacingConditionException
* `racingcar.domain.Racing`에서 잘못된 차 이름 / 잘못된 조건이 주어진 경우 생성하는 예외

### RandomGenerator, RandomGeneratorImpl
* 람다 함수를 위한 인터페이스 및 구체 클래스이며, Car에서 랜덤한 확률으로 이동하는 로직에서 쓰임.

### Position
* 생성자로 위치값에 해당하는 `val` 값을 받음(아무것도 넘기지 않으면 기본값으로 1)
* `val`값을 기준으로 `equals`, `compareTo` 등을 재정의하였다.
* `toString`의 경우 val값 만큼 "-"를 출력하도록 오버라이딩
* 추상화하고 싶었으나 2D(x,y), 3D(x,y,z)값을 포괄하는 메소드가 있을까 의문이 들어서 하지 않음, 설계 때 조금 더 고민했으면 어땠을까 아쉬움이 남음.

### Car
* `name`, `RandomGenerator rg`를 입력값으로 받음
* `name`의 경우 길이가 1~5 사이가 아니면 InvalidInputException을 발생시킴.
* `rg`의 경우 0~9 사이의 값 중 하나를 반환하는 람다 함수
* `move()` 메서드는 rg의 반환값에 따라 1 이동하거나 이동하지 않음
* `toString()`, `compareTo()`, `equals()` 재정의
* `toStringOnlyName()`, `equalsPosition()`또한 정의
* 추상화하고 싶었으나 어떤 것을 추상화할지 애매했고, 설계 때 부터 추상화를 했다면 하는 아쉬움이 남음

### Racing
* 생성자가 아닌 `Builder`로 객체 생성
* `Builder`에서는 차가 너무 적은지, 중복된 차가 있는지, round회수가 올바른지(양수) 검증하며 통과하지 못하면 InvalidRacingCondition 예외를 던진다.
* `proceedRound()`에서는 `remainingRound`를 하나 줄이고 각 `car`에 대해 `car.move()`를 실행시킨다. 이 때, `remainingRound`가 0 이하이면 InvalidRacingCondition 예외를 던진다.
