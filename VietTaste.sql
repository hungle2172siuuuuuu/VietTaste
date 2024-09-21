CREATE DATABASE VietTaste;
GO

USE VietTaste;
GO


-- Bảng Users 
CREATE TABLE Users (
    Id VARCHAR(255) NOT NULL,
    Username NVARCHAR(50) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Role NVARCHAR(50) NOT NULL, 
    Status VARCHAR(20) NOT NULL
);
GO

-- Bảng Restaurant 
CREATE TABLE Restaurant (
    Id VARCHAR(255) NOT NULL,
    Name NVARCHAR(255) NOT NULL,
    Registration_Number VARCHAR(255) NOT NULL,
    Address NVARCHAR(255) NOT NULL,
    Phone_Number VARCHAR(20),
    Email VARCHAR(255),
    Business_License NVARCHAR(255) NOT NULL,
    Food_Safety_License NVARCHAR(255) NOT NULL,
    User_Id VARCHAR(255) NOT NULL,
    Status VARCHAR(255) NOT NULL
);
GO

-- Bảng News
CREATE TABLE News
(
 Id VARCHAR(255) NOT NULL,
 Title NVARCHAR(max) NOT NULL,
 Content NVARCHAR(max) NOT NULL,
 User_Id VARCHAR(255) NOT NULL
);
GO

-- Bảng Comment
CREATE TABLE Comment
(
 Id INT IDENTITY(1,1) NOT NULL,
 Content NVARCHAR(max) NOT NULL,
 News_Id VARCHAR(255) NOT NULL,
 User_Id VARCHAR(255) NOT NULL
);
GO

-- Bảng Stall 
CREATE TABLE Stall
(
 Id VARCHAR(255) NOT NULL,
 Title NVARCHAR(255) NOT NULL,
 Content NVARCHAR(max) NOT NULL,
 User_Id VARCHAR(255) NOT NULL
);
GO

-- Bảng Food 
CREATE TABLE Food (
    Id VARCHAR(255) NOT NULL,
    Name NVARCHAR(max) NOT NULL,
    Description NVARCHAR(max) NOT NULL,
    Image NVARCHAR(max) NOT NULL,
    Price FLOAT NOT NULL, 
    Stall_Id VARCHAR(255)
);
GO

-- Hóa đơn mua 
CREATE TABLE Orders
(
 Create_Date DATE NOT NULL,
 Id VARCHAR(255) NOT NULL,
 Status NVARCHAR(255) NOT NULL,
 User_Id VARCHAR(255) NOT NULL
);
GO

-- Danh sách SP trong hóa đơn
CREATE TABLE Order_Detail
(
 Id VARCHAR(255) NOT NULL,
 Quantity INT NOT NULL,
 Food_Id VARCHAR(255) NOT NULL,
 Order_Id VARCHAR(255) NOT NULL
);
GO

-- Bảng Wallet 
CREATE TABLE Wallet (
    Public_Key VARCHAR(255) NOT NULL,
    Balance BIGINT NOT NULL, 
    User_Id VARCHAR(255) NOT NULL 
);
GO

-- Danh sách các loại món ăn
CREATE TABLE Category
(
 Id INT NOT NULL,
 Title NVARCHAR(255) NOT NULL
);
GO

-- Loại món ăn
CREATE TABLE Food_Category
(
 Food_Id VARCHAR(255) NOT NULL,
 Category_Id INT NOT NULL
);
GO

-- Giỏ hàng 
CREATE TABLE Cart (
    User_Id VARCHAR(255) NOT NULL, 
    Food_Id VARCHAR(255) NOT NULL
);
GO

-- Thêm các ràng buộc cho tất cả các bảng
-- Bảng Users
ALTER TABLE Users 
    ADD PRIMARY KEY (Id);

ALTER TABLE Users 
    ADD UNIQUE (Username);

ALTER TABLE Users 
    ADD UNIQUE (Email);

