
// preparedStatement 사용 방법

Statement와 preparedStatement의 차이점은 캐시 사용 유무이다.
따라서 반복적으로 쿼리를 수행한다면, Statement에 비해 성능이 훨씬 좋다.

그리고 보안적인 측면에서 Statement보다 preparedStatement보다 안정성이 높다.
preparedStatement를 쓰는것이 권장사항이다.
