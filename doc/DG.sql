﻿CREATE TABLE `TB_USER` (
	`USER_CODE`	VARCHAR(100)	NOT NULL	COMMENT '유저 코드',
	`USER_NAME`	VARCHAR(200)	NOT NULL	COMMENT '유저 이름',
	`EMAIL`	VARCHAR(200)	NOT NULL	COMMENT '이메일',
	`NICKNAME`	VARCHAR(30)	NOT NULL	COMMENT '별명',
	`PASSWORD`	VARCHAR(30)	NOT NULL	COMMENT '비밀번호',
	`MOBILE`	INT	NOT NULL	COMMENT '휴대폰',
	`TRY_COUNT`	INT	NOT NULL	DEFAULT 0	COMMENT '문제 시도 횟수',
	`SUCCESS_COUNT`	INT	NOT NULL	DEFAULT 0	COMMENT '성공 횟수',
	`REG_DATE`	DATETIME	NOT NULL	DEFAULT NOW()	COMMENT '등록일',
	`UPDT_DATE`	DATETIME	NOT NULL	DEFAULT NOW()	COMMENT '수정일'
);

CREATE TABLE `TB_PROBLEM_LIST` (
	`PROBLEM_CODE`	VARCHAR(100)	NOT NULL	COMMENT '문제 코드',
	`LANGUAGE_CODE`	VARCHAR(100)	NOT NULL	COMMENT '언어 코드',
	`USER_CODE`	VARCHAR(100)	NOT NULL	COMMENT '유저 코드',
	`LEVEL`	INT	NOT NULL	COMMENT '문제 난이도',
	`PROBLEM_TITLE`	VARCHAR(200)	NOT NULL	COMMENT '문제 제목',
	`PROBLEM_CONTENTS`	LONGTEXT	NOT NULL	COMMENT '문제 내용',
	`REG_DATE`	DATETIME	NOT NULL	DEFAULT NOW()	COMMENT '등록일',
	`UPDT_DATE`	DATETIME	NOT NULL	DEFAULT NOW()	COMMENT '수정일',
	`INPUT`	LONGTEXT	NULL	COMMENT '입력',
	`OUTPUT`	LONGTEXT	NULL	COMMENT '출력'
);

CREATE TABLE `TB_ANSWER` (
	`ANSWER_CODE`	VARCHAR(100)	NOT NULL	COMMENT '답안 코드',
	`PROBLEM_CODE`	VARCHAR(100)	NOT NULL	COMMENT '문제 코드',
	`LANGUAGE_CODE`	VARCHAR(100)	NOT NULL	COMMENT '언어 코드',
	`USER_CODE`	VARCHAR(100)	NOT NULL	COMMENT '유저 코드',
	`ANSWER`	LONGTEXT	NOT NULL	COMMENT '답안',
	`REG_DATE`	DATETIME	NOT NULL	DEFAULT NOW()	COMMENT '등록일',
	`UPDT_DATE`	DATETIME	NOT NULL	DEFAULT NOW()	COMMENT '수정일',
	`SUCCESS_YN`	VARCHAR(2)	NOT NULL	DEFAULT 'N'	COMMENT '성공 여부',
	`OPEN_YN`	VARCHAR(2)	NOT NULL	DEFAULT 'Y'	COMMENT '답안 공개 여부',
	`TIME`	BIGINT	NOT NULL	COMMENT '시간',
	`MEMORY`	BIGINT	NOT NULL	COMMENT '메모리'
);

CREATE TABLE `TB_COMMON_CODE` (
	`CODE_NAME`	VARCHAR(100)	NOT NULL	COMMENT '코드명',
	`CODE_GROUP`	VARCHAR(100)	NOT NULL	COMMENT '코드그룹',
	`CODE_DISCRIPTION`	VARCHAR(1000)	NOT NULL	COMMENT '코드설명',
	`REG_DATE`	DATETIME	NOT NULL	DEFAULT NOW()	COMMENT '등록일',
	`UPDT_DATE`	DATETIME	NOT NULL	DEFAULT NOW()	COMMENT '수정일'
);

