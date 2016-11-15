
create database i80;
use i80;

create table Lead(
	leadId int NOT NULL AUTO_INCREMENT, 
	courseName varchar(200), 
	leadName varchar(200),
	leadEmail varchar(120),
	leadMobile varchar(20),
	
	PRIMARY KEY (leadId)
) AUTO_INCREMENT=1; 