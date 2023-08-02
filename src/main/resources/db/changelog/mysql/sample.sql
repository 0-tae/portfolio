-- liquibase formatted sql logicalFilePath:assignment2/changelog/mysql/v1.0/sample.sql

/* @runOnChange = true 를 통해 changeset 에 대한 직접적인 수정사항 발생 시 일어나는 MD5 체크섬 오류를 Disable 할 수 있음.
   이는 언제든지 바뀔 수 있다는 것을 의미
   @runTransaction = true 를 통해 해당 changeset 을 transaction 으로 실행
   @runAlways = true 를 통해 이전에 실행된 적이 있더라도 해당 changeset 을 실행함, 원래는 같은 ID 일 때 해당 작업을 건너 뛰었음 */

-- changeset 0tae:sample runOnChange:true
-- comment: sample
DELETE from user;

INSERT INTO user(ID, AUTHORITY, USER_STRING_ID, EMAIL, PASSWORD, NAME, BIRTH, CREATED_AT, DELETED_AT)
    value (
           '123456781234567',
           'Admin',
           'choiyt3465',
           'choiyt3465@naver.com',
           'fpdltm7',
           '최용태',
           DATE('1999-06-08'),
           CURRENT_TIMESTAMP,
           null
    );