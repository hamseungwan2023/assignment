# DB 설계
```sql

-- user 테이블 생성
CREATE TABLE db_demo.user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(20) NOT NULL
);

-- authorities 테이블 생성
CREATE TABLE db_demo.authorities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    authority_name VARCHAR(20) NOT NULL
);

-- user_authorities 테이블 생성
CREATE TABLE db_demo.user_authorities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    authority_id BIGINT NOT NULL,

    CONSTRAINT fk_user_user_authorities FOREIGN KEY (user_id) REFERENCES db_demo.user(id),
    CONSTRAINT fk_authority_user_authorities FOREIGN KEY (authority_id) REFERENCES db_demo.authorities(id)
);

INSERT INTO db_demo.authorities (authority_name) VALUES ('ROLE_USER');
INSERT INTO db_demo.authorities (authority_name) VALUES ('ROLE_ADMIN');
```
## 회원가입 기능

![image](https://github.com/user-attachments/assets/13736a5c-df57-4a4e-bc71-1d787f36e720)


## 로그인 기능
![image](https://github.com/user-attachments/assets/c366bb23-cfa2-442f-8b6c-39516cb4dc61)
