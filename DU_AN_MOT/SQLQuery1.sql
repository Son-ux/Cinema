
--TẠO DATABASE
USE [master];
GO

DECLARE @kill varchar(8000) = '';  
SELECT @kill = @kill + 'kill ' + CONVERT(varchar(5), session_id) + ';'  
FROM sys.dm_exec_sessions
WHERE database_id  = DB_ID('DuAnMot')

EXEC(@kill);
GO

DROP DATABASE IF EXISTS DuAnMot;
GO

CREATE DATABASE [DuAnMot] ON PRIMARY
	(NAME = N'DuAnMot_Data' , FILENAME = N'E:\DATABASE_JAVA\DU_AN_MOT_Data.mdf', SIZE = 12000KB, MAXSIZE = UNLIMITED, FILEGROWTH = 64000KB)
LOG ON
	(NAME = N'DuAnMot_Log', FILENAME = N'E:\DATABASE_JAVA\DU_AN_MOT_Log.ldf', SIZE = 12000KB, MAXSIZE = UNLIMITED, FILEGROWTH = 64000KB);
GO

USE [DuAnMot];
GO
--TẠO BẢNG

CREATE TABLE TAIKHOAN(
	MaTaiKhoan Nvarchar(9) primary key  not null,
	TenDangNhap Nvarchar(70) not null,
	MatKhau Nvarchar(70) not null,
	HoTen Nvarchar(70) not null,
	GioiTinh BIT not null,
	SDT Nvarchar(10) not null,
	Email Nvarchar(70) not null,
	Hinh Nvarchar(70) null,
	VaiTro int not null,
)

CREATE TABLE PHONGCHIEU(
	MaPhongChieu int primary key not null,
	TenPhongChieu Nvarchar(70) not null,
)

CREATE TABLE GHE(
	MaGhe Nvarchar(7) primary key not null
)

CREATE TABLE LOAIPHIM(
	MaLoaiPhim int primary key identity not null,
	TenTheLoai Nvarchar(70) not null
);

CREATE TABLE PHIM(
	MaPhim int primary key identity not null,
	TenPhim Nvarchar(70) not null,
	NhaSanXuat Nvarchar(70) not null,
	DoTuoi int not null,
	ThoiLuong int not null,
	NgayCongChieu date not null,
	Poster Nvarchar(70)  null,
	MaLoaiPhim int not null
	CONSTRAINT FK_LOAIPHIM_PHIM
	FOREIGN KEY (MaLoaiPhim)
	REFERENCES LOAIPHIM(MaLoaiPhim)
);

CREATE TABLE LICHCHIEU(
	MaLichChieu int primary key identity not null,
	NgayChieu date not null,
	GioChieu time(7) not null,
	MaPhim int not null,
	MaPhongChieu int not null,
	CONSTRAINT FK_PHIM_LICHCHIEU
	FOREIGN KEY (MaPhim)
	REFERENCES PHIM(MaPhim),
	--
	CONSTRAINT FK_PHONGCHIEU_LICHCHIEU
	FOREIGN KEY (MaPhongChieu)
	REFERENCES PHONGCHIEU(MaPhongChieu)
)

CREATE TABLE GIAVE(
	MaGiaVe int primary key not null,
	GiaVe Float not null,
	MoTa Nvarchar(70) not null
)

CREATE TABLE VE(
	MaVe Int primary key identity not null,
	NgayTao Date not null,
	MaLichChieu  int not null,
	MaGhe Nvarchar(7) not null,
	MaGiaVe int not null,
	MaTaiKhoan Nvarchar(9) not null,
	GiaVe int not null
	CONSTRAINT FK_LICHCHIEU_VE
	FOREIGN KEY (MaLichChieu)
	REFERENCES LICHCHIEU(MaLichChieu),
	-------
	CONSTRAINT FK_GHE_VE
	FOREIGN KEY (MaGhe)
	REFERENCES GHE(MaGhe),
	-------
	CONSTRAINT FK_GIAVE_VE
	FOREIGN KEY (MaGiaVe)
	REFERENCES GIAVE(MaGiaVe),
	-------
	CONSTRAINT FK_TAIKHOAN_VE
	FOREIGN KEY (MaTaiKhoan)
	REFERENCES TAIKHOAN(MaTaiKhoan)
)

