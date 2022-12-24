CREATE TABLE `Department` (
  `DepartmentId` int PRIMARY KEY,
  `Department_Name` varchar(20) NOT NULL,
  `Location` varchar(60)
);

CREATE TABLE `Admin` (
  `Id` int UNIQUE PRIMARY KEY AUTO_INCREMENT,
  `Name` varchar(30),
  `Post` varchar(30),
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
);

CREATE TABLE `Employee` (
  `EmployeeId` int PRIMARY KEY AUTO_INCREMENT,
  `Name` varchar(30),
  `Age` int,
  `Email` varchar(40),
  `Address` varchar(60),
  `Phone_Number` bigint(10),
  `Salary` int,
  `DepartmentId` int,
  `Username` varchar(30),
  `Password` varchar(20),
  `Working_Status` varchar(40),
  `Leave_Request` varchar(20),
  `Joining_Date` date
);

CREATE TABLE `Leaves` (
  `EmployeeId` int UNIQUE NOT NULL,
  `Name` varchar(30),
  `DepartmentId` int,
  `Duration` int,
  `StartDate` date,
  `EndDate` date,
  `Leave_Request` varchar(20)
);

ALTER TABLE `Employee` ADD FOREIGN KEY (`DepartmentId`) REFERENCES `Department` (`DepartmentId`);

ALTER TABLE `Leaves` ADD FOREIGN KEY (`EmployeeId`) REFERENCES `Employee` (`EmployeeId`);

ALTER TABLE `Leaves` ADD FOREIGN KEY (`DepartmentId`) REFERENCES `Department` (`DepartmentId`);

insert into admin(name,post,username,password) values('Shubham singh','Manager','shubham','mp21mk');
