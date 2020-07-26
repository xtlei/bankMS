CREATE TABLE `administrator` (
  `adminNumber` varchar(20) NOT NULL,
  `adminPwd` varchar(20) NOT NULL,
  `adminName` varchar(18) NOT NULL,
  PRIMARY KEY (`adminNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `business` (
  `businessNumber` int(20) NOT NULL AUTO_INCREMENT,
  `custNumber` varchar(20) NOT NULL,
  `businessType` varchar(3) NOT NULL,
  `businessMoney` double(9,0) NOT NULL,
  `businessDate` datetime NOT NULL,
  PRIMARY KEY (`businessNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;


CREATE TABLE `customer` (
  `custNumber` varchar(20) NOT NULL,
  `custName` varchar(20) NOT NULL,
  `custPwd` varchar(6) NOT NULL,
  `custIdCard` varchar(18) NOT NULL,
  `custMoney` double(9,2) NOT NULL DEFAULT '0.00',
  `custDate` datetime NOT NULL,
  PRIMARY KEY (`custNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;