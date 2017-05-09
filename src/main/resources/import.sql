create table IF NOT EXISTS customers (
  id int primary key auto_increment,
  customerName varchar(255),
  contactName varchar(255),
  creditLimit int(10)
);