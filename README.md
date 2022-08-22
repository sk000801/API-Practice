# [CUTIEPIE](https://github.com/Cutiepazzipozzi/JPA_practice_small) 쇼핑몰 클론코딩을 위해
### 혼자서 야매로 해보는 API 연습....
(이게 API일까..? 싶은 실습도 해본다....)

<br>

- JSON 형태로 반환하는 페이지 만들어보기
  <br>
-> @RequestMapping, @ResponseBosy를 활용해 이 실습에서는
product나 order 리스트들을 json 형태로 페이지에 띄워준다!

- 여러개의 항목을 여러개의 json으로 반환하는
  페이지 ?? 만들어보기
  <br>
-> 이것도 위와 마찬가지로, h2 콘솔에 페이지에서 계속 입력받아 데이터들이 저장되면 자동으로
여러개의 product들이 하나의 리스트에 json 형태로 나열되어 출력된다

- 이전 페이지의 정보를 다음 페이지로 넘겨주기
-> 어떤 상품을 주문할 때 주문 버튼을 누르면, 그 상품의 id가
넘겨지고 이를 이용해 해당 상품을 주문하도록!

- 멤버 id와 같은 정보를 페이지에 저장하기 위한 세션 활용 기능 구현

<br>

