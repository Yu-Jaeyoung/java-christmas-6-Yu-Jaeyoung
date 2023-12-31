# 미션 - 크리스마스 프로모션 

- 비즈니스 팀에서 아래와 같은 요구 사항을 가진 프로모션 요구사항 도착
- 개발팀에서는 아래 요구 사항을 기반으로 개발 진행

## 🎄 이벤트 소개


### 🗒️ 메뉴
```
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```

### 이벤트 종류
- 크리스마스 디데이 할인
  - 이벤트 기간 12.1 ~ 12.25
  - 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
  - 총 주문 금액에서 해당 금액만큼 할인
- 평일 할인 (일요일~목요일)
  - 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
- 주말 할인 (금요일,토요일)
  - 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
- 특별 할인
  - 이벤트 달력에 별이 있으면 총 주문 금액에서 1,000원 할인
- 증정 이벤트
  - 할인 전 총 주문 금액이 12만원 이상일 때, 샴페인 1개 증정
- 이벤트 기간
  - 크리스마스 디데이 할인을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용


### 혜택금액에 따라 12월 이벤트 배지 부여
- 5천 원 이상: 별
- 1만 원 이상: 트리
- 2만 원 이상: 산타

### 이벤트 주의 사항
- 총 주문 금액 10,000원 이상부터 이벤트가 적용됨
- 음료만 주문 시, 주문할 수 없음
- 메뉴는 한 번에 최대 20개 까지만 주문할 수 있음


## 출력 요구 사항
- 고객들이 식당에 방문할 날짜와 메뉴를 미리 선택
- 주문 메뉴
- 할인 전 총 주문 금액
- 증정 메뉴
- 혜택 내역
- 총 혜택 금액
- 할인 후 예상 결제 금액
- 12월 이벤트 배지 내용

## 출력 예시

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
26 
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
타파스-1,제로콜라-1 
12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
타파스 1개
제로콜라 1개

<할인 전 총주문 금액>
8,500원
 
<증정 메뉴>
없음
 
<혜택 내역>
없음
 
<총혜택 금액>
0원
 
<할인 후 예상 결제 금액>
8,500원
 
<12월 이벤트 배지>
없음
```

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
```

## 개발 요청 사항