-- Bảng Restaurant
ALTER TABLE Restaurant 
    ADD PRIMARY KEY (Id);

ALTER TABLE Restaurant 
    ADD FOREIGN KEY (User_Id) REFERENCES Users(Id);

ALTER TABLE Restaurant 
    ADD UNIQUE (Registration_Number);

ALTER TABLE Restaurant 
    ADD UNIQUE (Business_License);

ALTER TABLE Restaurant 
    ADD UNIQUE (Food_Safety_License);

CREATE INDEX IX_Restaurant_User_Id ON Restaurant (User_Id);

-- Bảng News
ALTER TABLE News 
    ADD PRIMARY KEY (Id);

ALTER TABLE News 
    ADD FOREIGN KEY (User_Id) REFERENCES Users(Id);

-- Bảng Comment
ALTER TABLE Comment 
    ADD PRIMARY KEY (Id);

ALTER TABLE Comment 
    ADD UNIQUE (News_Id, User_Id);

ALTER TABLE Comment 
    ADD FOREIGN KEY (News_Id) REFERENCES News(Id);

ALTER TABLE Comment 
    ADD FOREIGN KEY (User_Id) REFERENCES Users(Id);

-- Bảng Stall
ALTER TABLE Stall 
    ADD PRIMARY KEY (Id);

ALTER TABLE Stall 
    ADD FOREIGN KEY (User_Id) REFERENCES Users(Id);

-- Bảng Food
ALTER TABLE Food 
    ADD PRIMARY KEY (Id);

ALTER TABLE Food 
    ADD FOREIGN KEY (Stall_Id) REFERENCES Stall(Id);

-- Bảng Orders (đã đổi tên)
ALTER TABLE Orders
    ADD PRIMARY KEY (Id);

ALTER TABLE Orders
    ADD FOREIGN KEY (User_Id) REFERENCES Users(Id);

-- Bảng Order_Detail
ALTER TABLE Order_Detail
    ADD PRIMARY KEY (Id);

ALTER TABLE Order_Detail
    ADD FOREIGN KEY (Food_Id) REFERENCES Food(Id);

ALTER TABLE Order_Detail
    ADD FOREIGN KEY (Order_Id) REFERENCES Orders(Id);

-- Bảng Wallet
ALTER TABLE Wallet
    ADD PRIMARY KEY (Public_Key);

ALTER TABLE Wallet
    ADD FOREIGN KEY (User_Id) REFERENCES Users(Id);

-- Bảng Category
ALTER TABLE Category
    ADD PRIMARY KEY (Id);

-- Bảng Food_Category
ALTER TABLE Food_Category
    ADD PRIMARY KEY (Food_Id, Category_Id);

ALTER TABLE Food_Category
    ADD FOREIGN KEY (Food_Id) REFERENCES Food(Id);

ALTER TABLE Food_Category
    ADD FOREIGN KEY (Category_Id) REFERENCES Category(Id);

-- Bảng Cart
ALTER TABLE Cart
    ADD PRIMARY KEY (User_Id, Food_Id);

ALTER TABLE Cart
    ADD FOREIGN KEY (User_Id) REFERENCES Users(Id);

ALTER TABLE Cart
    ADD FOREIGN KEY (Food_Id) REFERENCES Food(Id);
GO

-- Insert data into Users table
INSERT INTO Users (Id, Username, Password, Email, Role, Status)
VALUES 
('1FG28A', 'hungltps31968', '12345678', 'hungltps31968@fpt.edu.vn', 'Admin', 'Active'),
('28GF9B', 'quannaps31967', '12345678', 'quannaps31967@fpt.edu.vn', 'Admin', 'Active'),
('3F4724', 'tienhvps31950', '12345678', 'tienhvps31950@fpt.edu.vn', 'User', 'Active'),
('4J8435', 'anhltnps31917', '12345678', 'anhltnps31917@fpt.edu.vn', 'User', 'Active'),
('27G895', 'hoangptadora', 'adoradynasty', 'hoangphungthanh@gmail.com', 'Representative', 'Active')
;
GO

