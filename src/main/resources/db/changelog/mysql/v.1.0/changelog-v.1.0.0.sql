-- liquibase formatted sql logicalFilePath:assignment2/changelog/mysql/v1.0/v.1.0.1.sql

/* @runOnChange = true 를 통해 changeset 에 대한 직접적인 수정사항 발생 시 일어나는 MD5 체크섬 오류를 Disable 할 수 있음.
   이는 언제든지 바뀔 수 있다는 것을 의미
   @runTransaction = true 를 통해 해당 changeset 을 transaction 으로 실행
   @runAlways = true 를 통해 이전에 실행된 적이 있더라도 해당 changeset 을 실행함, 원래는 같은 ID 일 때 해당 작업을 건너 뛰었음 */

-- changeset 0tae:user-1-create_table labels:v.1.0,1.0.0,init
-- comment: init : 테이블 생성 및 제약조건 추가
CREATE TABLE user
(
    id             INT PRIMARY KEY,
    authority      VARCHAR(10) NOT NULL,
    user_string_id VARCHAR(12) NOT NULL,
    email          VARCHAR(20) NOT NULL,
    password       VARCHAR(20) NOT NULL,
    name           VARCHAR(12) NOT NULL,
    birth          DATE        NOT NULL,
    email_verified  BOOLEAN DEFAULT false,
    created_at     TIMESTAMP          NOT NULL,
    deleted_at     TIMESTAMP
);

-- changeset 0tae:post-1-create_table labels:v.1.0,1.0.0,init
-- comment: init : 테이블 생성 및 제약조건 추가
CREATE TABLE post
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    content       VARCHAR(5000) NOT NULL,
    title         VARCHAR(12) NOT NULL DEFAULT '(제목 없음)',
    liked         INT         DEFAULT 0,
    has_watched   INT         DEFAULT 0,
    visible       BOOLEAN     DEFAULT true,

    user_id       VARCHAR(80) REFERENCES user (id),

    posted_time   TIME          NOT NULL,
    posted_date   DATE          NOT NULL,
    created_at     TIMESTAMP          NOT NULL,
    deleted_at     TIMESTAMP
);

-- changeset 0tae:comment-1-create_table labels:v.1.0,1.0.0,init
-- comment: init : 테이블 생성 및 제약조건 추가
CREATE TABLE comment
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    content        VARCHAR(5000) NOT NULL,
    liked          INT DEFAULT 0,

    user_id        VARCHAR(80) REFERENCES user (id),
    post_id        INT REFERENCES post (id),

    commented_time TIME          NOT NULL,
    commented_date DATE          NOT NULL,
    created_at     TIMESTAMP          NOT NULL,
    deleted_at     TIMESTAMP
);

-- changeset 0tae:user-2-fix labels:v.1.0,1.0.0,init
-- comment: fix : user의 ID를 UUID로 변환, VARCHAR로 변경
ALTER TABLE user MODIFY COLUMN id VARCHAR(80);