use TravelFPoly;

	 INSERT INTO accounts(user_name, pass_word, activated, address,age, email, full_name, phone, role)
	 VALUES
	 --12345
	('tanduong','$2a$12$.FGCfBI6l8LlZgtT3q6dF.N73YqUgvjXQfod1tmO7wRltIaAtvYt.', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0),
	('vantu','$2a$12$9EOasLdiDY862Uk5O.yns.4q1F.16qER0yvSVGPAH23mKEFlN2N.a', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0),
	('thanhtu','$2a$12$Cy.IYIO9L0AYlmQ/V702Wungm1RCkc2ha./94c3W2rYjKQALjPfGy', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0),
	('thaitu','$2a$12$HoOJiQVGbO4QZv2q5gQRVeY2.P/.csyKJlE7tOhmVDPijID3OWafe', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0),
	('vantien','$2a$12$LFUDKedfUtczXdjZLKjOcuGXmEnWMztOAn5l48YElQqfyvf7fN8Ty', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0),
	('ngocdao','$2a$12$NwVtfl.g00dh6IzQqGpU8ualZEy6udx1ksKiLeysaIaiPzR/PghCG', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0),
	--123
	('tanduong001','$2a$12$dPw43chz4FBNO8zCrbQRFuYeS4UKUyqiayqF1PHhYgLHYh0FuTZ2S', 1, N'112 Trần Hưng Đạo',21, 'tanduong69@gmail.com', 'Dương Nhựt Tân', '0785123654',1),
	 ('thanhtu002','$2a$12$DqHKOXHtBvJutoE6zB3dxumwcs5r.InlhKN0we06pLj5fMKSkhg02', 1, N'338 Nguyễn Văn Quá',12, 'tuthanh22012003@gmail.com', 'Ung Thanh Tú', '07541254',1),
	 --1234
	 ('vantu003','$2a$12$a1rIDHNWRd/GhUCmOhJW6.0SrxFaF/gNSTESrULuey.ble4fCbSES', 1, N'168 Võ Văn Kiệt', 21, 'vantu@gmail.com', 'Tô Vân Tú', '0785123655',1)
	-- Thêm loại tours
	INSERT INTO category_tours (name) 
	VALUES
    (N'Thiên nhiên'),
    (N'Di tích lịch sử'),
    (N'Mạo hiểm'),
    (N'Nghỉ dưỡng');

	--Thêm tour
	INSERT INTO tours (category_tour_id, Name, Price, Available, Description)
VALUES
    (1, N'Đà Nẵng', 100, 1, N'Khám phá thiên nhiên tươi đẹp và hùng vĩ.'),
    (2, N'Vịnh Hạ Long', 80, 1, N'Khám phá những di tích lịch sử và văn hóa độc đáo.'),
    (3, N'Italy', 150, 1, N'Những trải nghiệm mạo hiểm đầy hấp dẫn.'),
    (4, N'Phố cổ Hội An', 200, 1, N'Nghỉ dưỡng tuyệt vời tại các khu resort sang trọng.'),
    (1, N'Vũng Tàu', 120, 1, N'Thư giãn và tận hưởng biển xanh, cát trắng.'),
    (2, N'Tây Bắc', 180, 1, N'Hành trình chinh phục đỉnh núi cao.'),
    (3, N'Paris', 90, 1, N'Khám phá các di sản văn hóa của nhân loại được UNESCO công nhận.'),
	(1, N'Đà Nẵng', 120, 1, N'Khám phá vẻ đẹp thôn quê yên bình và hấp dẫn.'),
    (1, N'Vũng Tàu', 250, 1, N'Trải nghiệm lặn biển và khám phá đại dương sinh sôi.'),
    (2, N'Phố cổ Hội An', 70, 1, N'Thăm thú các chùa và đền đài tôn giáo độc đáo.'),
    (3, N'Tây Bắc', 180, 1, N'Hành trình vượt qua đồi núi hiểm trở.'),
    (1, N'Tây Bắc', 80, 1, N'Thưởng thức cảnh hoàng hôn đẹp nhất.'),
    (2, N'Đà Nẵng', 100, 1, N'Đi dạo và khám phá các khu phố cổ truyền thống.'),
    (1, N'Italy', 190, 1, N'Khám phá hang động bí ẩn với nhiều điều kỳ thú.'),
    (4, N'Paris', 120, 1, N'Trải nghiệm du lịch bằng xe đạp qua các cảnh đẹp.'),
    (3, N'Phố cổ Hội An', 90, 1, N'Thăm thú thung lũng hoa rực rỡ màu sắc.'),
    (1, N'Đà Nẵng', 110,1, N'Khám phá kiến trúc đương đại độc đáo.'),
    (2, N'Vịnh Hạ Long', 220, 1, N'Du ngoạn và khám phá đảo hoang sơ.'),
    (4, N'Vũng Tàu', 150, 1, N'Tiếp cận văn hóa bộ lạc bản địa truyền thống.');
	--thêm lịch trình
	INSERT INTO tour_schedules(tour_id, title, description, time)