GO
/*INSERT DỮ LIỆU TÀI KHOẢN*/
 
INSERT INTO TAIKHOAN(MaTaiKhoan,   TenDangNhap,   MatKhau,   HoTen,   GioiTinh,   SDT,   Email,   Hinh,   VaiTro)
	          VALUES(N'ADMIN01', N'SON', N'1234567', N'Đào Hồng Sơn', 0, N'0932277777', N'son2710@gmail.com', N'son.png', 0),
		            (N'ADMIN02', N'KHOA', N'1234567', N'Nguyễn Anh Khoa', 0, N'0986565656', N'khoa1255@gmail.com', N'khoa.png', 0),
		            (N'ADMIN03', N'HUY', N'1234567', N'Phạm Lê Huy', 0, N'0987654345', N'huy6565@gmail.com', N'huy.png', 0),
		            (N'ADMIN04', N'HAI', N'1234567', N'Nguyễn Văn Hải',0, N'9856542121', N'hai2541@gmail.com', N'hai.png', 0),
                    (N'STAFF01', N'HOA', N'7654321', N'Nguyễn Thị Hoa', 1, N'925478555', N'hoa0987@gmail@gmail.com', N'hoa.png', 1),
		            (N'STAFF02', N'QUAN', N'7654321', N'Nguyễn Văn Quân', 0, N'925478222', N'quan7887@gmail@gmail.com', N'quan.png', 1),
		            (N'STAFF03', N'QUYNH', N'7654321', N'Phạm Thị Quỳnh', 1, N'978478655', N'quynh0965@gmail@gmail.com', N'quynh.png', 1),
		            (N'STAFF04', N'NHI', N'7654321', N'Lê Ánh Nhi', 1, N'925478111', N'nhi2288@gmail@gmail.com', N'nhi.png', 1)

GO
/*INSERT DỮ LIỆU PHÒNG CHIẾU*/

INSERT INTO PHONGCHIEU(MaPhongChieu, TenPhongChieu)
			    VALUES(1           , N'01'),
					  (2           , N'02')

GO
/*INSERT DỮ LIỆU GHE*/

INSERT INTO GHE (MaGhe)
		  VALUES(N'A1'),
				(N'A2'),
				(N'A3'),
				(N'A4'),
				(N'A5'),

				(N'B1'),
				(N'B2'),
				(N'B3'),
				(N'B4'),
				(N'B5'),

				(N'C1'),
				(N'C2'),
				(N'C3'),
				(N'C4'),
				(N'C5'),

				(N'D1'),
				(N'D2'),
				(N'D3'),
				(N'D4'),
				(N'D5')

GO
/*INSERT DỮ LIỆU LOẠI PHIM*/

INSERT INTO LOAIPHIM(TenTheLoai)
		VALUES	(N'Chiến tranh'),
	            (N'Cổ trang'),
	            (N'Hành động'),
	            (N'Hoạt hình'),
	            (N'Tâm lý')

GO
/*INSERT DỮ LIỆU PHIM*/

