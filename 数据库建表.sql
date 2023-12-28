create database design;
use design;
show variables like '%char%';

CREATE TABLE `design`.`admin` (
  `adminId` INT NOT NULL AUTO_INCREMENT,
  `adminName` VARCHAR(30) NOT NULL,
  `adminPassword` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`adminId`, `adminName`),
  UNIQUE INDEX `adminId_UNIQUE` (`adminId` ASC) VISIBLE,
  UNIQUE INDEX `adminName_UNIQUE` (`adminName` ASC) VISIBLE);
  
CREATE TABLE `design`.`role` (
  `roleId` INT NOT NULL AUTO_INCREMENT,
  `roleName` VARCHAR(30) NOT NULL,
  `rolePassword` VARCHAR(30) NOT NULL,
  `roleRemark` VARCHAR(255) NOT NULL,
  `roleTel` INT(11) NOT NULL,
  PRIMARY KEY (`roleId`, `roleName`),
  UNIQUE INDEX `roleId_UNIQUE` (`roleId` ASC) VISIBLE,
  UNIQUE INDEX `roleName_UNIQUE` (`roleName` ASC) VISIBLE);
  
CREATE TABLE `design`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(30) NOT NULL,
  `userPassword` VARCHAR(30) NOT NULL,
  `userSid` INT(11) NOT NULL,
  `userEmail` VARCHAR(30) NULL,
  `userTel` INT(11) NOT NULL,
  `userIdentityCard` VARCHAR(45) NOT NULL,
  `userIntroduction` VARCHAR(255) NULL,
  PRIMARY KEY (`userId`, `userName`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC) VISIBLE,
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE,
  UNIQUE INDEX `userSid_UNIQUE` (`userSid` ASC) VISIBLE);
  
CREATE TABLE `design`.`activity` (
  `activityId` INT NOT NULL AUTO_INCREMENT,
  `activityName` VARCHAR(45) NOT NULL,
  `isPassed` INT NOT NULL,
  `startTime` DATETIME NOT NULL,
  `endTime` DATETIME NOT NULL,
  `peopleCountMax` INT(6) NOT NULL,
  `peopleCountCurrent` INT(6) NOT NULL,
  `requirement` VARCHAR(255) NOT NULL,
  `activityIntroduction` VARCHAR(255) NULL,
  PRIMARY KEY (`activityId`, `activityName`),
  UNIQUE INDEX `activityId_UNIQUE` (`activityId` ASC) VISIBLE,
  UNIQUE INDEX `activityName_UNIQUE` (`activityName` ASC) VISIBLE);
  
  CREATE TABLE `design`.`applications` (
  `applicationId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(30) NOT NULL,
  `activityName` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`applicationId`),
  UNIQUE INDEX `applicationId_UNIQUE` (`applicationId` ASC) VISIBLE);
  
  
INSERT INTO `design`.`admin` (`adminId`, `adminName`, `adminPassword`) VALUES (0, 'admin0', '0');
INSERT INTO `design`.`role` (`roleId`, `roleName`, `rolePassword`, `roleRemark`, `roleTel`) VALUES (0, 'role0', '0', '负责人0', 1391391391);
INSERT INTO `design`.`user` (`userId`, `userName`, `userPassword`, `userSid`, `userEmail`, `userTel`, `userIdentityCard`, `userIntroduction`) VALUES ('0', 'lwl', '123', '312100358', '123@qq.com', '1391391391', '4406022003', '社员lwl');
INSERT INTO `design`.`activity` (`activityId`, `activityName`, `isPassed`, `startTime`, `endTime`, `peopleCountMax`, `peopleCountCurrent`, `requirement`, `activityIntroduction`) VALUES (null, '应急教学演讲', '1', '2023-12-01 00:00:00', '2023-12-02 00:00:00', '100', '0', '风雨体育馆', '无');
INSERT INTO `design`.`activity` (`activityId`, `activityName`, `isPassed`, `startTime`, `endTime`, `peopleCountMax`, `peopleCountCurrent`, `requirement`, `activityIntroduction`) VALUES (null, '海姆克里法演示', '0', '2023-12-10 00:00:00', '2023-12-11 00:00:00', '50', '0', '操场', '无');
INSERT INTO `design`.`activity` (`activityId`, `activityName`, `isPassed`, `startTime`, `endTime`, `peopleCountMax`, `peopleCountCurrent`, `requirement`, `activityIntroduction`) VALUES (null, '止血急救讲座', '1', '2023-12-15 00:00:00', '2023-12-16 00:00:00', '80', '0', '报告厅', '演示止血操作');
