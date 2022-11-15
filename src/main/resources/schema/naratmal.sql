DROP TABLE answer;
DROP TABLE question;
DROP TABLE review;
DROP TABLE review_state;
DROP TABLE cart;
DROP TABLE ORDER_LINE;
DROP TABLE orders;
DROP TABLE ORDER_STATE;
DROP TABLE goods;
DROP TABLE goods_class;
DROP TABLE goods_state;
DROP TABLE users;

DROP SEQUENCE goods_id_seq;
DROP SEQUENCE order_id_seq;
DROP SEQUENCE order_line_id_seq;
DROP SEQUENCE cart_id_seq;
DROP SEQUENCE review_id_seq;
DROP SEQUENCE question_id_seq;
DROP SEQUENCE answer_id_seq;

CREATE TABLE users(
	user_id	varchar2(30)	primary key,
	user_name	VARCHAR2(15)		NOT NULL,
	user_password	varchar2(255)		NOT NULL,
	user_tel	varchar2(11)		NOT NULL,
	zipcode	varchar2(5)		NOT NULL,
	addr	varchar2(100)		NOT NULL,
	addr_detail	varchar2(100)		NOT NULL,
	user_quit	varchar2(2)		DEFAULT 'F' NOT NULL check(user_quit in ('F', 'T')),
	user_insert_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL,
	user_update_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL
);

