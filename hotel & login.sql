
DROP DATABASE IF EXISTS hotel;
CREATE DATABASE hotel;
USE hotel;


CREATE TABLE Customer(
	CustID VARCHAR(6) NOT NULL,
	CustTitle VARCHAR(5),
	CustName VARCHAR(30) NOT NULL,
    NIC VARCHAR(12) UNIQUE NOT NULL,
	DOB DATE,
	MobileNumber VARCHAR(12),
	CustAddress VARCHAR(30),
	City VARCHAR(20),
	Province VARCHAR(20),
	PostalCode INT(9),
	CONSTRAINT PRIMARY KEY (CustID)
);

CREATE TABLE Reservation (
    ReservationID VARCHAR(6) NOT NULL,
    ReservationDate DATETIME NOT NULL,
    CancellationDeadline DATETIME NOT NULL,
    CustID VARCHAR(6) NOT NULL,
    CONSTRAINT PRIMARY KEY (ReservationID),
    CONSTRAINT FOREIGN KEY (CustID) REFERENCES Customer (CustID)
    ON UPDATE CASCADE ON DELETE CASCADE
);

DELIMITER //
CREATE TRIGGER SetDefaultDates
BEFORE INSERT ON Reservation
FOR EACH ROW
BEGIN
    SET NEW.ReservationDate = COALESCE(NEW.ReservationDate, NOW());
    SET NEW.CancellationDeadline = COALESCE(NEW.CancellationDeadline, NOW() + INTERVAL 1 DAY);
END//
DELIMITER ;

CREATE TABLE Room_Category (
    CategoryID VARCHAR(6) NOT NULL,
    PackageName VARCHAR(50) NOT NULL,
    PackagePrice DECIMAL(7,2) NOT NULL,
    CONSTRAINT PRIMARY KEY (CategoryID)
);

CREATE TABLE Room (
    RoomID VARCHAR(6) NOT NULL,
    CategoryID VARCHAR(6) NOT NULL,
    Quantity INT NOT NULL,
    CONSTRAINT PRIMARY KEY (RoomID),
    CONSTRAINT FOREIGN KEY (CategoryID) REFERENCES Room_Category(CategoryID)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Reservation_Detail(
	ReservationID VARCHAR(6) NOT NULL,
    RoomID VARCHAR(6) NOT NULL,
	ReservationQty INT(5) NOT NULL,
	Discount INT(2),
	CONSTRAINT PRIMARY KEY (ReservationID,RoomID),
	CONSTRAINT FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY (RoomID) REFERENCES Room(RoomID)
	ON UPDATE CASCADE ON DELETE CASCADE
);




INSERT INTO Customer VALUES('C001','Mr','Danapala','96742826V','1981-2-6','0763424457','No.20 Walana','Panadura','Western',12500);
INSERT INTO Customer VALUES('C002','Ms','Kumari','87654321V','1975-05-12','0771234567','No.10 Main St','Colombo','Western',15000);
INSERT INTO Customer VALUES('C003','Mr','Silva','90567483V','1988-11-25','0712345678','No.5 First Lane','Kandy','Central',18000);
INSERT INTO Customer VALUES('C004','Ms','Perera','83245678V','1990-07-30','0768765432','No.15 Lake Rd','Galle','Southern',13500);
INSERT INTO Customer VALUES('C005','Mr','Fernando','97834567V','1983-04-18','0709876543','No.30 Hill St','Nuwara Eliya','Central',16000);
INSERT INTO Customer VALUES('C006','Ms','Jayawardena','74569372V','1977-09-03','0787654321','No.25 Beach Rd','Negombo','Western',17000);
INSERT INTO Customer VALUES('C007','Mr','Bandara','80234569V','1985-12-08','0723456789','No.8 River View','Kurunegala','North Western',14500);
INSERT INTO Customer VALUES('C008','Ms','Gunawardena','91678453V','1992-02-14','0756789456','No.3 Sun St','Matara','Southern',19000);
INSERT INTO Customer VALUES('C009','Mr','Ratnayake','64573924V','1980-06-22','0712345678','No.12 Park Lane','Anuradhapura','North Central',15500);
INSERT INTO Customer VALUES('C010','Ms','Fernandez','87459632V','1986-08-17','0765432198','No.18 Crescent Rd','Gampaha','Western',17500);
INSERT INTO Customer VALUES('C011','Mr','Gunasekara','93145678V','1995-03-29','0701234567','No.7 Flower Lane','Badulla','Uva',20000);
INSERT INTO Customer VALUES('C012','Ms','Samarasinghe','76548932V','1974-11-15','0756789456','No.22 Palm Rd','Kalutara','Western',14500);
INSERT INTO Customer VALUES('C013','Mr','Fonseka','82193456V','1998-07-02','0798765432','No.14 Green St','Ratnapura','Sabaragamuwa',16500);
INSERT INTO Customer VALUES('C014','Ms','Karunaratne','92435678V','1989-01-20','0734567890','No.17 Sunset Blvd','Trincomalee','Eastern',18000);
INSERT INTO Customer VALUES('C015','Mr','Mendis','70648293V','1981-05-06','0723456789','No.19 Silver Rd','Batticaloa','Eastern',15500);
INSERT INTO Customer VALUES('C016','Ms','Senanayake','82937465V','1994-09-12','0712345678','No.9 Golden St','Ambalangoda','Southern',17000);
INSERT INTO Customer VALUES('C017','Mr','Silva','96743829V','1987-12-31','0787654321','No.2 Blue Lane','Kandy','Central',16000);
INSERT INTO Customer VALUES('C018','Ms','Perera','73485926V','1983-02-14','0745678901','No.16 Red Rd','Kurunegala','North Western',17500);
INSERT INTO Customer VALUES('C019','Mr','Fernando','92638574V','1996-06-30','0712345678','No.11 Ocean View','Colombo','Western',18500);
INSERT INTO Customer VALUES('C020','Ms','Ranasinghe','84269735V','1984-10-22','0765432198','No.6 Lake View','Galle','Southern',14000);

#*********************************************************************************************************************************************************************

INSERT INTO Reservation (ReservationID, CustID) VALUES ('R001', 'C001');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R002', 'C002');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R003', 'C003');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R004', 'C004');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R005', 'C005');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R006', 'C006');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R007', 'C007');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R008', 'C008');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R009', 'C009');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R010', 'C010');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R011', 'C011');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R012', 'C012');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R013', 'C013');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R014', 'C014');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R015', 'C015');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R016', 'C016');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R017', 'C017');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R018', 'C018');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R019', 'C019');
INSERT INTO Reservation (ReservationID, CustID) VALUES ('R020', 'C020');

