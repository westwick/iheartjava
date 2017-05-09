CREATE TABLE `customers` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50),
	`contactName` VARCHAR(50),
	`creditLimit` INTEGER,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB; 