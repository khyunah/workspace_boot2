executeQuery와 excuteUpdate의 차이점
executeQuery는 resultSet을 만드는 sql문에서 사용한다.
주로 SELECT문에서 사용

excuteUpdate는 INSERT나 UPDATE문에서 사용된다.
리턴값은 쿼리를 전송해서 변화한 행의 개수를 나타낸다. 