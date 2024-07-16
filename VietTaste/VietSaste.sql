CREATE DATABASE VietTaste;
GO

USE VietTaste;
GO

-- Bảng Users chứa thông tin người dùng
CREATE TABLE Users (
    User_Id VARCHAR(255) NOT NULL,
    Username NVARCHAR(50) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Email VARCHAR(max) NOT NULL,
    Role NVARCHAR(50) NOT NULL, -- phân vai trò có User với Admin, có thể mở rộng thêm
    PRIMARY KEY (User_Id),
    UNIQUE (Username),
    UNIQUE (User_Id) 
);
GO

-- Bảng NFT chứa thông tin NFT
CREATE TABLE NFT (
    NFT_Id VARCHAR(255) NOT NULL,
    Name NVARCHAR(max) NOT NULL,
    Description NVARCHAR(max) NOT NULL,
    Image NVARCHAR(max) NOT NULL,
    Price FLOAT NOT NULL, -- giá bằng đơn vị tiền ảo (0,29 SOL chẳng hạn)
    User_Id VARCHAR(255),  -- Thay đổi kiểu dữ liệu cho User_Id
    PRIMARY KEY (NFT_Id),
    FOREIGN KEY (User_Id) REFERENCES Users(User_Id)
);
GO

-- Bảng Transactions chứa thông tin giao dịch trao đổi NFT
CREATE TABLE Transactions (
    Transaction_Id VARCHAR(255) NOT NULL,
    Timestamp VARCHAR(max) NOT NULL, -- thời điểm giao dịch
    NFT_Id VARCHAR(255) NOT NULL,
    PRIMARY KEY (Transaction_Id),
    FOREIGN KEY (NFT_Id) REFERENCES NFT(NFT_Id)
);
GO

-- Bảng Menu chứa danh sách các NFT thuộc cùng loại (món súp, đồ chua, đồ khô...) hoặc cùng địa phương...
CREATE TABLE Menu (
    Menu_Id INT NOT NULL,
    Title VARCHAR(max) NOT NULL, -- tên menu, có thể theo loại món, theo địa phương, theo địa danh làm ra...
    PRIMARY KEY (Menu_Id)
);
GO

-- Bảng Wallet chứa thông tin ví 
CREATE TABLE Wallet (
    Wallet_Id VARCHAR(255) NOT NULL,
    Balance BIGINT NOT NULL, -- số dư ví
    User_Id VARCHAR(255) NOT NULL,  -- Thay đổi kiểu dữ liệu cho User_Id
    PRIMARY KEY (Wallet_Id),
    FOREIGN KEY (User_Id) REFERENCES Users(User_Id)
);
GO

-- Bảng Community_Post chứa thông tin bài viết cộng đồng
CREATE TABLE Community_Post (
    Post_Id INT NOT NULL,
    Title NVARCHAR(max) NOT NULL,
    Content NVARCHAR(max) NOT NULL,
    User_Id VARCHAR(255) NOT NULL,  -- Thay đổi kiểu dữ liệu cho User_Id
    PRIMARY KEY (Post_Id),
    FOREIGN KEY (User_Id) REFERENCES Users(User_Id)
);
GO

-- Bảng Participator chứa thông tin người tham gia Transaction
CREATE TABLE Participator (
    Role VARCHAR(max) NOT NULL, -- vai trò tham gia (người mua [Buyer], người bán [Seller])
    User_Id VARCHAR(255) NOT NULL,  -- Thay đổi kiểu dữ liệu cho User_Id
    Transaction_Id VARCHAR(255) NOT NULL,
    PRIMARY KEY (User_Id, Transaction_Id),
    FOREIGN KEY (User_Id) REFERENCES Users(User_Id),
    FOREIGN KEY (Transaction_Id) REFERENCES Transactions(Transaction_Id)
);
GO

-- Bảng List_Menu trung gian, chứa danh sách các Menu mà một món ăn sẽ thuộc vào
CREATE TABLE List_Menu (
    NFT_Id VARCHAR(255) NOT NULL,
    Menu_Id INT NOT NULL,
    PRIMARY KEY (NFT_Id, Menu_Id),
    FOREIGN KEY (NFT_Id) REFERENCES NFT(NFT_Id),
    FOREIGN KEY (Menu_Id) REFERENCES Menu(Menu_Id)
);
GO

-- Chứng nhận NFT của một User nổi tiếng trong hệ thống, hay của một người, một tổ chức có danh tiếng công nhận
CREATE TABLE Certificate (
    Timestamp INT NOT NULL,
    Description INT NOT NULL,
    NFT_Id VARCHAR(255) NOT NULL,
    User_Id VARCHAR(255) NOT NULL,  -- Thay đổi kiểu dữ liệu cho User_Id
    PRIMARY KEY (NFT_Id, User_Id),
    FOREIGN KEY (NFT_Id) REFERENCES NFT(NFT_Id),
    FOREIGN KEY (User_Id) REFERENCES Users(User_Id)
);
GO

-- Giỏ hàng chứa các món ăn được thêm vào giỏ
CREATE TABLE Cart (
    User_Id VARCHAR(255) NOT NULL,  -- Thay đổi kiểu dữ liệu cho User_Id
    NFT_Id VARCHAR(255) NOT NULL,
    PRIMARY KEY (User_Id, NFT_Id),
    FOREIGN KEY (User_Id) REFERENCES Users(User_Id),
    FOREIGN KEY (NFT_Id) REFERENCES NFT(NFT_Id)
);

--dữ liệu
INSERT INTO Users (User_Id, Username, Password, Email, Role)
VALUES ('1', N'anhltn', N'anhtoprac', 'lethinhatanh1060@gmail.com', N'USER');
GO