#*********************************************************************************************************************************************************************

INSERT INTO Room_Category (CategoryID, PackageName, PackagePrice) VALUES ('RC001', 'Full Board', 10000.00);
INSERT INTO Room_Category (CategoryID, PackageName, PackagePrice) VALUES ('RC002', 'Half Board', 7500.00);
INSERT INTO Room_Category (CategoryID, PackageName, PackagePrice) VALUES ('RC003', 'Bed and Breakfast', 5000.00);

#*********************************************************************************************************************************************************************

INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM001', 'RC001', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM002', 'RC001', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM003', 'RC001', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM004', 'RC001', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM005', 'RC001', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM006', 'RC001', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM007', 'RC001', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM008', 'RC001', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM009', 'RC002', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM010', 'RC002', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM011', 'RC002', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM012', 'RC002', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM013', 'RC002', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM014', 'RC002', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM015', 'RC003', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM016', 'RC003', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM017', 'RC003', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM018', 'RC003', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM019', 'RC003', 1);
INSERT INTO Room (RoomID, CategoryID, Quantity) VALUES ('RM020', 'RC003', 1);

#*********************************************************************************************************************************************************************

INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R001', 'RM001', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R002', 'RM002', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R003', 'RM003', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R004', 'RM004', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R005', 'RM005', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R006', 'RM006', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R007', 'RM007', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R008', 'RM008', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R009', 'RM009', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R010', 'RM010', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R011', 'RM011', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R012', 'RM012', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R013', 'RM013', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R014', 'RM014', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R015', 'RM015', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R016', 'RM016', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R017', 'RM017', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R018', 'RM018', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R019', 'RM019', 1, 0);
INSERT INTO Reservation_Detail (ReservationID, RoomID, ReservationQty, Discount) VALUES ('R020', 'RM020', 1, 0);


SELECT * FROM customer;
SELECT * FROM Reservation;
SELECT * FROM Room_Category;
SELECT * FROM Room;
SELECT * FROM Reservation_Detail;

desc customer;
desc Reservation;
desc Room_Category;
desc Room;
desc Reservation_Detail;

#*********************************************************************************************************************************************************************
#*********************************************************************************************************************************************************************


DROP DATABASE IF EXISTS login;
CREATE DATABASE login;
USE login;


CREATE TABLE login_data(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(30),
    Password VARCHAR(10)
);

INSERT INTO login_data (Email, Password) VALUES ('Sanjaya@123.gmail.com', '1234abc');
INSERT INTO login_data (Email, Password) VALUES ('Prasad@12.gmail.com', '12abcd');
INSERT INTO login_data (Email, Password) VALUES ('Rajapaksha@1.gmail.com', '123456');

SELECT * FROM login_data;
desc login_data;
