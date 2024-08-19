-- 데이터베이스 생성
create database if not exists board;
-- 데이터베이스 사용 선언
use board;

-- 테이블 생성
create table board(
	id int auto_increment primary key,
	title varchar(20) not null,
	content varchar(20) not null,
    writer varchar(20) not null,
    created_at timestamp not null default now()
);

-- 테이블 조건 확인
desc board;

-- 쿼리문
SELECT * FROM board;
SELECT count(*) FROM board;
SELECT * FROM board WHERE id = 1;
UPDATE board SET title = "1" , content = "1", writer ="1" WHERE id = 1;
UPDATE board SET title = "1" , content = "1", writer ="1" WHERE id = 1;
INSERT INTO board(title,content,writer) VALUES ("제목1","내용1","홍길동");
