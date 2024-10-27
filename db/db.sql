drop database if exists `royal-market-web`;

create database `royal-market-web`;

use `royal-market-web`

create table clients(
  id int not null auto_increment primary key,
  identification varchar(255) not null unique,
  name varchar(255) not null,
  balance decimal(10,2) not null,
  active boolean default true
);
create table products(
  id int not null auto_increment primary key,
  name varchar(255) not null unique,
  stock int not null,
  price decimal(10,2) not null,
  active boolean default true
);
create table providers(
  id int not null auto_increment primary key,
  name varchar(255) not null unique,
  active boolean default true
);
create table providers_products(
  provider_id int not null,
  product_id int not null,
  foreign key (provider_id) references providers(id),
  foreign key (product_id) references products(id)
);
create table sales(
  id int not null auto_increment primary key,
  total_cost decimal(10,2) not null default 0.00,
  date timestamp default current_timestamp,
  client_id int not null,
  active boolean default true,
  foreign key (client_id) references clients(id)
);
create table sale_lines(
  sale_id int not null,
  product_id int not null,
  product_quantity int not null,
  product_price decimal(10,2) not null,
  foreign key (sale_id) references sales(id),
  foreign key (product_id) references products(id)
);
create table warehouses(
  id int not null auto_increment primary key,
  address varchar(255) not null unique,
  active boolean default true
);
create table workers(
  id int not null auto_increment primary key,
  identification varchar(255) not null unique,
  name varchar(255) not null,
  salary decimal(10,2) not null default 0,
  active boolean default true
);

-- Test values
insert into warehouses (address) values ('Street 1 # 2 - 3');
insert into warehouses (address) values ('Street 4 # 5 - 6');

insert into clients (identification, name, balance) values ('123456789', 'John Doe', 1000.00);
insert into clients (identification, name, balance) values ('1234567890', 'Jane Dao', 2000.00);

insert into products (name, stock, price) values ('Product 1', 100, 100.00);
insert into products (name, stock, price) values ('Product 2', 200, 200.00);

insert into providers (name) values ('Provider 1');
insert into providers (name) values ('Provider 2');

insert into workers (identification, name, salary) values ('123456789', 'John Doe', 1000.00);
insert into workers (identification, name, salary) values ('1234567890', 'Jane Dao', 2000.00);

insert into sales (total_cost, client_id) values (1000.00, 1);
insert into sales (total_cost, client_id) values (2000.00, 2);

insert into sale_lines (sale_id, product_id, product_quantity, product_price) values (1, 1, 10, 100.00);
insert into sale_lines (sale_id, product_id, product_quantity, product_price) values (2, 2, 10, 200.00);

insert into providers_products (provider_id, product_id) values (1, 1);
insert into providers_products (provider_id, product_id) values (2, 2);