/*create database Travel*/
use Travel;

	INSERT INTO intimates(name)
	values
	('Copper'),
	('Silver'),
	('Golden'),
	('Diamon')

	 INSERT INTO accounts(user_name, pass_word, activated, address,age, email, full_name, phone, role,intimate_id)
	 VALUES
	 --12345
	('tanduong','$2a$12$.FGCfBI6l8LlZgtT3q6dF.N73YqUgvjXQfod1tmO7wRltIaAtvYt.', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0,1),
	('vantien','$2a$12$LFUDKedfUtczXdjZLKjOcuGXmEnWMztOAn5l48YElQqfyvf7fN8Ty', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0,1),
	
	--123
	('tanduong001','$2a$12$dPw43chz4FBNO8zCrbQRFuYeS4UKUyqiayqF1PHhYgLHYh0FuTZ2S', 1, N'112 Trần Hưng Đạo',21, 'tanduong69@gmail.com', 'Dương Nhựt Tân', '0785123654',1,null),
	 ('thanhtu002','$2a$12$DqHKOXHtBvJutoE6zB3dxumwcs5r.InlhKN0we06pLj5fMKSkhg02', 1, N'338 Nguyễn Văn Quá',12, 'tuthanh22012003@gmail.com', 'Ung Thanh Tú', '07541254',1,null),
	 --1234
	 ('vantu003','$2a$12$a1rIDHNWRd/GhUCmOhJW6.0SrxFaF/gNSTESrULuey.ble4fCbSES', 1, N'168 Võ Văn Kiệt', 21, 'vantu@gmail.com', 'Tô Vân Tú', '0785123655',1,null)
	-- Thêm loại tours
	select * from category_tours
	INSERT INTO category_tours (name,avatar) 
	VALUES
    (N'Thiên nhiên','https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940609/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image2.jpg'),
    (N'Di tích lịch sử','https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018361/Travel_FPoly/Image_Tourism/Old_City_HoiAn/avatar.jpg'),
    (N'Mạo hiểm','https://res.cloudinary.com/dpyp2vvdm/image/upload/v1691214448/Travel_FPoly/Image_Tourism/TayBac/image1.jpg'),
    (N'Nghỉ dưỡng','https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018095/Travel_FPoly/Image_Tourism/Da_Nang/image9.jpg');
	/* */
	--Thêm tour
	select * from tours
INSERT INTO tours (category_tour_id, Name, price_adult, price_children, quantity_adult, quantity_children, departure,
						destination, available, duration, description, introduction, map)
