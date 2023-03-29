drop database if exists harvest_fetch_test;
create database harvest_fetch_test;
use harvest_fetch_test;

create table app_user (
	user_id int primary key auto_increment,
    user_name varchar(255) not null unique,
    password_hash varchar(1024) not null,
    first_name varchar(25) not null,
    last_name varchar(25) not null,
    street_address varchar(255) not null,
    zip_code varchar(10) not null,
    city varchar(50) not null,
    state varchar(2) not null,
    email varchar(255) not null unique,
    phone varchar(15) not null,
    photo_url varchar(1026)
);


create table farmer (
	farmer_id int primary key auto_increment,
    farm_name varchar(50) not null,
    farm_photo_url varchar(450) not null,
    details varchar(1024) not null,
    user_id int not null unique,
    constraint fk_farmer_id
		foreign key (user_id)
        references app_user(user_id)
);

create table product (
	product_id int primary key auto_increment,
    product_name varchar(50) not null
);

create table farmer_product (
	farmer_id int not null,
    product_id int not null,
    price decimal(5,2) not null,
    organic boolean DEFAULT false,
    constraint pk_farmer_product
        primary key (farmer_id, product_id),
    constraint fk_farmer_product_farmer_id
        foreign key (farmer_id)
        references farmer(farmer_id),
    constraint fk_farmer_product_product_id
        foreign key (product_id)
        references product(product_id)
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

delimiter //
create procedure set_known_good_state()
begin
	delete from farmer_product;
    delete from product;
	delete from farmer;
	delete from app_user;
    
	insert into app_user(user_id, user_name, password_hash, first_name, last_name, street_address, zip_code, city, state, email, phone, photo_url) values
		(1, "testone", "testone", "Jon", "Doe", "1000 South Cooper", 38104, "Memphis", "TN", "test1@testemail.com", "9015551234", ""),
        (2, "testtwo", "testone", "Joan", "Dangle", "3216 Pershing Ave", 38112, "Memphis", "TN", "test2@testemail.com", "9015552345", ""),
        (3, "testthree", "testone", "Mike", "Hall", "3050 Woodhills Dr", 38128, "Memphis", "TN", "test3@testemail.com", "9015553456", ""),
        (4, "testfour", "testone", "Jack", "Parrish", "8605 East Kerrville-Roasemark Road", 38053, "Millington", "TN", "test4@testemail.com", "9015554567", ""),
        (5, "testfive", "testone", "Rick", "Frost", "7422 Ward Road", 38053, "Millington", "TN", "test5@testemail.com", "9015555678", "");
        
	insert into farmer(farmer_id, farm_name, farm_photo_url, details, user_id) values
		(1, "MidSouth Farm", "https://images.pexels.com/photos/5848486/pexels-photo-5848486.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Farm in the Mid-South", 1),
        (2, "Bluff City Farm", "https://images.pexels.com/photos/235725/pexels-photo-235725.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Farm in the Mid-South", 2),
        (3, "Memphis Farm", "https://images.pexels.com/photos/1112080/pexels-photo-1112080.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Farm in the Mid-South", 3),
        (4, "Blues Farm", "https://images.pexels.com/photos/195226/pexels-photo-195226.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Farm in the Mid-South", 4),
        (5, "Cotton King Farm","https://images.pexels.com/photos/1486976/pexels-photo-1486976.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Farm in the Mid-South", 5);
        
	insert into product(product_id, product_name) values
		(1, "Broccoli"),
        (2, "Asparagus"),
        (3, "Kale"),
        (4, "Collard Greens"),
        (5, "Mustard Greens"),
        (6, "Turnip Greens"),
        (7, "Pumpkin"),
        (8, "Milk"),
        (9, "Goat Cheese"),
        (10, "Flank Steak");
        
	insert into farmer_product(farmer_id, product_id, price, organic) values
		(1, 1, 1.97, true),
        (1, 3, 0.46, true),
        (1, 4, 2.38, true),
        (2, 1, 2.19, true),
        (2, 5, 1.99, true),
        (3, 2, 1.65, true),
        (3, 8, 3.87, true),
        (3, 9, 12.19, true),
        (4, 2, 1.67, true),
        (4, 6, 2.18, true),
        (4, 7, 2.35, true),
        (5, 4, 1.88, true),
        (5, 10, 11.88, true);
        
end //
delimiter ;

set sql_safe_updates = 0;
call set_known_good_state();
set sql_safe_updates = 1;

select * from app_user;

select * from farmer;

select * from product;

select
	farmer.farmer_id,
    farmer.farm_name,
    product.product_id,
    product.product_name,
    farmer_product.price,
    farmer_product.organic
from farmer_product
left outer join farmer on farmer_product.farmer_id = farmer.farmer_id
right outer join product on farmer_product.product_id = product.product_id
order by farmer.farmer_id;

        
        
        
        