INSERT INTO PHIM(TenPhim, NhaSanXuat, DoTuoi, ThoiLuong, NgayCongChieu, Poster, MaLoaiPhim)
		VALUES  (N'Đột kích hồ giấu vàng', N'Belga Productions', 01, 190, '2015-07-02', N'dotkichhogiauvang.jpg', 1),
			   	(N'Chiến Hạm', N'America', 01, 170, '2017-07-09', N'chienHam.jpg', 1),
				(N'Amadeus', N'Saul Zaentz', 01, 220, '1997-09-17', N'amadeus.jpg', 2),
				(N'Copying beethoven', N'America', 01, 125, '1976-12-12', N'beethoven.jpg', 2),
				(N'Bụi đời chợ lớn', N' ‎Galaxy Studio', 18, 110, '2015-11-02', N'buiDoiChoLon.jpg', 3),
				(N'Người sói', N'Hutch Parker', 16, 155, '2012-02-04', N'theWolf.jpg', 3),
				(N'Your name', N'Comic Wave', 01, 170, '2016-08-12', N'YourName.jpg', 4),
				(N'Hữu nhân sổ', N' Brains Base', 01, 190, '2012-07-12', N'HuuNhanSo.jpg', 4),
				(N'Me Before you', N'New Cinema', 01, 150, '2016-06-03', N'MeBefore', 5),
				(N'Happy Hour', N' Nohara Tadashi', 16, 120, '2015-06-04', N'HappyHour',5)

GO
/*INSERT DỮ LIỆU LỊCH CHIẾU*/

INSERT INTO LICHCHIEU(NgayChieu, GioChieu, MaPhim, MaPhongChieu)
			VALUES   
/*THỨ 2*/
		    --Screen 1
			         ('2019-12-20', '08:00', 1, 1),
			         ('2019-12-20', '11:00', 3, 1),
			         ('2019-12-20', '13:30', 5, 1),
			         ('2019-12-20', '15:00', 7, 1),
			         ('2019-12-20', '17:30', 9, 1),
			         ('2019-12-20', '20:00', 2, 1),
			         ('2019-12-20', '22:30', 4, 1),
			--Screen 2
			         ('2019-12-20', '08:00', 6, 2),
					 ('2019-12-20', '11:00', 8, 2),
					 ('2019-12-20', '13:30', 10, 2),
					 ('2019-12-20', '15:00', 1, 2),
					 ('2019-12-20', '17:30', 3, 2),
					 ('2019-12-20', '20:00', 5, 2),
					 ('2019-12-20', '22:30', 7, 2),
/*THỨ 3*/
		    --Screen 1
			         ('2019-12-21', '08:00', 9, 1),
			         ('2019-12-21', '11:00', 2, 1),
			         ('2019-12-21', '13:30', 4, 1),
			         ('2019-12-21', '15:00', 6, 1),
			         ('2019-12-21', '17:30', 8, 1),
			         ('2019-12-21', '20:00', 10, 1),
			         ('2019-12-21', '22:30', 1, 1),
			--Screen 2
			         ('2019-12-21', '08:00', 3, 2),
					 ('2019-12-21', '11:00', 5, 2),
					 ('2019-12-21', '13:30', 7, 2),
					 ('2019-12-21', '15:00', 9, 2),
					 ('2019-12-21', '17:30', 2, 2),
					 ('2019-12-21', '20:00', 4, 2),
					 ('2019-12-21', '22:30', 6, 2),
/*THỨ 4*/
		    --Screen 1
			         ('2019-12-22', '08:00', 8, 1),
			         ('2019-12-22', '11:00', 10, 1),
			         ('2019-12-22', '13:30', 1, 1),
			         ('2019-12-22', '15:00', 3, 1),
			         ('2019-12-22', '17:30', 5, 1),
			         ('2019-12-22', '20:00', 7, 1),
			         ('2019-12-22', '22:30', 9, 1),
			--Screen 2
			         ('2019-12-23', '08:00', 2, 2),
					 ('2019-12-23', '11:00', 4, 2),
					 ('2019-12-23', '13:30', 6, 2),
					 ('2019-12-23', '15:00', 8, 2),
					 ('2019-12-23', '17:30', 10, 2),
					 ('2019-12-23', '20:00', 1, 2),
					 ('2019-12-23', '22:30', 3, 2),
