# java-racingcar-kakao

## 문자열 덧셈 계산기

1. 유저의 입력 받아오기
1. 문자열에서 추가 구문자 추출
1. target string 에서 구분자들 기준으로 split
1. split 된 substring의 유효성 검증

    - NULL or 빈문자열일 경우 0 반환
    - 음수일 경우 Runtime Exception을 throw
    - Integer가 아닐 경우 Exception을 throw

1. 변환된 substring 들을 더하여 반환

### Test의 target

**Class**
- stringcalculator.StringParser
    - parseSplitter
    - parseTargetString
    - splitTargetString
    - castStringToInteger
- stringcalculator.StringVerifier
    - isInteger
    - isPositive
    - isNullOrEmpty
- stringcalculator.Calculator
    - add()
- Runner
    - public run()
    - private receiveInput
    - private calculate
    - private printResult

---

## CarRacing

### Domain

#### Interface

- interface RacingPlayer
  - property
    - String name
    - int position
  - method
    - proceedNextTurn
    - getScore
    - getName
- interface GamePlayStrategy
  - generateScore

#### Class

- class Car implements RacingPlayer
  - @override toString
- GameRule
  - static property
    - STANDARD_SCORE
    - GAME_PLAY_STRATEGY
  - static method
    - isAbleToProceed
    - getWinners
- RandomPlayStrategy implements GamePlayStrategy

### View

- OutputView
  - method
    - askForNames
    - askForNumberOfTurns
    - printCurrentStatus
    - printWinners
    - getConcatenatedNameFromArray
- InputView
  - method
    - getPlayerNames
    - getNumberOfTurns
    - verifyName

### Controller

- class RacingController
  - property
    - inputView
    - racingPlayers
    - playerNames
    - numberOfTurns
  - method
    - run
    - getNamesFromUser
    - getNumberOfTurnsFromUser
    - printResult
    - createPlayers
    - runSingleTurn
    - sleep

