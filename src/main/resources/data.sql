-- DDL은 나눠야 좋지만 일단 그냥 ㄱㄱ
CREATE TABLE if not exists Account
(
	id int(255) NOT NULL,
	card_name VARCHAR(15) NULL,
	pin_number VARCHAR(15) NULL,
	account_number VARCHAR(15) NULL,
	money VARCHAR(15) NULL,
	account_type VARCHAR(15) NULL
);

--원래는 flyway를 쓰는게 적절함.
INSERT INTO Account (id, card_name, pin_number, account_number, money, account_type) VALUES
(1, 'hanaCard', 'password', '12341234', '10000', '1'),
(2, 'wooriCard', '1234', '344565667', '400000', '2'),
(3, 'BCCard', '0000', '778687887', '800000', '2'),
(4, 'KBCard', '1111', '1234', '200', '2'),
(5, 'HDCard', '1123', '2332', '0', '1'),
(6, 'GGCard', 'pass', '5687547845679', '7000', '1');
