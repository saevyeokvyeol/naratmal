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

CREATE TABLE goods_state (
	goods_state_id	number		primary key,
	goods_state_name	varchar2(30)		not NULL
);

CREATE TABLE goods_class (
	goods_class_id	number		primary key,
	goods_class_name	varchar2(30)		not NULL
);

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