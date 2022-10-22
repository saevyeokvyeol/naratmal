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

insert into users values('yuda', '������', '0000', '01011112222', '03054', '���� ���α� û�ʹ�� 73', '00000', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('hyun', '������', '0000', '01012341234', '06035', '���� ������ ���μ��� 5', '156', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('test', '�׽�Ʈ', '0000', '01026262626', '26494', '���� ���ֽ� ����� �������� 27-8', '651-156', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('sion', '�̽ÿ�', '0000', '01045674567', '25630', '���� ������ ������ ���̼�Ȳ�� 1-2', '262', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('maca', '��ī��', '0000', '01091919191', '15880', '��� ������ ����÷�ܻ��2��8���� 1', '1468-1515', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('mina', '�ڹξ�', '0000', '01099999999', '15888', '��� ������ �ǰǷ� 237-2', '1515ȣ', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('rumi', '�̷��', '0000', '01011111111', '54028', '���� ����� �̿��� 109', '15�� 156ȣ', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('aeri', '���ָ�', '0000', '01066666666', '63534', '����Ư����ġ�� �������� ������ 14', '156-156', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('eunh', '������', '0000', '01045615665', '18148', '��� ����� �λ��߾ӷ� 11', '684', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('uzin', '������', '0000', '01084456469', '06232', '���� ������ ������� 390', '', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('admin', '������', '0000', '01000000000', '13536', '��� ������ �д籸 �Ǳ����� 4', '00000', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('blue', '���Ķ�', '0000', '01015615615', '31581', '�泲 �ƻ�� ��ҷ� 651-32', '156����', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('redd', '�軡��', '0000', '01059748412', '13473', '��� ������ �д籸 ��ΰ�ӵ��� 409', '394ȣ', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('domi', '���̼�', '0000', '01016164724', '13487', '��� ������ �д籸 ����Ǳ��� 579', '1�� 2ȣ', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('dodo', '�赵��', '0000', '01094513462', '11126', '��� ��õ�� ���߸� ������ 553-66', '256', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('nara', '�ѳ���', '0000', '01065156219', '05291', '���� ������ õȣ���213�� 14', '456-156', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('kiki', '��ŰŰ', '0000', '01091573296', '26392', '���� ���ֽ� �ɶ󵿱� 7', '614', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('toto', '������', '0000', '01091465129', '24664', '���� ������ �󳲸� �������ӵ��� 109', '2156����', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('momo', '�̸��', '0000', '01091436621', '06036', '���� ������ ���μ��� 12', '1�� 56ȣ', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('jiji', '������', '0000', '01019561556', '06034', '���� ������ ���μ��� 31 (������)', '946', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('sunh', '�̼���', '0000', '01019351568', '25162', '���� ȫõ�� ���̸� �������ӵ��� 94', '1568-556', 'F', SYSTIMESTAMP, SYSTIMESTAMP);
insert into users values('moaa', '����', '0000', '01095674515', '24664', '���� ������ �󳲸� �������ӵ��� 112', '1-256', 'F', SYSTIMESTAMP, SYSTIMESTAMP);

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