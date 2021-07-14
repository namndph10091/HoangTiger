﻿CREATE DATABASE LAPTOP

CREATE TABLE TAIKHOAN(
    IDNV INT IDENTITY(1, 1) PRIMARY KEY,
    USERNAME NVARCHAR(255) NOT NULL,
	PASSWORD NVARCHAR(255) NOT NULL,
	ROLE NVARCHAR(100) NOT NULL
);

CREATE TABLE NHANVIEN(
    MANV NVARCHAR(255) PRIMARY KEY,
	IDNV INT IDENTITY(1, 1) NOT NULL,
	TENNV NVARCHAR(100) NOT NULL,
	NGAYSINH DATETIME NOT NULL,
	SDT NVARCHAR(10) NOT NULL,
	DIACHI NVARCHAR(255) NOT NULL,
	EMAIL NVARCHAR(50) NOT NULL,
	GIOITINH NVARCHAR(5) NOT NULL,
	CONSTRAINT FK_NHANVIEN_TAIKHOAN FOREIGN KEY(IDNV) REFERENCES TAIKHOAN
);

CREATE TABLE SANPHAM(
    MASP NVARCHAR(255) PRIMARY KEY,
	TENSP NVARCHAR(255) NOT NULL,
	TONKHO INT NOT NULL,
	DONGIA MONEY NOT NULL,
	HANG NVARCHAR(255) NOT NULL,
	NGAYNHAP DATETIME NOT NULL,
	MOTA NVARCHAR(500)
);

CREATE TABLE HOADON(
    MAHD NVARCHAR(255) PRIMARY KEY,
	MASP NVARCHAR(255) NOT NULL,
	TENSP NVARCHAR(255) NOT NULL,
	SOLUONG INT NOT NULL,
	TENKH NVARCHAR(255) NOT NULL,
	SDTKH NVARCHAR(10) NOT NULL,
	DIACHI NVARCHAR(255) NOT NULL,
	NGAYMUA DATETIME NOT NULL,
	TONGTIEN MONEY NOT NULL,
	CONSTRAINT FK_HOADON_SANPHAM FOREIGN KEY(MASP) REFERENCES SANPHAM
);
CREATE TABLE HANG
(
    ID INT IDENTITY(1, 1) PRIMARY KEY,
    TENHANG NVARCHAR(255) NOT NULL
);

SELECT * FROM TAIKHOAN
SELECT * FROM NHANVIEN
SELECT * FROM SANPHAM
SELECT * FROM HOADON
SELECT * FROM HANG


INSERT INTO TAIKHOAN VALUES('admin69', '12345678', 'Admin');
INSERT INTO TAIKHOAN VALUES('nhanvien96', '12345678', N'Nhân Viên');
INSERT INTO TAIKHOAN VALUES('userrrrr', '12345678', N'Khách Hàng');

DELETE FROM NHANVIEN
INSERT INTO NHANVIEN VALUES('NV01', 'AAAAA', '01/01/1999', '065536', N'Cầu Giấy', 'a@gmail.com', N'Nữ');
INSERT INTO NHANVIEN VALUES('NV02', 'BBBBB', '02/02/1999', '065232', N'Hà Đông', 'b@gmail.com', N'Nam');
INSERT INTO NHANVIEN VALUES('NV03', 'CCCCC', '03/03/1999', '065999', N'Long Biên', 'c@gmail.com', N'Nữ');

INSERT INTO SANPHAM VALUES('SP01', 'MSI Prestige 14 A10RAS 234VN - Rose Pink', 9, 25790000, 'MSI', '01/01/2020', N'CPU: Intel Core i7-10510U (1.80GHz up to 4.90GHz, 8MB Cache). Ram: 8GB DDR4 2666MHz. Ổ cứng: 512GB PCIe NVMe™ M.2 SSD. VGA: NVIDIA GeForce MX330 2GB GDDR5');
INSERT INTO SANPHAM VALUES('SP02', 'ACER NITRO 5 2020 AN515-55-5518', 12, 20990000, 'ACER', '02/02/2020', N'CPU: Intel Core i5-10300H. Ram: 8GB DDR4 2933MHz. Ổ cứng: 512GB SSD M.2 NVMe. VGA: NVIDIA GeForce GTX 1650 4GB');
INSERT INTO SANPHAM VALUES('SP03', 'Asus ROG Mothership GZ700GX-EV002R', 2, 178990000, 'ASUS', '03/03/2020', N'CPU: Intel Core i9-9880H (2.3GHz up to 4.8GHz 16MB Cache). Ram: 64GB (4x16GB) DDR4 2666Mhz; 4 slot, upto 128GB. Ổ cứng: 1.5TB (512GB*3) SSD PCIe NVMe Gen 3 x 4. VGA: Geforce RTX 2080 8GB GDDR6');

DELETE FROM HOADON
INSERT INTO HOADON VALUES('HD01', 'SP03', 'Asus ROG Mothership GZ700GX-EV002R', 1, 'THIS IS A NAME', '0944445555', N'Thanh Xuân', '08/08/2020', 178990000);
INSERT INTO HOADON VALUES('HD02', 'SP01', 'MSI Prestige 14 A10RAS 234VN - Rose Pink', 2, N'Nà Mè', '0944424444', N'Hoàn Kiếm', '09/09/2020', 51580000);
INSERT INTO HOADON VALUES('HD03', 'SP02', 'ACER NITRO 5 2020 AN515-55-5518', 3, N'Bạn Hoàng Giấu Tên', '0944468888', N'Gia Lâm', '10/10/2020', 62970000);

INSERT INTO HANG VALUES('MSI'), ('ACER'), ('ASUS');