VALUES
	(1, N'Đà Nẵng', 0.1, 0.05, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Mở cửa cửa sổ ra biển xanh',N'Chào mừng bạn đến với hành trình khám phá vẻ đẹp tươi mới và hấp dẫn tại thành phố Đà Nẵng! Với danh tiếng là một điểm đến du lịch hàng đầu tại Việt Nam, Đà Nẵng hứa hẹn mang đến cho bạn những trải nghiệm đáng nhớ và phong cảnh thiên nhiên tuyệt đẹp.',''),
    (1, N'Vịnh Hạ Long', 80, 50, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Hành trình đến vùng đất thần tiên trên biển',N'Vịnh Hạ Long, vùng biển kỳ diệu nằm ở bắc Việt Nam, là một trong những kỳ quan thiên nhiên tuyệt đẹp của thế giới. Với hàng nghìn đảo đá vôi đan xen trên biển xanh, Vịnh Hạ Long là biểu tượng của sự hùng vĩ và kỳ bí của thiên nhiên.',''),
    (4, N'Italy', 150, 75, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Khám phá vẻ đẹp văn hóa, lịch sử và nghệ thuật',N'Italy - đất nước của những kiệt tác nghệ thuật vĩ đại, nền văn hóa đậm đà và lịch sử phong phú. Nằm ở Nam châu Âu, Italy có tầm ảnh hưởng lớn đến nền văn minh thế giới với những thành tựu vượt thời gian.',''),
    (2, N'Phố cổ Hội An', 200, 100, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Hành trình đi qua quá khứ và sắc màu văn hóa Việt Nam', N'Nằm ở miền Trung Việt Nam, Phố Cổ Hội An được coi là một trong những điểm đến du lịch phải đến ít nhất một lần trong đời. Với kiến trúc cổ kính, đường phố mềm mại và vị trí ven biển, Hội An là một hội tụ của lịch sử, văn hóa và nét đẹp thiên nhiên.',''),
    (1, N'Vũng Tàu', 120, 60, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Nơi gặp gỡ biển xanh, lịch sử và hương vị hải sản', N'Nằm cách thành phố Hồ Chí Minh khoảng 125 km về phía Đông Nam, Vũng Tàu là một thành phố biển quyến rũ với bãi biển dài, phong cảnh đa dạng và lịch sử độc đáo. Được biết đến như một điểm nghỉ dưỡng yên bình và một cảng biển quan trọng, Vũng Tàu là điểm đến lý tưởng cho những ai muốn tránh xa sự ồn ào của thành phố.',''),
    (3, N'Tây Bắc', 180, 90, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Hành trình khám phá vùng đất núi rừng hùng vĩ', N'Khu vực Tây Bắc Việt Nam là một bức tranh thiên nhiên tuyệt đẹp với những dãy núi cao, rừng rậm và vùng đất bản làng của các dân tộc thiểu số đa dạng về văn hóa và truyền thống. Đây là nơi bạn có cơ hội tiếp xúc với thiên nhiên hoang sơ và tìm hiểu về cuộc sống bản địa độc đáo.',''),
    (4, N'Paris', 90, 45, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Thành phố ánh sáng và lãng mạn', N'Paris, thủ đô của nước Pháp, là một trong những thành phố nổi tiếng và lãng mạn nhất thế giới. Với kiến trúc đẹp mắt, nghệ thuật tuyệt vời, và phong cách sống đầy tinh tế, Paris là nơi tập trung của văn hóa, thời trang và ẩm thực.', ''),
	(1, N'Tour Sài Gòn - Mekong', 120, 60, 10, 10, N'Hồ Chí Minh', N'Mekong Delta', 1, 3, N'Khám phá vùng đồng bằng sông Cửu Long', N'Tour Mekong Delta mang đến cho bạn trải nghiệm độc đáo ở vùng đồng bằng sông Cửu Long', ''),
    (2, N'Tour Bali, Indonesia', 250, 125, 10, 10, N'Hồ Chí Minh', N'Bali, Indonesia', 1, 5, N'Nghỉ dưỡng tại thiên đàng Bali', N'Tour Bali sẽ đưa bạn đến hòa mình trong vẻ đẹp thiên nhiên và văn hóa độc đáo của Bali', ''),
    (3, N'Tour Kyoto, Japan', 180, 90, 10, 10, N'Hồ Chí Minh', N'Kyoto, Japan', 1, 4, N'Khám phá lịch sử và nền văn hóa của Kyoto', N'Tour Kyoto sẽ đưa bạn đến thủ đô cổ của Nhật Bản với các đền chùa và vườn hoa rực rỡ', ''),
    (4, N'Tour New York City', 220, 110, 10, 10, N'Hồ Chí Minh', N'New York City, USA', 1, 6, N'Khám phá thành phố đa dạng và thời trang', N'Tour New York City sẽ đưa bạn đến trải nghiệm sôi động của thành phố lớn New York', ''),
    (1, N'Tour Chichen Itza, Mexico', 160, 80, 10, 10, N'Hồ Chí Minh', N'Chichen Itza, Mexico', 1, 3, N'Khám phá di tích lịch sử Chichen Itza', N'Tour Chichen Itza sẽ đưa bạn đến một trong những di tích lịch sử nổi tiếng của Mexico', ''),
    (2, N'Tour Sydney, Australia', 280, 140, 10, 10, N'Hồ Chí Minh', N'Sydney, Australia', 1, 7, N'Khám phá thành phố biển Sydney', N'Tour Sydney sẽ đưa bạn đến một trong những thành phố biển đẹp nhất thế giới', ''),
	(3, N'Tour Cappadocia, Turkey', 200, 100, 10, 10, N'Hồ Chí Minh', N'Cappadocia, Turkey', 1, 4, N'Khám phá vùng đất núi lửa Cappadocia', N'Tour Cappadocia sẽ đưa bạn đến vùng đất đầy bí ẩn và kiến trúc độc đáo tại Thổ Nhĩ Kỳ', ''),
    (4, N'Tour Dubai, UAE', 300, 150, 10, 10, N'Hồ Chí Minh', N'Dubai, United Arab Emirates', 1, 5, N'Khám phá thành phố xa hoa Dubai', N'Tour Dubai sẽ đưa bạn đến một trong những thành phố sang trọng và hiện đại nhất thế giới', ''),
    (1, N'Tour Santorini, Greece', 250, 125, 10, 10, N'Hồ Chí Minh', N'Santorini, Greece', 1, 5, N'Nghỉ dưỡng tại hòa nhạc Santorini', N'Tour Santorini sẽ đưa bạn đến một hòa nhạc xinh đẹp và vườn nho trên biển Aegean', ''),
    (2, N'Tour Machu Picchu, Peru', 180, 90, 10, 10, N'Hồ Chí Minh', N'Machu Picchu, Peru', 1, 4, N'Khám phá kỳ quan Machu Picchu', N'Tour Machu Picchu sẽ đưa bạn đến một trong những di sản thế giới nổi tiếng', ''),
    (3, N'Tour Victoria Falls, Zambia', 280, 140, 10, 10, N'Hồ Chí Minh', N'Victoria Falls, Zambia', 1, 6, N'Khám phá thác nước Victoria Falls', N'Tour Victoria Falls sẽ đưa bạn đến một trong những thác nước mạnh nhất thế giới', ''),
    (4, N'Tour Petra, Jordan', 220, 110, 10, 10, N'Hồ Chí Minh', N'Petra, Jordan', 1, 4, N'Khám phá thành phố cổ Petra', N'Tour Petra sẽ đưa bạn đến một thành phố cổ độc đáo được khắc vào đá', '');
	--thêm lịch trình
	select * from tour_schedules
	INSERT INTO tour_schedules(tour_id, title, description, date, time, image)
VALUES
    -- Đà Nẵng

    (1, N'Biển Mỹ Khê', N'Thưởng thức biển Mỹ Khê', '1', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image1.jpg'),
    (1, N'Bà Nà Hills', N'Thăm khu du lịch Bà Nà Hills', '1', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image2.jpg'),
    (1, N'Ngũ Hành Sơn', N'Khám phá núi Ngũ Hành Sơn', '2', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image3.jpg'),
    (1, N'Phố cổ Hội An', N'Dạo chơi tại phố cổ Hội An', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image4.jpg'),
    (1, N'Chùa Linh Ứng', N'Thăm chùa Linh Ứng', '2', '13:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image5.jpg'),
    (1, N'Bãi biển Non Nước', N'Tắm biển tại bãi biển Non Nước', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image6.jpg'),
    (1, N'Đêm trên bán đảo Sơn Trà', N'Trải nghiệm đêm trên bán đảo Sơn Trà', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image7.jpg'),

-- Vịnh Hạ Long

    (2, N'Hang Sung Sot', N'Thăm Hang Sung Sot', '1', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940964/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image1.jpg'),
    (2, N'Dao Ti Tốp', N'Thăm đảo Ti Tốp', '1', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940609/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image2.jpg'),
    (2, N'Bãi Cháy', N'Nghỉ ngơi tại bãi biển Bãi Cháy', '2', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940609/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image3.jpg'),
    (2, N'Vườn quốc gia Cát Bà', N'Khám phá vườn quốc gia Cát Bà', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940609/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image4.jpg'),
    (2, N'Bãi biển Tiên Ông', N'Tắm biển tại bãi biển Tiên Ông', '3', '13:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940609/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image5.jpg'),
    (2, N'Thám thị trấn Tuần Châu', N'Đi thăm thị trấn Tuần Châu', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940609/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image6.jpg'),
    (2, N'Đêm trên tàu thuyền', N'Trải nghiệm đêm trên tàu thuyền ở vịnh Hạ Long','3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940609/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image7.jpg'),

-- Italy

    (3, N'Đấng Michelangelo', N'Khám phá Đấng Michelangelo', '1', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image1.jpg'),
    (3, N'La Scala', N'Thăm nhà hát La Scala', '1', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image2.jpg'),
    (3, N'Công viên Colosseum', N'Dạo chơi tại công viên Colosseum', '2', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image3.jpg'),
    (3, N'Quảng trường St. Peter', N'Thăm quảng trường St. Peter', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image4.jpg'),
    (3, N'Milan Fashion District', N'Khám phá Milan Fashion District', '3', '13:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image5.jpg'),
    (3, N'Núi Vesuvius', N'Thăm núi lửa Vesuvius', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image6.jpg'),
    (3, N'Đêm tại Venice', N'Trải nghiệm đêm tại Venice', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image7.jpg'),

-- Phố cổ Hội An

    (4, N'Cầu An Hội', N'Thăm cầu An Hội', '1', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018363/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image1.jpg'),
    (4, N'Chùa Cầu', N'Thăm chùa Cầu', '1', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018363/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image2.jpg'),
    (4, N'Bãi biển Cửa Đại', N'Tắm biển tại bãi biển Cửa Đại', '2', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018363/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image3.jpg'),
    (4, N'Phố cổ Hội An', N'Dạo chơi tại phố cổ Hội An', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018363/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image4.jpg'),
    (4, N'Quảng trường Sông Hoài', N'Thăm quảng trường Sông Hoài', '3', '13:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018363/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image5.jpg'),
    (4, N'Nhà cổ Đức An', N'Khám phá nhà cổ Đức An', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018363/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image6.jpg'),
    (4, N'Đêm tại biển An Bàng', N'Trải nghiệm đêm tại biển An Bàng', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018363/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image7.jpg'),

-- Vũng Tàu
    (5, N'Bãi Trước', N'Tắm biển tại bãi biển Trước', '1', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image1.jpg'),
    (5, N'Tượng Chúa Kitô Vũng Tàu', N'Thăm tượng Chúa Kitô Vũng Tàu', '1', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image2.jpg'),
    (5, N'Bãi Sau', N'Tắm biển tại bãi biển Sau', '2', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image3.jpg'),
    (5, N'Dinh Cô', N'Thăm Dinh Cô', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image4.jpg'),
    (5, N'Chợ Cây Dừa', N'Khám phá Chợ Cây Dừa', '3', '13:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image5.jpg'),
    (5, N'Nhà hải sản Gành Rái', N'Thử các món hải sản tại Gành Rái', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image6.jpg'),
    (5, N'Đêm tại Bãi Dứa', N'Trải nghiệm đêm tại Bãi Dứa', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image7.jpg'),

-- Tây Bắc

    (6, N'Đèo Ô Quy Hồ', N'Đi qua Đèo Ô Quy Hồ', '1', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1691214398/Travel_FPoly/Image_Tourism/TayBac/image1.jpg'),
    (6, N'Hang Động Sơn Đoòng', N'Khám phá Hang Động Sơn Đoòng', '1', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1691214398/Travel_FPoly/Image_Tourism/TayBac/image2.jpg'),
    (6, N'Mường Hoa Valley', N'Dạo chơi tại Mường Hoa Valley', '2', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1691214398/Travel_FPoly/Image_Tourism/TayBac/image3.jpg'),
    (6, N'Khu du lịch Fansipan', N'Thăm khu du lịch Fansipan', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1691214398/Travel_FPoly/Image_Tourism/TayBac/image4.jpg'),
    (6, N'Bản Tả Phìn', N'Khám phá Bản Tả Phìn', '3', '13:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1691214398/Travel_FPoly/Image_Tourism/TayBac/image5.jpg'),
    (6, N'Cơ sở sản xuất bát Tràng', N'Xem cách làm bát Tràng thủ công', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1691214398/Travel_FPoly/Image_Tourism/TayBac/image6jpg'),
    (6, N'Đêm tại Sapa', N'Trải nghiệm đêm tại Sapa', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1691214398/Travel_FPoly/Image_Tourism/TayBac/image7.jpg'),

-- Paris

    (7, N'Tháp Eiffel', N'Thăm Tháp Eiffel', '1', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image1.jpg'),
    (7, N'Bảo tàng Louvre', N'Thăm Bảo tàng Louvre', '1', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image2.jpg'),
    (7, N'Catedrala Notre-Dame', N'Thăm Nhà thờ Đức Bà', '2', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image3.jpg'),
    (7, N'Quảng trường Concorde', N'Thăm Quảng trường Concorde', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image4.jpg'),
    (7, N'Khu phố Pigalle', N'Khám phá khu phố Pigalle', '3', '13:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image5.jpg'),
    (7, N'Château de Versailles', N'Thăm Château de Versailles', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image6.jpg'),
    (7, N'Đêm tại Montmartre', N'Trải nghiệm đêm tại Montmartre', '3', '07:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image7.jpg'),
	-- Tour 1: Sài Gòn - Mekong
    (8, N'Tham quan Cần Giờ', N'Mới trải nghiệm vùng sông nước hùng vĩ', '1', '08:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/SaiGon-Mekong/image1.jpg'),
    (8, N'Cây cầu tre Cần Giờ', N'Tham quan cây cầu tre truyền thống', '1', '10:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/SaiGon-Mekong/image2.jpg'),
    (8, N'Bình minh trên sông Cửu Long', N'Đón bình minh trên sông Cửu Long', '2', '05:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/SaiGon-Mekong/image3.jpg'),
    (8, N'Cồn Phụng', N'Đặt chân lên Cồn Phụng', '2', '09:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/SaiGon-Mekong/image4.jpg'),
    (8, N'Làng nghề Trà Vinh', N'Tham quan làng nghề Trà Vinh', '3', '11:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/SaiGon-Mekong/image5.jpg'),
    (8, N'Vườn hoa tím Cái Bè', N'Chiêm ngưỡng vườn hoa tím Cái Bè', '3', '14:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/SaiGon-Mekong/image6.jpg'),
    (8, N'Câu cá truyền thống', N'Trải nghiệm cảm giác câu cá truyền thống', '3', '06:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/SaiGon-Mekong/image7.jpgg'),

-- Bali, Indonesia

    (9, N'Bãi biển Seminyak', N'Khám phá bãi biển Seminyak', '1', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Indonesia/image1.jpg'),
    (9, N'Đảo Ubud và các ngôi đền', N'Thăm đảo Ubud và các ngôi đền', '1', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Indonesia/image2.jpg'),
    (9, N'Tour núi lửa Kintamani và hồ Batur', N'Tour núi lửa Kintamani và hồ Batur', '2', '08:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Indonesia/image3.jpg'),
    (9, N'Lễ hội truyền thống Bali', N'Trải nghiệm lễ hội truyền thống Bali', '2', '17:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Indonesia/image4.jpg'),
    (9, N'Vườn bướm Taman Kupu-Kupu', N'Tham quan vườn bướm Taman Kupu-Kupu', '3', '13:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Indonesia/image5.jpg'),
    (9, N'Công viên nước Waterbom', N'Dạo chơi tại công viên nước Waterbom', '3', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Indonesia/image6.jpg'),
    (9, N'Tắm biển tại Nusa Dua', N'Tắm biển và thư giãn tại Nusa Dua', '3', '10:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Indonesia/image7.jpg'),
-- Kyoto, Japan

    (10, N'Vườn hoa Kinkaku-ji', N'Tham quan vườn hoa Kinkaku-ji', '1', '09:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Japan/image1.jpg'),
    (10, N'Đền Kiyomizu-dera', N'Thăm đền Kiyomizu-dera và ngắm cảnh', '1', '10:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Japan/image2.jpg'),
    (10, N'Chợ Nishiki', N'Khám phá chợ Nishiki và thử đặc sản', '2', '11:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Japan/image3.jpg'),
    (10, N'Khu phố Gion', N'Dạo chơi tại khu phố Gion', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Japan/image4.jpg'),
    (10, N'Tour Kyoto Imperial Palace', N'Tour hoàng cung Kyoto', '3', '13:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Japan/image5.jpg'),
    (10, N'Vườn hoa Arashiyama', N'Chiêm ngưỡng vườn hoa Arashiyama', '3', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Japan/image6.jpg'),
    (10, N'Khu phố Ponto-cho', N'Khám phá khu phố Ponto-cho vào ban đêm', '3', '18:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Japan/image7.jpg'),

-- New York City, USA

    (11, N'Thành phố New York', N'Tham quan trung tâm thành phố New York', '1', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/NewYork/image1.jpg'),
    (11, N'Central Park', N'Dạo chơi tại Central Park', '1', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/NewYork/image2.jpg'),
    (11, N'Bảo tàng nghệ thuật Metropolitan', N'Thăm bảo tàng nghệ thuật Metropolitan', '2', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/NewYork/image3.jpg'),
    (11, N'Khu phố Chinatown', N'Khám phá khu phố Chinatown', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/NewYork/image4.jpg'),
    (11, N'Tour tòa nhà Empire State', N'Tour tòa nhà Empire State', '3', '13:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/NewYork/image5.jpg'),
    (11, N'Sông Hudson', N'Dạo chơi trên sông Hudson', '3', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/NewYork/image6.jpg'),
    (11, N'Máng trượt trên tầng thượng', N'Trải nghiệm máng trượt trên tầng thượng', '3', '18:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/NewYork/image7.jpg'),

-- Chichen Itza, Mexico

    (12, N'Chichen Itza', N'Thăm di tích lịch sử Chichen Itza', '1', '09:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Mexico/image1.jpg'),
    (12, N'Cenote Ik Kil', N'Trải nghiệm bơi tại cenote Ik Kil', '1', '11:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Mexico/image2.jpg'),
    (12, N'Khu phố Valladolid', N'Khám phá khu phố Valladolid', '2', '12:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Mexico/image3.jpg'),
    (12, N'Hacienda Sotuta de Peón', N'Thăm Hacienda Sotuta de Peón', '2', '14:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Mexico/image4.jpg'),
    (12, N'Uxmal', N'Thăm di tích Uxmal', '3', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Mexico/image5.jpg'),
    (12, N'Chợ thủ công Mérida', N'Khám phá chợ thủ công Mérida', '3', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Mexico/image6.jpg'),
    (12, N'Tour biển họa tích Celestún', N'Trải nghiệm biển họa tích Celestún', '3', '07:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Mexico/image7.jpg'),
-- Sydney, Australia

    (13, N'Opera House Sydney', N'Thăm Nhà hát Opera Sydney', '1', '09:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Australia/image1.jpg'),
    (13, N'Circular Quay', N'Thăm bến tàu Circular Quay', '1', '10:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Australia/image2.jpg'),
    (13, N'Đảo Bondi', N'Thăm đảo Bondi và bãi biển', '2', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Australia/image3.jpg'),
    (13, N'Royal Botanic Garden', N'Thăm Vườn hoàng gia Botanic', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Australia/image4.jpg'),
    (13, N'Tour Taronga Zoo', N'Tour thú vật Taronga Zoo', '3', '13:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Australia/image5.jpg'),
    (13, N'Màn trình diễn đêm Vivid Sydney', N'Trải nghiệm màn trình diễn đêm Vivid Sydney', '4', '20:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Australia/image6.jpg'),
    (13, N'Máng trượt đồi núi lớn', N'Trải nghiệm máng trượt đồi núi lớn', '3', '19:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Australia/image7.jpg'),

-- Cappadocia, Turkey

    (14, N'Đảo bên cầu Cappadocia', N'Thăm đảo bên cầu Cappadocia', '1', '09:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Turkey/image1.jpg'),
    (14, N'Ngôi làng Goreme', N'Thăm ngôi làng Goreme và các động', '1', '10:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Turkey/image2.jpg'),
    (14, N'Khu phố thổ dân Avanos', N'Khám phá khu phố thổ dân Avanos', '2', '11:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Turkey/image3.jpg'),
    (14, N'Khu vực thảo nguyên Uchisar', N'Thăm khu vực thảo nguyên Uchisar', '2', '15:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Turkey/image4.jpg'),
    (14, N'Chợ người thợ làm đá', N'Thăm chợ người thợ làm đá', '3', '14:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Turkey/image5.jpg'),
    (14, N'Tour bằng khinh khí cầu', N'Trải nghiệm tour bằng khinh khí cầu', '3', '06:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Turkey/image6.jpg'),
    (14, N'Đêm trên thảo nguyên', N'Trải nghiệm đêm trên thảo nguyên', '3', '20:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Turkey/image7.jpg'),

--  Dubai, United Arab Emirates
    (15, N'Tòa nhà Burj Khalifa', N'Thăm tòa nhà Burj Khalifa', '1', '10:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Dubai/image1.jpg'),
    (15, N'Chợ vàng Dubai', N'Thăm chợ vàng Dubai', '1', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Dubai/image2.jpg'),
    (15, N'Khu phố cổ Al Fahidi', N'Khám phá khu phố cổ Al Fahidi', '2', '13:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Dubai/image3.jpg'),
    (15, N'Khu vực thủy cung Atlantis', N'Thăm khu vực thủy cung Atlantis', '2', '14:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Dubai/image4.jpg'),
    (15, N'Tour trên sa mạc', N'Trải nghiệm tour trên sa mạc', '3', '16:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Dubai/image5.jpg'),
    (15, N'Khu phố Sheikh Zayed Road', N'Khám phá khu phố Sheikh Zayed Road', '3', '18:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Dubai/image6.jpg'),
    (15, N'Dịch vụ sang trọng', N'Trải nghiệm dịch vụ sang trọng', '3', '20:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Dubai/image7.jpg'),

--  Santorini, Greece
    (16, N'Fira', N'Thăm thị trấn Fira', '1', '10:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Greece/image1.jpg'),
    (16, N'Oia', N'Thăm làng Oia và ngắm hoàng hôn', '1', '11:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Greece/image2.jpg'),
    (16, N'Amoudi Bay', N'Thăm vịnh Amoudi Bay', '2', '13:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Greece/image3.jpg'),
    (16, N'Khu vườn nho Megalochori', N'Chiêm ngưỡng khu vườn nho Megalochori', '2', '15:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Greece/image4.jpg'),
    (16, N'Perivolos Beach', N'Tắm biển tại Perivolos Beach', '3', '16:30:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Greece/image5.jpg'),
    (16, N'Đảo Nea Kameni', N'Thăm đảo Nea Kameni và núi lửa', '4', '10:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Greece/image6.jpg'),
    (16, N'Nắng hoàng hôn tại Skaros', N'Trải nghiệm nắng hoàng hôn tại Skaros', '3', '18:00:00', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Greece/image7.jpg');
	
	select * from tour_images
	--thêm hình ảnh cho tour
	 INSERT INTO tour_images(tour_id,avatar, image1, image2, image3, image4, image5 )
 VALUES
 (1,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018141/Travel_FPoly/Image_Tourism/Da_Nang/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Da_Nang/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Da_Nang/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Da_Nang/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Da_Nang/image5.jpg'
  ),
  (2,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Ha_Long_Bay/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image5.jpg'
  ),
  (3,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/ITALY/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/ITALY/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/ITALY/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/ITALY/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/ITALY/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/ITALY/image5.jpg'
  ),
   (4,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Old_City_HoiAn/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image5.jpg'
  ),
  (5,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/VungTau/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/VungTau/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/VungTau/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/VungTau/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/VungTau/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/VungTau/image5.jpg'
  ),
  (6,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/TayBac/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/TayBac/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/TayBac/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/TayBac/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/TayBac/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/TayBac/image5.jpg'
  ),
  (7,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Paris/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Paris/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Paris/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Paris/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Paris/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Paris/image5.jpg'
  ),
  (8,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/SaiGon-MeKong/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/SaiGon-MeKong/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/SaiGon-MeKong/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/SaiGon-MeKong/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/SaiGon-MeKong/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/SaiGon-MeKong/image5.jpg'
  ),
  (9,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Indonesia/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Indonesia/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Indonesia/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Indonesia/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Indonesia/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Indonesia/image5.jpg'
  ),
  (10,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Japan/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Japan/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Japan/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Japan/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Japan/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Japan/image5.jpg'
  ),
  (11,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/NewYork/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/NewYork/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/NewYork/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/NewYork/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/NewYork/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/NewYork/image5.jpg'
  ),
  (12,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Mexico/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Mexico/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Mexico/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Mexico/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Mexico/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Mexico/image5.jpg'
  ),
  (13,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Australia/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Australia/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Australia/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Australia/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Australia/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Australia/image5.jpg'
  ),
  (14,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Turkey/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Turkey/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Turkey/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Turkey/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Turkey/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Turkey/image5.jpg'
  ),
  (15,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Dubai/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Dubai/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Dubai/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Dubai/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Dubai/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Dubai/image5.jpg'
  ),
  (16,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Greece/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Greece/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Greece/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Greece/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Greece/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Greece/image5.jpg'
 ),
 (17,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Peru/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Peru/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Peru/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Peru/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Peru/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Peru/image5.jpg'
 ),
 (18,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Zambia/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Zambia/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Zambia/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Zambia/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Zambia/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Zambia/image5.jpg'
  ),
  (19,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Jordan/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Jordan/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Jordan/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Jordan/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Jordan/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Jordan/image5.jpg'
 );
 
-- Insert CategoryHotel
Insert into category_hotels (name)
values
(N'Khách sạn Sang Trọng'),
(N'Khách sạn Biển Bungalow'),
(N'Khu Nghỉ Dưỡng Resort'),
(N'Khách sạn Thành Phố'),
(N'Khách sạn Công Nghệ Cao'),
(N'Khu Nghỉ Mát Cao Cấp'),
(N'Khách sạn Lãng Mạn'),
(N'Khách sạn Gia Đình'),
(N'Khu Nghỉ Dưỡng Xanh'),
(N'Khách sạn Phong Cách Cổ')

--Insert category Room
INSERT INTO category_rooms (name)
VALUES
    (N'Phòng Đơn'),
    (N'Phòng Đôi'),
    (N'Phòng Gia Đình'),
    (N'Phòng Hạng Sang'),
    (N'Phòng Suite'),
    (N'Phòng Studio'),
    (N'Phòng Biển View'),
    (N'Phòng Cao Cấp'),
    (N'Phòng Góc'),
    (N'Phòng Giường Kích Thước Lớn');

--Insert Hotel
Insert Into hotels(category_hotel_id,category_room_id,name,available,description,start,address,map,price,quantity)
values
(1, 1, N'Acor Hotel', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', 5, N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(2, 2, N'Hilton Hotel', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', 5, N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(3, 3, N'Marriott Hotel', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', 5, N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(4, 4, N'Plateno Hotel', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', 5, N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(5, 5, N'Hotel Six Senses', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', 5, N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(6, 6, N'Bess West Tem', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', 5, N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(7, 7, N'CHI Hotel', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', 5, N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(8, 8, N'InterContinental Hotels', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', 5, N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(9, 9, N'Starwood Hotel', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', 5, N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(10, 10, N'Wyndham Hotel', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', 5, N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10)


-- Insert Hotel Image
INSERT INTO hotel_images(hotel_id,avatar, image1, image2, image3, image4, image5 )
 VALUES
 (1,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018141/Travel_FPoly/Image_Hotel/Accor/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Hotel/Accor/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Accor/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Accor/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Accor/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Accor/image5.jpg'
  ),
  (2,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (3,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Marriott_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Marriott_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Marriott_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Marriott_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Marriott_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Marriott_Hotel/image5.jpg'
  ),
  (4,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Plateno_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Plateno_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Plateno_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Plateno_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Plateno_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Plateno_Hotel/image5.jpg'
  ),
  (5,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hotel_Six_Senses/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hotel_Six_Senses/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hotel_Six_Senses/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hotel_Six_Senses/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hotel_Six_Senses/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hotel_Six_Senses/image5.jpg'
  ),
  (6,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Best_Western_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Best_Western_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Best_Western_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Best_Western_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Best_Western_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Best_Western_Hotel/image5.jpg'
  ),
  (7,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/CHI_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/CHI_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/CHI_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/CHI_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/CHI_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/CHI_Hotel/image5.jpg'
  ),
  (8,
	'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014869/Travel_FPoly/Image_Hotel/InterCondinetal_Hotel/avatar.jpg',
	 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/InterContinental_Hotel/image1.jpg',
	 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/InterContinental_Hotel/image2.jpg',
	 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/InterContinental_Hotel/image3.jpg',
	 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/InterContinental_Hotel/image4.jpg',
	 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/InterContinental_Hotel/image5.jpg'
  ),
  (9,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Wyndham_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Wyndham_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Wyndham_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Wyndham_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Wyndham_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Wyndham_Hotel/image5.jpg'
  ),
  (10,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Starwood_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Starwood_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Starwood_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Starwood_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Starwood_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Starwood_Hotel/image5.jpg'
  );
  use travel
  select *from order_detail_tours
  select * from category_tours
  select * from order_hotels
  select * from order_detail_hotels
  select * from tours
   select * from cart_items
  select * from accounts
	select * from tour_images
	select * from tour_schedules
	delete accounts where accounts.user_id = 24
INSERT INTO order_detail_tours (quantity_adult, quantity_children, price_adult, price_children, total, star_date, end_date, book_date, status, available, base64, tour_id, order_tour_id, account_id)
VALUES 
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-1-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-2-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-3-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-4-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-5-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-6-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-7-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-8-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-9-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-10-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-11-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2021-12-15', 1, 1, 'base64data1', 1, 1, 1),

(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-1-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-2-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-3-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-4-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-5-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-6-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-7-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-8-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-9-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-10-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-11-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2023-12-15', 1, 1, 'base64data1', 1, 1, 1),

(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2022-12-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2022-12-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2022-12-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2022-12-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2022-12-15', 1, 1, 'base64data1', 1, 1, 1),
(2, 1, 100.0, 50.0, 250, '2023-01-01', '2023-01-10', '2022-12-15', 1, 1, 'base64data1', 1, 1, 1);

Insert into order_hotels(name, address, email, phone)
VALUES
('tan','quan 12','tanduong@gmail.com','0977487714')

INSERT INTO order_detail_hotels (quantity, price, check_in, check_out, total, book_date, status, hotel_id, order_hotel_id, account_id)
VALUES 
(2, 100.0, '2023-01-01', '2023-01-10', 2.0, '2021-1-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-1-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-1-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 8.0, '2021-2-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-2-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-2-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-3-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-3-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-3-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-4-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-4-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-4-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-5-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-5-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-5-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-6-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-6-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 12.0, '2021-6-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-7-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-7-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 3.0, '2021-7-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-8-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-8-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 23.0, '2021-8-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-9-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-9-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-9-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 45.0, '2021-10-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-10-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-10-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 18.0, '2021-10-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-11-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-11-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 6.0, '2021-12-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-12-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-1-15', 1, 1, 1, 1),
(2, 100.0, '2023-01-01', '2023-01-10', 200.0, '2021-12-15', 1, 1, 1, 1)

	select @@version
	Microsoft SQL Server 2019 (RTM) - 15.0.2000.5 (X64)   Sep 24 2019 13:48:23   Copyright (C) 2019 Microsoft Corporation  Developer Edition (64-bit) on Windows 10 Home 10.0 <X64> (Build 22621: ) 

