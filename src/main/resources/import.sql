create table IF NOT EXISTS advertisers (
  id int primary key auto_increment,
  advertiserName varchar(255),
  contactName varchar(255),
  creditLimit int(10)
);