VALUES
    -- Lịch trình cho TourId = 1
    (1, N'Lịch trình ngày 1', N'Lịch trình tham quan các điểm du lịch trong ngày đầu tiên.',  '09:00:00'),
    (1, N'Lịch trình ngày 2', N'Lịch trình các hoạt động ngoài trời trong ngày thứ hai.',  '10:30:00'),
    (1, N'Lịch trình ngày 3', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ ba.', '08:45:00'),
    (1, N'Lịch trình ngày 4', N'Lịch trình nghỉ ngơi và thưởng thức món ăn địa phương.',   '12:00:00'),

    -- Lịch trình cho TourId = 2
    (2, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',  '09:15:00'),
    (2, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',  '10:00:00'),
    (2, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',   '11:30:00'),
    (2, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),
	
	(3, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',  '09:15:00'),
    (3, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',    '10:00:00'),
    (3, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',   '11:30:00'),
    (3, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',   '09:45:00'),

	(4, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',  '09:15:00'),
    (4, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',  '10:00:00'),
    (4, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',  '11:30:00'),
    (4, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),

	(5, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',  '09:15:00'),
    (5, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',  '10:00:00'),
    (5, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',  '11:30:00'),
    (5, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),

	(6, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',  '09:15:00'),
    (6, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',   '10:00:00'),
    (6, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',   '11:30:00'),
    (6, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),

	(7, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',   '09:15:00'),
    (7, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',   '10:00:00'),
    (7, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',   '11:30:00'),
    (7, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),

	(8, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',  '09:15:00'),
    (8, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',  '10:00:00'),
    (8, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',    '11:30:00'),
    (8, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',   '09:45:00'),

	(9, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',    '09:15:00'),
    (9, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',   '10:00:00'),
    (9, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',   '11:30:00'),
    (9, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',   '09:45:00'),

	(10, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',   '09:15:00'),
    (10, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',    '10:00:00'),
    (10, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',  '11:30:00'),
    (10, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',   '09:45:00'),

	(11, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',   '09:15:00'),
    (11, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',    '10:00:00'),
    (11, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',    '11:30:00'),
    (11, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),

	(12, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',   '09:15:00'),
    (12, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',  '10:00:00'),
    (12, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',  '11:30:00'),
    (12, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),

	(13, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',  '09:15:00'),
    (13, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',   '10:00:00'),
    (13, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',     '11:30:00'),
    (13, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',   '09:45:00'),

	(14, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',   '09:15:00'),
    (14, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',  '10:00:00'),
    (14, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',   '11:30:00'),
    (14, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),

	(15, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',   '09:15:00'),
    (15, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',   '10:00:00'),
    (15, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '11:30:00'),
    (15, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',   '09:45:00'),

	(16, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',   '09:15:00'),
    (16, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',  '10:00:00'),
    (16, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.',  '11:30:00'),
    (16, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),

	(17, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '09:15:00'),
    (17, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',  '10:00:00'),
    (17, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '11:30:00'),
    (17, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),

	(18, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',  '09:15:00'),
    (18, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '10:00:00'),
    (18, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '11:30:00'),
    (18, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.',  '09:45:00'),

	(19, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.',   '09:15:00'),
    (19, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.',  '10:00:00'),
    (19, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '11:30:00'),
    (19, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '09:45:00')
	;

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
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/VungTau/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/VungTau/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/VungTau/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/VungTau/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/VungTau/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/VungTau/image5.jpg'
  ),
  (4,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/TayBac/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/TayBac/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/TayBac/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/TayBac/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/TayBac/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/TayBac/image5.jpg'
  ),
  (5,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Paris/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Paris/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Paris/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Paris/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Paris/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Paris/image5.jpg'
  ),
  (6,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/ITALY/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/ITALY/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/ITALY/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/ITALY/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/ITALY/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/ITALY/image5.jpg'
  ),
  (7,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Old_City_HoiAn/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Tourism/Old_City_HoiAn/image5.jpg'
  ),
  (8,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (9,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (10,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (11,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (12,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (13,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (14,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (15,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (16,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (17,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (18,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  ),
  (19,
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  )

  --Thêm bảng chi tiết tour
  insert into tour_variants(tour_id,departure,quantity,quantity_children,destination,date,map,introduction,duration)
  VALUES
    (1, N'Hà Nội', 10,5, N'Hạ Long Bay', '2023-08-20', 'https://example.com/map_halong', N'Hành trình khám phá vịnh Hạ Long đẹp nhất Việt Nam.',3),
    (2, N'Hà Nội', 10,5, N'Sapa', '2023-09-02', 'https://example.com/map_sapa', N'Khám phá vùng cao nguyên bí ẩn và thăm thú bản làng Sapa.',3),
    (3, N'Hồ Chí Minh', 10, 5, N'Đà Lạt', '2023-08-25', N'https://example.com/map_dalat', N'Du ngoạn thành phố ngàn hoa và thưởng thức không khí trong lành.',3),
    (4, N'Hồ Chí Minh', 10, 5, N'Cần Thơ', '2023-09-10', 'https://example.com/map_cantho', N'Khám phá vùng đồng bằng sông Cửu Long và trải nghiệm văn hóa miền Tây.',3),
    (5, N'Đà Nẵng', 10, 5, N'Hội An', '2023-08-15', 'https://example.com/map_hoian', N'Tham quan các di sản văn hóa tại phố cổ Hội An.',3),
    (6, N'Đà Nẵng', 10, 5, N'Huế', '2023-09-05', 'https://example.com/map_hue', N'Khám phá các di tích lịch sử và kiến trúc cổ đại của đô thành Huế.',3),
	(7, N'Hà Nội', 10, 5, N'Tam Đảo', '2023-08-20', 'https://example.com/map_tamdao', N'Du ngoạn cao nguyên mát mẻ với Tam Đảo xinh đẹp.',3),
    (8, N'Hà Nội', 10, 5, N'Mai Châu', '2023-09-02', 'https://example.com/map_maichau', N'Khám phá văn hóa dân tộc sắc sảo tại Mai Châu.',3),
    (9, N'Hồ Chí Minh', 10, 5, N'Phú Quốc', '2023-08-25', 'https://example.com/map_phuquoc', N'Thư giãn và tận hưởng biển xanh tại đảo ngọc Phú Quốc.',3),
    (10, N'Hồ Chí Minh', 10, 5, N'Côn Đảo', '2023-09-10', 'https://example.com/map_condao', N'Khám phá cảnh đẹp hoang sơ của quần đảo Côn Đảo.',3),
    (11, N'Đà Nẵng', 10, 5, N'Bà Nà Hills', '2023-08-15', 'https://example.com/map_banahills', N'Trải nghiệm cảm giác mạnh tại khu du lịch Bà Nà Hills.',3),
    (12, N'Đà Nẵng', 10, 5, N'Cù Lao Chàm', '2023-09-05', 'https://example.com/map_culaocham', N'Thư giãn và ngắm san hô tuyệt đẹp tại Cù Lao Chàm.',3),
	(13, N'Hà Nội', 10, 5, N'Mộc Châu', '2023-08-20', 'https://example.com/map_mocchau', N'Khám phá vùng cao nguyên Mộc Châu tuyệt đẹp vào mùa hoa tam giác mạch.',3),
    (14, N'Hà Nội', 10, 5, N'Điện Biên', '2023-09-02', 'https://example.com/map_dienbien', N'Thăm thú các di tích lịch sử và văn hóa độc đáo tại Điện Biên Phủ.',3),
    (15, N'Hồ Chí Minh', 10, 5, N'Vũng Tàu', '2023-08-25', 'https://example.com/map_vungtau', N'Thưởng thức các món hải sản tươi ngon và tắm biển tại Vũng Tàu.',3),
    (16, N'Hồ Chí Minh', 10, 5, N'Cần Giờ', '2023-09-10', 'https://example.com/map_cangio', N'Khám phá vùng đồng bằng sông Sài Gòn và hệ sinh thái đa dạng tại Cần Giờ.',3),
    (17, N'Đà Nẵng', 10, 5, 'Bán đảo Sơn Trà', '2023-08-15', 'https://example.com/map_sontra', N'Tham quan cảnh đẹp hoang sơ của bán đảo Sơn Trà.',3),
    (18, N'Đà Nẵng', 10, 5, N'Bà Nà Hills', '2023-09-05', 'https://example.com/map_banahills2', N'Tận hưởng không gian nghỉ dưỡng tại khu du lịch Bà Nà Hills.',3),
	(19, N'Hồ Chí Minh', 10, 5, N'Vũng Tàu', '2023-08-25', 'https://example.com/map_vungtau', N'Thưởng thức các món hải sản tươi ngon và tắm biển tại Vũng Tàu.',3);
   

 
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

  use TravelFPoly
  select *from order_detail_tours
  select * from category_tours
  select * from tours
  select * from tour_variants
  select * from accounts