CREATE TABLE `TB_PROBLEM_LIKE` (
	`LIKE_SEQ`	BIGINT	NOT NULL	COMMENT '좋아요번호',
	`ANSWER_CODE`	VARCHAR(100)	NOT NULL	COMMENT '답안 코드',
	`PROBLEM_CODE`	VARCHAR(100)	NOT NULL	COMMENT '문제 코드',
	`LANGUAGE_CODE`	VARCHAR(100)	NOT NULL	COMMENT '언어 코드',
	`USER_CODE`	VARCHAR(100)	NOT NULL	COMMENT '유저 코드',
	`REG_DATE`	DATETIME	NOT NULL	DEFAULT NOW()	COMMENT '등록일',
	`UPDT_DATE`	DATETIME	NOT NULL	DEFAULT NOW()	COMMENT '수정일'
);

ALTER TABLE `TB_USER` ADD CONSTRAINT `PK_TB_USER` PRIMARY KEY (
	`USER_CODE`
);

ALTER TABLE `TB_PROBLEM_LIST` ADD CONSTRAINT `PK_TB_PROBLEM_LIST` PRIMARY KEY (
	`PROBLEM_CODE`,
	`LANGUAGE_CODE`,
	`USER_CODE`
);

ALTER TABLE `TB_ANSWER` ADD CONSTRAINT `PK_TB_ANSWER` PRIMARY KEY (
	`ANSWER_CODE`,
	`PROBLEM_CODE`,
	`LANGUAGE_CODE`,
	`USER_CODE`
);

ALTER TABLE `TB_COMMON_CODE` ADD CONSTRAINT `PK_TB_COMMON_CODE` PRIMARY KEY (
	`CODE_NAME`
);

ALTER TABLE `TB_PROBLEM_LIKE` ADD CONSTRAINT `PK_TB_PROBLEM_LIKE` PRIMARY KEY (
	`LIKE_SEQ`,
	`ANSWER_CODE`,
	`PROBLEM_CODE`,
	`LANGUAGE_CODE`,
	`USER_CODE`
);

ALTER TABLE `TB_PROBLEM_LIST` ADD CONSTRAINT `FK_TB_USER_TO_TB_PROBLEM_LIST_1` FOREIGN KEY (
	`USER_CODE`
)
REFERENCES `TB_USER` (
	`USER_CODE`
);

ALTER TABLE `TB_ANSWER` ADD CONSTRAINT `FK_TB_PROBLEM_LIST_TO_TB_ANSWER_1` FOREIGN KEY (
	`PROBLEM_CODE`
)
REFERENCES `TB_PROBLEM_LIST` (
	`PROBLEM_CODE`
);

ALTER TABLE `TB_ANSWER` ADD CONSTRAINT `FK_TB_PROBLEM_LIST_TO_TB_ANSWER_2` FOREIGN KEY (
	`LANGUAGE_CODE`
)
REFERENCES `TB_PROBLEM_LIST` (
	`LANGUAGE_CODE`
);

ALTER TABLE `TB_ANSWER` ADD CONSTRAINT `FK_TB_PROBLEM_LIST_TO_TB_ANSWER_3` FOREIGN KEY (
	`USER_CODE`
)
REFERENCES `TB_PROBLEM_LIST` (
	`USER_CODE`
);

ALTER TABLE `TB_PROBLEM_LIKE` ADD CONSTRAINT `FK_TB_ANSWER_TO_TB_PROBLEM_LIKE_1` FOREIGN KEY (
	`ANSWER_CODE`
)
REFERENCES `TB_ANSWER` (
	`ANSWER_CODE`
);

ALTER TABLE `TB_PROBLEM_LIKE` ADD CONSTRAINT `FK_TB_ANSWER_TO_TB_PROBLEM_LIKE_2` FOREIGN KEY (
	`PROBLEM_CODE`
)
REFERENCES `TB_ANSWER` (
	`PROBLEM_CODE`
);

ALTER TABLE `TB_PROBLEM_LIKE` ADD CONSTRAINT `FK_TB_ANSWER_TO_TB_PROBLEM_LIKE_3` FOREIGN KEY (
	`LANGUAGE_CODE`
)
REFERENCES `TB_ANSWER` (
	`LANGUAGE_CODE`
);

ALTER TABLE `TB_PROBLEM_LIKE` ADD CONSTRAINT `FK_TB_ANSWER_TO_TB_PROBLEM_LIKE_4` FOREIGN KEY (
	`USER_CODE`
)
REFERENCES `TB_ANSWER` (
	`USER_CODE`
);