-- Insert data into News table
INSERT INTO News (Id, Title, Content, User_Id)
VALUES 
('7GC243', 'News Title 1', 'Content of the first news item', '1FG28A'),
('GC8T3Y', 'News Title 2', 'Content of the second news item', '28GF9B');
GO

-- Insert data into Comment table
INSERT INTO Comment (Content, News_Id, User_Id)
VALUES 
('Great article!', '7GC243', '3F4724'),
('Thanks for the info!', 'GC8T3Y', '4J8435');
GO

-- Insert data into Stall table
INSERT INTO Stall (Id, Title, Content, User_Id)
VALUES 
('MC53L8', 'Stall 1', 'Content of stall 1', '1FG28A'),  -- Giả sử User_Id '1' là '1FG28A'
('V8CR94', 'Stall 2', 'Content of stall 2', '28GF9B');     -- Giả sử User_Id '2' là '28GF9B'
GO

-- Insert data into Food table
INSERT INTO Food (Id, Name, Description, Image, Price, Stall_Id)
VALUES 
('FI91L7', 'Food 1', 'Description of Food 1', 'image1.jpg', 0.5, 'MC53L8'),
('RG8A49', 'Food 2', 'Description of Food 2', 'image2.jpg', 1.0, 'V8CR94');
GO

-- Insert data into Wallet table
INSERT INTO Wallet (Public_Key, Balance, User_Id)
VALUES 
('DMfXVqiVtzyxYAareLi8vSD3jf2F5GhVV9meAEQZ72WR', 100000, '1FG28A'),  -- Giả sử User_Id '1' là '1FG28A'
('CmYaAsc4jn75wzPDkG97hGVTDMQ3P1jUVJ71fDjSrR2T', 200000, '4J8435');     -- Giả sử User_Id '2' là '28GF9B'
GO

-- Insert data into Category table
INSERT INTO Category (Id, Title)
VALUES 
(1, 'Category 1'),
(2, 'Category 2');
GO

INSERT INTO Food_Category (Food_Id, Category_Id)
VALUES
('pk1', 1),
('pk2', 2);
GO

-- Insert data into Cart table
INSERT INTO Cart (User_Id, Food_Id)
VALUES 
('1FG28A', 'pk1'),  -- Giả sử User_Id '1' là '1FG28A'
('28GF9B', 'pk2');     -- Giả sử User_Id '2' là '28GF9B'
GO

INSERT INTO Restaurant (Id, Name, Registration_Number, Address, Phone_Number, Email, Business_License, Food_Safety_License, User_Id, Status)
VALUES
('R1', N'Nhà hàng Phở Hương', '123456789', N'123 Nguyễn Văn Cừ, Quận 5, TP.HCM', '0901234567', 'phohuong@gmail.com', 'BL12345', 'FSL67890', '27G895', 'Active'),
('R2', N'Quán Cơm Tấm Sài Gòn', '987654321', N'456 Lê Văn Sỹ, Quận 3, TP.HCM', '0987654321', 'comtam@gmail.com', 'BL54321', 'FSL09876', '27G895', 'Active');
GO

INSERT INTO Orders (Create_Date, Id, Status, User_Id)
VALUES
('2023-09-10', 'O1', 'Completed', '3F4724'),
('2023-09-11', 'O2', 'Pending', '4J8435');
GO

INSERT INTO OrderDetail (Id, Quantity, Food_Id, Order_Id)
VALUES
('OD1', 2, 'pk1', 'O1'),
('OD2', 1, 'pk2', 'O2');
GO

INSERT INTO Food_Category (Food_Id, Category_Id)
VALUES
('pk1', 1),
('pk2', 2);
GO
