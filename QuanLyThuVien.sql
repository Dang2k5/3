IF EXISTS (SELECT * FROM SYSDATABASES WHERE NAME = 'QuanLyThuVien')
	DROP DATABASE QuanLyThuVien
GO
CREATE DATABASE QuanLyThuVien
GO
USE QuanLyThuVien
GO


CREATE TABLE Reader (
  Reader_id INT IDENTITY PRIMARY KEY,
  Name NVARCHAR(15) NOT NULL,
  Address NVARCHAR(20) NOT NULL,
  Email VARCHAR(30) NOT NULL, 
  Phone VARCHAR(10) NOT NULL
) 


CREATE TABLE Category (
  Category_id INT IDENTITY PRIMARY KEY,
  Category_name NVARCHAR(20) NOT NULL
)


CREATE TABLE Users (
  Users_id INT IDENTITY PRIMARY KEY,
  Name NVARCHAR(15) NOT NULL,
  Leve INT NOT NULL,
  Phone VARCHAR(11) NOT NULL,
  Username VARCHAR(50)  NOT NULL,
  Password VARCHAR(200) DEFAULT NULL,
  Flag INT NOT NULL
) 


CREATE TABLE Book (
  Book_id INT IDENTITY PRIMARY KEY,
  Title NVARCHAR(20) NOT NULL,
  Author NVARCHAR(30) NOT NULL,
  Category_id INT NOT NULL,
  Amount INT NOT NULL,
  Introduce NVARCHAR(100) NOT NULL,
  FOREIGN KEY(Category_id) REFERENCES Category(Category_id)
  ON UPDATE CASCADE ON DELETE CASCADE,
) 

CREATE TABLE Bill(
	Bill_id INT IDENTITY PRIMARY KEY,
	Reader_id INT NOT NULL FOREIGN KEY(Reader_id) REFERENCES Reader(Reader_id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	Users_id INT NOT NULL FOREIGN KEY(Users_id) REFERENCES Users(Users_id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	Date_muon VARCHAR(50) NOT NULL,
	Date_hen VARCHAR(50) NOT NULL,
	Deposit VARCHAR(50) NOT NULL,	
	)

CREATE TABLE Bill_Detail(
	Bill_id INT NOT NULL,
	Book_id INT NOT NULL,
	PRIMARY KEY(Bill_id, Book_id),
	FOREIGN KEY (Bill_id) REFERENCES Bill(Bill_id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (Book_id) REFERENCES Book(Book_id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	Fined NVARCHAR(100) NOT NULL
) 
-----
INSERT INTO Reader (Address, Email, Name, Phone) VALUES
(N'Hà Nội', 'dangdao2k5@gmail.com', N'Đăng Đào', '0387780807'),
(N'Hưng Yên', 'hieu@gmail.com', N'Minh Hiếu', '0130102301'),
(N'Hưng Yên', 'trung@gamil.com', N'Văn Trung', '0120301230')
select *from Reader
Delete from Reader
INSERT INTO Category ( Category_name) VALUES
( N'Sách Ngôn Tình'),
( N'Sách Tiểu thuyết'),
( N'Sách kinh doanh'),
( N'Sách IT'),
( N'Sách Giáo Khoa'),
( N'Sách Nấu ăn'),
( N'Báo')
INSERT INTO Book (Title, Author, Category_id, Amount, Introduce) VALUES
('One Piece', 'Oda', 2, 1000, 'One Pieceeeeee'),
(N'Toán', 'Lê Cao', 3, 120, 'hihihihihi'),
(N'Văn', 'Lê Cao', 4, 100, 'hihihihihi'),
(N'Anh', 'Văn An', 1, 50, 'hahahaha')

DELETE FROM Book
INSERT INTO Users(Name, Leve, Phone, Username, Password, Flag)
VALUES(N'Đăng Đào', 0, '0387780807', 'admin', 'admin', 1),
(N'Minh Hiếu', 1, '0203012012', 'hieu', '1234', 1),
(N'Minh Hiếu', 2, '0203012012', 'hieu', '1234', 1),
(N'Đăng', 1, '0203012012', 'dang', '1234', 1),
(N'Hồng', 2, '0203012012', 'hong', '1234', 1),
(N'Nam', 2, '023103012', 'nam', '1234' , 0)
select *from Users
DELETE FROM USERS

INSERT INTO Bill(Reader_id, Users_id, Date_muon, Date_hen,Deposit) 
VALUES(1,1,'16/12/2024', '20/12/2024', 10000),
(2,2,'17/12/2024', '29/12/2024', 20000)
SELECT *FROM Bill
SELECT Author, COUNT(*) AS N'TỔNG SỐ SÁCH' FROM Book GROUP BY author

SELECT Name, COUNT(Name) FROM Reader GROUP BY Name
SELECT COUNT(*) FROM Book