/*THỨ 5*/
		    --Screen 1
			         ('2019-12-24', '08:00', 5, 1),
			         ('2019-12-24', '11:00', 7, 1),
			         ('2019-12-24', '13:30', 9, 1),
			         ('2019-12-24', '15:00', 2, 1),
			         ('2019-12-24', '17:30', 4, 1),
			         ('2019-12-24', '20:00', 6, 1),
			         ('2019-12-24', '22:30', 8, 1),
			--Screen 2
			         ('2019-12-24', '08:00', 10, 2),
					 ('2019-12-24', '11:00', 1, 2),
					 ('2019-12-24', '13:30', 3, 2),
					 ('2019-12-24', '15:00', 5, 2),
					 ('2019-12-24', '17:30', 7, 2),
					 ('2019-12-24', '20:00', 9, 2),
					 ('2019-12-24', '22:30', 2, 2),
/*THỨ 6*/
		    --Screen 1
			         ('2019-12-24', '08:00', 4, 1),
			         ('2019-12-24', '11:00', 6, 1),
			         ('2019-12-24', '13:30', 8, 1),
			         ('2019-12-24', '15:00', 10, 1),
			         ('2019-12-24', '17:30', 1, 1),
			         ('2019-12-24', '20:00', 3, 1),
			         ('2019-12-24', '22:30', 5, 1),
			--Screen 2
			         ('2019-12-24', '08:00', 7, 2),
					 ('2019-12-24', '11:00', 9, 2),
					 ('2019-12-24', '13:30', 2, 2),
					 ('2019-12-24', '15:00', 4, 2),
					 ('2019-12-24', '17:30', 6, 2),
					 ('2019-12-24', '20:00', 8, 2),
					 ('2019-12-24', '22:30', 10, 2),
/*THỨ 7*/
		    --Screen 1
			         ('2019-12-25', '08:00', 1, 1),
			         ('2019-12-25', '11:00', 3, 1),
			         ('2019-12-25', '13:30', 5, 1),
			         ('2019-12-25', '15:00', 7, 1),
			         ('2019-12-25', '17:30', 9, 1),
			         ('2019-12-25', '20:00', 2, 1),
			         ('2019-12-25', '22:30', 4, 1),
			--Screen 2
			         ('2019-12-25', '08:00', 6, 2),
					 ('2019-12-25', '11:00', 8, 2),
					 ('2019-12-25', '13:30', 10, 2),
					 ('2019-12-25', '15:00', 1, 2),
					 ('2019-12-25', '17:30', 3, 2),
					 ('2019-12-25', '20:00', 5, 2),
					 ('2019-12-25', '22:30', 7, 2),
/*CHỦ NHẬT*/
		    --Screen 1
			         ('2019-12-26', '08:00', 9, 1),
			         ('2019-12-26', '11:00', 2, 1),
			         ('2019-12-26', '13:30', 4, 1),
			         ('2019-12-26', '15:00', 6, 1),
			         ('2019-12-26', '17:30', 8, 1),
			         ('2019-12-26', '20:00', 10, 1),
			         ('2019-12-26', '22:30', 1, 1),
			--Screen 2
			         ('2019-12-26', '08:00', 3, 2),
					 ('2019-12-26', '11:00', 5, 2),
					 ('2019-12-26', '13:30', 7, 2),
					 ('2019-12-26', '15:00', 9, 2),
					 ('2019-12-26', '17:30', 2, 2),
					 ('2019-12-26', '20:00', 7, 2),
					 ('2019-12-26', '22:30', 9, 2)

GO
/*INSERT DỮ LIỆU GIAVE*/

INSERT INTO GIAVE(MaGiaVe, GiaVe, MoTa)
		   VALUES(1, 45000, N'Ngày thường'),
				 (2, 50000, N'Cuối tuần')
				 
GO
/*INSERT DỮ LIỆU VÉ*/

