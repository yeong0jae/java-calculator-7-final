## 구현할 기능 목록

## 도메인

### 계산기

- [ ] 분리된 각 숫자를 합한다.

### 숫자 분리

- [ ] 구분자(쉼표, 콜론)을 기준으로 분리한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

### 구분자

- [ ] 기본 구분자는 쉼표, 콜론이다.
- [ ] 커스텀 구분자를 지정할 수 있다.
    - [ ] 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
        - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

## 입력

- [ ] 구분자와 양수로 구성된 문자열을 입력받는다.
    - [ ] 덧셈할 문자열 입력 안내 메시지를 출력한다.

## 출력

- [ ] 덧셈 결과를 출력한다.

### 예외 처리

- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