- 방문할 날짜는 1 이상 31 이하의 숫자로만 입력 받기
  - 1 이상 31 이하의 숫자가 아닌 경우,[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." 라는 에러 메시지 출력
- 고객이 메뉴판에 없는 메뉴를 입력하는 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지 출력
- 메뉴의 개수는 1 이상의 숫자만 입력 받기
  - 이 외의 입력값은 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지 출력
- 메뉴 형식이 예시와 다른 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지 출력
- 중복 메뉴를 입력한 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지 출력
- 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성
- 주문 메뉴의 출력 순서는 자유롭게
- 총 혜택 금액에 따라 이벤트 배지의 이름을 다르게
  - 총 혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
- 할인 후 예상 결제 금액 = 할인 전 총 주문 금액 - 할인 금액
- 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 출력
- 혜택 내역은 고객에게 적용된 이벤트 내역만 출력
- 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 출력
- 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게
- 이벤트 배지가 부여되지 않은 경우, "없음"으로 출력

<br>

# 🚀 기능 구현

### 기능 흐름 예상 

1. 날짜를 입력 받는다.
2. 메뉴와 개수를 입력 받는다.
3. 총 금액을 계산한다.
4. 이벤트 대상인지 확인한다. (주문을 음료만 했는가?)
5. 주문 메뉴를 출력한다.
6. 총 금액을 출력한다.
→ 음료 외 주문이 있다면,
7. 총 금액으로 증정 메뉴 대상인지 확인한다. → 출력한다.
8. 혜택 내역이 있는지 확인한다. → 출력한다.
   - 평일 할인?
   - 주말 할인?
   - 특별 할인?
   - 크리스마스 디데이 할인?
9. 총 혜택 금액을 계산한다.
10. 총 혜택 금액을 출력한다.
11. 할인 후 예상 결제 금액을 계산한다.
12. 할인 후 예상 결제 금액을 출력한다.
13. 12월 이벤트 배지 대상자인지 확인한다. → 출력한다.


### 상수 정의

---

- [x] 구문 

- [x] Enum
  
  - [x] 애피타이저

  - [x] 메인

  - [x] 디저트

  - [x] 음료

---

<br>

### 계산 기능

- [x] 총 금액을 계산하는 기능 

- [x] 총 혜택 금액을 계산하는 기능

- [x] 할인 후 예상 결제 금액을 계산하는 기능

---

<br>

### 이벤트 관련 기능

- [x] 음료만 주문했는가?

- [x] 총 주문 금액이 10,000을 넘는가?

- [x] 증정 메뉴 대상인가?

- [x] 평일 할인 대상인가?

- [x] 주말 할인 대상인가?

- [x] 특별 할인 대상인가?

- [x] 크리스마스 디데이 할인 대상인가?

- [x] 12월 이벤트 배지 대상인가?

---

<br>

### 입력 기능 + 가능 예외

---

- [x] 식당 예상 방문 날짜 입력 view.Input#readDate()
  
  #### 가능 예외

  - [x] 입력이 없는 경우  

  - [x] 공백이 포함된 입력

    ##### 숫자로 변환 이후
  
  - [x] 숫자 외 입력
  
  - [x] 1보다 작거나 31보다 큰 입력

---

- [x] 메뉴와 개수 입력

  #### 가능 예외

  - [x] 입력이 없는 경우
  
  - [x] 공백이 포함된 입력

  - [x] " - " 이 없는 경우

  - [x] " , " 앞뒤 미입력 → 정규 표현식 활용
  
    ##### " , " 로 분리 이후

  - [x] " - " 이 없는 경우
  
  - [x] " - " 앞에 입력이 없는 경우 → 정규 표현식 활용

  - [x] " - " 뒤에 입력이 없는 경우 → 정규 표현식 활용
  
  - [x] " - " 뒤에 입력이 숫자 1 이상 20 이하가 아닌 경우 → 정규 표현식 활용

    ##### " - " 로 분리 이후

  - [x] 메뉴판에 없는 메뉴인가?

  - [x] 음료만 주문하였는가?

  - [x] 중복된 메뉴를 입력했는가?

---

<br>

### 출력 기능

- [x] 주문 메뉴 출력

- [x] 할인 전 총 주문 금액 출력

- [x] 증정 메뉴 출력

- [x] 혜택 내역 출력 → 총 혜택 금액이 0원인 경우 없음을 출력

- [x] 총 혜택 금액 출력

- [x] 할인 후 예상 결제 금액 출력

- [x] 12월 이벤트 배지 출력


# 🎯 프로그래밍 요구 사항

- [x] JDK 17

- [x] indent depth를 3이 넘지 않도록 구현. 2까지만 허용

- [x] 3항 연산자 미사용

- [x] 함수(메서드)의 길이가 15 라인을 넘어가지 않도록 구현 (main 포함)

- [ ] 함수가 한 가지 일만 하도록 최대 작게 작성 ▲

- [ ] JUnit5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인 ▲

- [x] else 예약어를 사용하지 않기

- [x] switch-case 문 사용하지 않기

- [ ] 도메인 로직에 단위 테스트를 구현. 단, UI 로직은 제외 ▲

- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 뒤, "[ERROR]"로 시작하는 메시지 출력 후 그 부분부터 재 입력 

- [x] 입출력 클래스 / InputView, OutputView 클래스 구현

- [x] 비지니스 로직과 UI 로직을 분리했는가?

- [x] 연관성이 있는 상수는 static final 대신 enum을 활용

- [x] final 키워드를 사용해 값의 변경을 막음

- [x] 객체의 상태 접근을 제한

- [x] getter의 활용은 데이터를 꺼내는 것이 아닌 메시지를 던지도록 구조를 변경하여 활용

- [x] 필드(인스턴스 변수)의 개수를 줄이기

# 셀프 코드 리뷰 / 어디를 고칠까?

- Menu
  - [x] Menu의 price에 _ 추가하기


- Phrase
  - [x] 1회성 구문들 사용되는 곳으로 옮기기
  

- controller
  - [x] controller의 역할 다시 생각해보기
  

- doamin
  - [x] Calendar의 getDate가 적합하게 사용되었는가? → 삭제
  - [x] Cost 클래스의 역할이 적절한가? → DiscountStatus 클래스로 분리
  - [x] Cost의 getter를 다른 방법으로 선언하는 법? → 현재는 getter가 불가피 한것으로 판단됨.
  - [x] Cost의 setter 역할을 하는 apply를 다른 방법으로? → DiscountStatus 클래스로 기능 옮김 
  - [x] Cost의 discount 관련 변수를 다르게?  →  Discount Enum 선언