INSERT INTO VE(NgayTao, MaLichChieu, MaGhe, MaGiaVe, MaTaiKhoan, GiaVe)
	    VALUES('2019-12-06', 2, N'A2', 1, N'STAFF04', 45000),
		      ('2019-12-06', 4, N'B2', 1, N'STAFF04', 45000),
		      ('2019-12-06', 6, N'C2', 1, N'STAFF04', 45000),
		      ('2019-12-06', 7, N'D2', 1, N'STAFF04', 45000),
		      ('2019-12-07', 9, N'A5', 1, N'STAFF04', 45000),
		      ('2019-12-07', 12, N'C5', 1, N'STAFF04', 45000),
		      ('2019-12-07', 20, N'D5', 1, N'STAFF04', 45000),
			  ('2019-12-08', 2, N'A2', 1, N'STAFF04', 45000),
		      ('2019-12-08', 4, N'B2', 1, N'STAFF04', 45000),
		      ('2019-12-08', 6, N'C2', 1, N'STAFF04', 45000),
		      ('2019-12-09', 7, N'D2', 1, N'STAFF04', 45000),
		      ('2019-12-09', 9, N'A5', 1, N'STAFF04', 45000),
		      ('2019-12-09', 12, N'C5', 1, N'STAFF04', 45000),
		      ('2019-12-09', 20, N'D5', 1, N'STAFF04', 45000),
			  ('2019-12-10', 9, N'A5', 1, N'STAFF04', 45000),
		      ('2019-12-10', 12, N'C5', 1, N'STAFF04', 45000),
		      ('2019-12-10', 20, N'D5', 1, N'STAFF04', 45000),
			  ('2019-12-11', 9, N'A5', 1, N'STAFF04', 45000),
		      ('2019-12-11', 12, N'C5', 1, N'STAFF04', 45000),
		      ('2019-12-11', 20, N'D5', 1, N'STAFF04', 45000),			  
		      ('2019-12-12', 20, N'D5', 1, N'STAFF04', 45000),
			  ('2019-12-12', 9, N'A5', 1, N'STAFF04', 45000),
		      ('2019-12-12', 12, N'C5', 1, N'STAFF04', 45000),
		      ('2019-12-13', 20, N'D5', 1, N'STAFF04', 45000)

GO

/*Tạo thủ tục THỐNG KÊ*/

--DOANH THU THEO PHIM
/*
If(OBJECT_ID('sp_ThongKeTheoPhim') is not null)
	drop proc sp_ThongKeTheoPhim
GO

CREATE PROC sp_ThongKeTheoPhim
	@maPhim float
as
if(@maPhim != 0 )
	BEGIN
	*/

GO
/*		end
GO

call sp_ThongKeTheoPhim (2)*/


-- DOANH THU THEO THANG

SELECT NgayTao, SUM(GiaVe) as DoanhThu FROM VE WHERE (NgayTao between CAST('2019-12-09' as date) and CAST('2019-12-13' as date)) GROUP BY NgayTao

--DOANH THU THEO PHÒNG CHIẾU

GO
SELECT PHONGCHIEU.MaPhongChieu,
		PHONGCHIEU.TenPhongChieu,
		(select count(*) from LICHCHIEU where MaPhongChieu = PHONGCHIEU.MaPhongChieu) as SoLuongXuatChieu,
		count(PHONGCHIEU.MaPhongChieu) as SoLuongVeBan,
		sum(VE.GiaVe) as DoanhThuCuaPhongChieu
		from VE
		join LICHCHIEU on VE.MaLichChieu = LICHCHIEU.MaLichChieu
		join PHONGCHIEU on LICHCHIEU.MaPhongChieu = PHONGCHIEU.MaPhongChieu 
		group by PHONGCHIEU.MaPhongChieu, PHONGCHIEU.TenPhongChieu

GO
--Doanh Thu Theo Giờ Chiếu

SELECT LICHCHIEU.GioChieu,
			count(LICHCHIEU.GioChieu) as SoLuongVeBan,
			sum(VE.GiaVe) as DoanhThuCuaGioChieu
			from VE
			join LICHCHIEU on VE.MaLichChieu = LICHCHIEU.MaLichChieu
			group by LICHCHIEU.GioChieu
