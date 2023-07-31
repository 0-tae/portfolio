-- liquibase formatted sql logicalFilePath:assignment2/changelog/mysql/v1.0/v.1.0.1.sql

/* @runOnChange = true 를 통해 changeset 에 대한 직접적인 수정사항 발생 시 일어나는 MD5 체크섬 오류를 Disable 할 수 있음.
   이는 언제든지 바뀔 수 있다는 것을 의미
   @runTransaction = true 를 통해 해당 changeset 을 transaction 으로 실행
   @runAlways = true 를 통해 이전에 실행된 적이 있더라도 해당 changeset 을 실행함, 원래는 같은 ID 일 때 해당 작업을 건너 뛰었음 */

-- changeset 0tae:user-1 labels:v1,1.0,init
-- comment: init : 테이블 생성 및 제약조건 추가