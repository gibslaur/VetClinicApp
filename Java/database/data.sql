BEGIN TRANSACTION;

DROP TABLE IF EXISTS pet, customer;

CREATE TABLE pet (
pet_id SERIAL,
customer_id int,
pet_name varchar (50),
species varchar (50),
age int,
weight_lbs int,
medications varchar (300),
pet_notes varchar (500),
CONSTRAINT PK_pet PRIMARY KEY (pet_id)
);

CREATE TABLE customer (
customer_id SERIAL,
customer_name varchar (100) NOT NULL,
email varchar (150),
phone_number varchar (12) NOT NULL,
customer_notes varchar (500),
CONSTRAINT PK_customer PRIMARY KEY (customer_id)
);

ALTER TABLE pet ADD FOREIGN KEY (customer_id) REFERENCES customer(customer_id);

INSERT INTO pet (customer_id, pet_name, species, age, weight_lbs, medications, pet_notes) VALUES (1, 'Emma', 'Dog', 5, 75, 'Heartgard Plus', 'Needs dental cleaning');
INSERT INTO pet (customer_id, pet_name, species, age, weight_lbs, pet_notes) VALUES (1, 'Dexter', 'Cat', 5, 13, 'Shy, difficult to remove from carrier.');
INSERT INTO pet (customer_id, pet_name, species, age, weight_lbs) VALUES (2, 'Bandit', 'Cat', 8, 10);

INSERT INTO customer (customer_name, email, phone_number, customer_notes) VALUES ('Lauren Gibbons', 'lgibbons@example.com', '1234567890', 'Has pet insurance.');
INSERT INTO customer (customer_name, email, phone_number, customer_notes) VALUES ('Angela Martin', 'amartin@dundermifflin.com', '2345678901', 'Save Bandit!');

COMMIT TRANSACTION;
--ROLLBACK;
