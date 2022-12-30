# java-racingcar-kakao

## 구현할 기능 목록

1. 자동차 이름 부여
    - 5자를 초과하는 이름을 입력하면 RuntimeException 예외가 발생한다.
    - 중복되는 이름이 존재하면 RuntimeException 예외가 발생한다.
    - 빈 문자열이나 NULL이 입력되면 RuntimeException 예외가 발생한다.
2. 자동차 1대 전진
    - 자동차가 전진하면 자동차의 위치 값이 1 증가한다.
3. 사용자 시도횟수 입력
    - 음수를 입력하면 RuntimeException 예외가 발생한다.
    - 자연수가 아닌 입력은 RuntimeException 예외가 발생한다.
4. random값 생성
    - random으로 생성된 값은 0에서 9사이다.
5. 우승자 선정
    - 시도할 횟수가 0이면 모든 자동차가 우승자가 된다.
    - 최종 우승자는 최소 1명 이상이다.
