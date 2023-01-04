# 덧셈 계산기

## 기능 요구사항

- [x] 입력 예외 처리
- [x] 주어진 문자열을 구분자로 split
- [x] split된 문자(숫자)들을 덧셈
- [x] //와 \n 사이에 주어진 문자를 구분자로 추가
- [x] 0~9 외에는 런타임 발생

현재 계산기에서 수행되는 기능

- 구분자 유무 확인 + 있을 시 구분자 추가
- 구분자로 input 파싱 + 파싱된 값 유효성 체크
- 구분된 값으로 덧셈 수행

테스트가 안되고 있는 부분

- 파싱이 잘 되고 있는가? -> Parser 클래스
- 구분자가 잘 추가되었는가? -> Parser 클래스를 통해 return
- 파싱된 값에 대한 유효성 체크가 잘 되고 있는가? -> ValidInput

Main -> 사용자에게 입력값 받음 : InputUI
-> input 값으로 덧셈 로직 실행 : Calculator 실행
-> 덧셈을 수행하기 위해 구분자 추출 및 입력값 파싱 : Parser
-> Parser를 통해 얻어진 Number 객체를 통해 계산 수행 및 반환: Calculator
-> 결과 출력 : Main

TODO : 테스트 코드 정리

---

# 자동차 경주

## 기능 요구사항

- [x] 사용자가 입력한 자동차 이름의 개수만큼 자동차 생성
    - [x] 자동차 이름은 쉼표로 구분
    - [x] 이름은 5자 이하
- [x] 이동 횟수 입력
- [x] 각 횟수마다 자동차마다 Random 값 생성
    - [x] 4 이상일 경우 전진
    - [x] 3 이하일 경우 정지
- [x] 결과 출력
    - [x] 각 턴 종료 후 출력
    - [x] 경기 종료 후 우승자 출력

---

# 자동차 경주 - MVC

Main -> Controller
입출력 -> View
핵심 로직 -> Domain

## 기능 요구사항
### Car
- [x] 자동차의 이름은 5자 이하여야 한다.
    - [x] 5자를 초과하는 경우 예외가 발생한다.
- [x] 자동차는 이름이 존재해야 한다.
    - [x] 이름이 존재하지 않은 경우 예외가 발생한다.
- [x] 자동차는 0~9 사이의 주어진 수에 따라 전진하거나 정지한다.
  - [x] 자동차는 4 이상의 수인 경우 전진한다.
  - [x] 자동차는 3 이하의 수인 경우 정지한다.
  - [x] 자동차에게는 랜덤으로 숫자가 부여된다. -> RandomNumberGenerator

[//]: # (### RacingGame)
- [ ] 입력한 횟수만큼 자동차는 움직일 수 있다.
- [ ] 가장 많이 나아간 자동차가 우승한다.
-> 역할 : 등록된 자동차들 가지고 게임 실행하기
-> 자동차 만들고
-> 주어진 횟수만큼 실행시키고
-> 우승자 선정하고

TODO : Cars 일급 컬렉션까지 만듬 -> RacingGame 구현