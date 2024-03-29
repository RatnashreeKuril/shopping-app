drop table purchase_order_item;
drop table purchase_order;
drop table available_coupon;
drop table product;
drop table coupon;
create table if not exists product
(
code bigint primary key auto_increment,
name char(50) not null unique,
price decimal(10,2) not null,
available_quantity bigint not null
)engine=InnoDB;
create table if not exists user
(
id bigint primary key auto_increment,
name char(50) not null,
email_id char(50) not null unique,
password varchar(100) not null,
password_key varchar(100) not null,
date_of_registration date not null
)engine=InnoDB;

create table if not exists administrator
(
username char(15) primary key,
password varchar(100) not null,
password_key varchar(100) not null
)engine=InnoDB;

create table if not exists coupon
(
code bigint primary key auto_increment,
name varchar(30) not null,
discount bigint not null
)engine=InnoDB;

create table if not exists purchase_order
(
id bigint primary key auto_increment,
order_date date not null,
user_id bigint not null,
total_amount decimal(10,2) not null,
coupon_code bigint not null,
foreign key (user_id) references user(id),
foreign key (coupon_code) references coupon(code)
)engine=InnoDB;

create table if not exists purchase_order_item
(
order_id bigint,
product_code bigint,
quantity int not null,
price decimal(10,2) not null,
primary key(order_id,product_code),
foreign key (order_id) references purchase_order(id),
foreign key (product_code) references product(code)
)engine=InnoDB;
create table if not exists transaction
(
id bigint primary key auto_increment,
order_id bigint not null,
status bool not null,
foreign key (order_id) references purchase_order(id)
)engine=InnoDB;


create table if not exists available_coupon
(
user_id bigint,
coupon_code bigint,
is_available bool not null,
primary key(user_id,coupon_code),
foreign key (user_id) references user(id),
foreign key (coupon_code) references coupon(code)
)engine=InnoDB;