insert into users values('yuda', '김유다', '0000', '01011112222', '03054', '서울 종로구 청와대로 73', '00000', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('hyun', '김유현', '0000', '01012341234', '06035', '서울 강남구 가로수길 5', '156', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('test', '테스트', '0000', '01026262626', '26494', '강원 원주시 흥업면 분지동길 27-8', '651-156', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('sion', '이시온', '0000', '01045674567', '25630', '강원 강릉시 강동면 오이성황길 1-2', '262', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('maca', '마카롱', '0000', '01091919191', '15880', '경기 군포시 군포첨단산업2로8번길 1', '1468-1515', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('mina', '박민아', '0000', '01099999999', '15888', '경기 군포시 건건로 237-2', '1515호', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('rumi', '이루미', '0000', '01011111111', '54028', '전북 군산시 미원로 109', '15동 156호', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('aeri', '정애리', '0000', '01066666666', '63534', '제주특별자치도 서귀포시 가가로 14', '156-156', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('eunh', '김은하', '0000', '01045615665', '18148', '경기 오산시 부산중앙로 11', '684', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('uzin', '오유진', '0000', '01084456469', '06232', '서울 강남구 강남대로 390', '56875', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('admin', '관리자', '0000', '01000000000', '13536', '경기 성남시 분당구 판교역로 4', '00000', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('blue', '김파랑', '0000', '01015615615', '31581', '충남 아산시 고불로 651-32', '156번지', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('redd', '김빨강', '0000', '01059748412', '13473', '경기 성남시 분당구 경부고속도로 409', '394호', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('domi', '도미솔', '0000', '01016164724', '13487', '경기 성남시 분당구 대왕판교로 579', '1층 2호', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('dodo', '김도도', '0000', '01094513462', '11126', '경기 포천시 영중면 가영로 553-66', '256', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('nara', '한나라', '0000', '01065156219', '05291', '서울 강동구 천호대로213길 14', '456-156', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('kiki', '김키키', '0000', '01091573296', '26392', '강원 원주시 능라동길 7', '614', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('toto', '김토토', '0000', '01091465129', '24664', '강원 인제군 상남면 서울양양고속도로 109', '2156번지', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('momo', '이모모', '0000', '01091436621', '06036', '서울 강남구 가로수길 12', '1층 56호', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('jiji', '이지은', '0000', '01019561556', '06034', '서울 강남구 가로수길 31 (선빌딩)', '946', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('sunh', '이선희', '0000', '01019351568', '25162', '강원 홍천군 내촌면 서울양양고속도로 94', '1568-556', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('moaa', '김모아', '0000', '01095674515', '24664', '강원 인제군 상남면 서울양양고속도로 112', '1-256', 'F', SYSTIMESTAMP, SYSTIMESTAMP);

CREATE TABLE goods_state (
	goods_state_id	number		primary key,
	goods_state_name	varchar2(30)		not NULL
);

insert into goods_state values(1, '판매 예정');
insert into goods_state values(2, '판매중');
insert into goods_state values(3, '일시 품절');
insert into goods_state values(4, '단종');

CREATE TABLE goods_class (
	goods_class_id	number		primary key,
	goods_class_name	varchar2(30)		not NULL
);

insert into goods_state values(1, '의류');
insert into goods_state values(2, '잡화');
insert into goods_state values(3, '도서');

CREATE TABLE goods (
	goods_id	number		primary key,
	goods_class_id	number		REFERENCES goods_class(goods_class_id)  not null,
	goods_state_id	number		default 1    REFERENCES goods_state(goods_state_id)  not null,
	goods_name	varchar2(100)		not NULL,
	goods_detail	varchar2(3000)		not NULL,
	goods_thumbnail	varchar2(200)		not NULL,
	goods_price	number		not NULL,
	goods_insert_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL,
	goods_update_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL
);
create sequence goods_id_seq;

CREATE TABLE ORDER_STATE (
	ORDER_STATE_id	number		PRIMARY KEY,
	ORDER_STATE_name	varchar2(30)		NOT NULL
);

CREATE TABLE orders (
	order_id	NUMBER		PRIMARY KEY,
	user_id	varchar2(30)		NOT NULL    REFERENCES users(user_ID),
	ORDER_STATE_id	number		DEFAULT 1 NOT NULL    REFERENCES order_state(order_state_ID),
	total_price	NUMBER		NOT NULL,
	order_memo	varchar2(300)		NULL,
	order_insert_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL,
	order_update_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL
);
create sequence order_id_seq;

CREATE TABLE ORDER_LINE (
	ORDER_LINE_id	number		primary key,
	order_line_qty	number		not NULL,
	price_qty	number		not NULL,
	order_id	NUMBER		REFERENCES orders(order_ID) NOT NULL,
	goods_id	number		REFERENCES goods(goods_ID) NOT NULL,
	order_line_insert_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL,
	order_line_update_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL
);
create sequence order_line_id_seq;

CREATE TABLE cart (
	cart_id	number		primary key,
	cart_qty	number		not NULL,
	user_id	varchar2(30)		REFERENCES users(user_ID) NOT NULL,
	goods_id	number		REFERENCES goods(goods_ID) NOT NULL,
	cart_insert_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL,
	cart_update_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL
);
create sequence cart_id_seq;

CREATE TABLE review_state (
	review_state_id	number		primary key,
	review_state_name	varchar2(30)		not NULL
);

CREATE TABLE review (
	review_id	number		primary key,
	ORDER_LINE_id	number		REFERENCES order_line(order_line_ID) not null   unique,
    goods_id    number      REFERENCES goods(goods_ID) not null,
	user_id	varchar2(30)		REFERENCES users(user_ID) not null,
	review_content	varchar2(3000)		not NULL,
	review_rate	number		not NULL,
    review_picture  varchar2(100),
	review_insert_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL,
	review_update_date	timestamp		DEFAULT SYSTIMESTAMP NOT NULL,
	review_state_id	number		NOT NULL
);
create sequence review_id_seq;

CREATE TABLE question (
	question_id	number		primary key,
	user_id	varchar2(30)		REFERENCES users(user_ID) not null,
	question_title	varchar2(100)		not NULL,
	question_content	varchar2(3000)		not NULL,
	question_insert_date	timestamp		DEFAULT systimestamp NOT NULL,
	question_update_date	timestamp		DEFAULT systimestamp NOT NULL,
	question_picture	varchar2(100)		NULL,
	answered_state	varchar2(2)		DEFAULT 'F' NOT NULL check(answered_state in ('F', 'T'))
);
create sequence question_id_seq;

CREATE TABLE answer (
	answer_id	number		primary key,
	question_id	number		REFERENCES question(question_ID)    NOT NULL,
	answer_content	varchar2(3000)		not NULL,
	answer_insert_date	timestamp		DEFAULT systimestamp NOT NULL,
	answer_update_date	timestamp		DEFAULT systimestamp NOT NULL,
	answer_picture	varchar2(100)		NULL
);

create sequence answer_id_seq;