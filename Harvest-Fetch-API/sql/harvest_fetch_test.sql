drop database if exists harvest_fetch_test;
create database harvest_fetch_test;
use harvest_fetch_test;

create table app_user (
	user_id int primary key auto_increment,
    user_name varchar(255) not null,
    password_hash varchar(40) not null,
    first_name varchar(25) not null,
    last_name varchar(25) not null,
    street_address varchar(40) not null,
    zip_code varchar(10) not null,
    city varchar(50) not null,
    state varchar(2) not null,
    email varchar(255) not null,
    phone varchar(15) not null,
    photo_url varchar(1026)
);


create table farmer (
	farmer_id int primary key auto_increment,
    farm_name varchar(50) not null,
    details varchar(1024) not null,
    user_id int not null,
    constraint fk_farmer_id
		foreign key (user_id)
        references app_user(user_id)
);

create table product (
	product_id int primary key auto_increment,
    farmer_id int not null,
    product_name varchar(50) not null,
    price decimal(5,2) not null,
    organic boolean DEFAULT false,
    constraint fk_product_id
		foreign key (farmer_id)
        references farmer(farmer_id)
);

create table orders (
	order_id int primary key auto_increment,
    order_date date not null,
    order_total decimal(7,2) not null,
    user_id int not null,
    constraint fk_order_id
		foreign key (user_id)
        references app_user(user_id)
);

create table order_item (
	order_item_id int primary key auto_increment,
    order_id int not null,
    quantity int not null,
    farmer_id int not null,
    product_id int not null,
    constraint fk_order_item_id
		foreign key (order_id)
        references orders(order_id),
		foreign key (farmer_id)
        references farmer(farmer_id),
        foreign key (product_id)
        references product(product_id)
);

create table app_role (
	app_role_id int primary key auto_increment,
    name varchar(25) not null
);

create table app_user_role (
	app_user_role_id int primary key auto_increment,
    app_role_id int not null,
    app_user_id int not null,
    constraint fk_app_user_id
		foreign key (app_role_id)
        references app_role(app_role_id),
        foreign key (app_user_id)
        references app_user(user_id)
);