create database Travel
use Travel;

	INSERT INTO intimates(name)
	values
	('Copper'),
	('Silver'),
	('Golden'),
	('Diamon')
	select * from intimates
	 INSERT INTO accounts(user_name, pass_word, activated, address,age, email, full_name, phone, role,intimate_id)
	 VALUES
	 --12345
	('tanduong','$2a$12$.FGCfBI6l8LlZgtT3q6dF.N73YqUgvjXQfod1tmO7wRltIaAtvYt.', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0,1),
	('vantu','$2a$12$9EOasLdiDY862Uk5O.yns.4q1F.16qER0yvSVGPAH23mKEFlN2N.a', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0,1),
	('thanhtu','$2a$12$Cy.IYIO9L0AYlmQ/V702Wungm1RCkc2ha./94c3W2rYjKQALjPfGy', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0,1),
	('thaitu','$2a$12$HoOJiQVGbO4QZv2q5gQRVeY2.P/.csyKJlE7tOhmVDPijID3OWafe', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0,1),
	('vantien','$2a$12$LFUDKedfUtczXdjZLKjOcuGXmEnWMztOAn5l48YElQqfyvf7fN8Ty', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0,1),
	('ngocdao','$2a$12$NwVtfl.g00dh6IzQqGpU8ualZEy6udx1ksKiLeysaIaiPzR/PghCG', 1, N'168 Võ Văn Kiệt', 21, 'duongnhuttan@gmail.com', 'Duong nhut tan', '0785123655',0,1),
	--123
	('tanduong001','$2a$12$dPw43chz4FBNO8zCrbQRFuYeS4UKUyqiayqF1PHhYgLHYh0FuTZ2S', 1, N'112 Trần Hưng Đạo',21, 'tanduong69@gmail.com', 'Dương Nhựt Tân', '0785123654',1,null),
	 ('thanhtu002','$2a$12$DqHKOXHtBvJutoE6zB3dxumwcs5r.InlhKN0we06pLj5fMKSkhg02', 1, N'338 Nguyễn Văn Quá',12, 'tuthanh22012003@gmail.com', 'Ung Thanh Tú', '07541254',1,null),
	 --1234
	 ('vantu003','$2a$12$a1rIDHNWRd/GhUCmOhJW6.0SrxFaF/gNSTESrULuey.ble4fCbSES', 1, N'168 Võ Văn Kiệt', 21, 'vantu@gmail.com', 'Tô Vân Tú', '0785123655',1,null)
	-- Thêm loại tours
	INSERT INTO category_tours (name) 
	VALUES
    (N'Thiên nhiên'),
    (N'Di tích lịch sử'),
    (N'Mạo hiểm'),
    (N'Nghỉ dưỡng');
	select * from category_tours
	select * from tours
	--Thêm tour
INSERT INTO tours (category_tour_id, Name, price_adult, price_children, quantity_adult, quantity_children, departure,
						destination, available, duration, description, introduction, map)
VALUES
    (1, N'Đà Nẵng', 100, 50, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Mở cửa cửa sổ ra biển xanh'
	,N'Chào mừng bạn đến với hành trình khám phá vẻ đẹp tươi mới và hấp dẫn tại thành phố Đà Nẵng! Với danh tiếng là một điểm đến du lịch hàng đầu tại Việt Nam
	, Đà Nẵng hứa hẹn mang đến cho bạn những trải nghiệm đáng nhớ và phong cảnh thiên nhiên tuyệt đẹp.',''),
    (1, N'Vịnh Hạ Long', 80, 50, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Hành trình đến vùng đất thần tiên trên biển'
	,N'Vịnh Hạ Long, vùng biển kỳ diệu nằm ở bắc Việt Nam, là một trong những kỳ quan thiên nhiên tuyệt đẹp của thế giới
	. Với hàng nghìn đảo đá vôi đan xen trên biển xanh, Vịnh Hạ Long là biểu tượng của sự hùng vĩ và kỳ bí của thiên nhiên.',''),
    (4, N'Italy', 150, 75, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Khám phá vẻ đẹp văn hóa, lịch sử và nghệ thuật'
	,N'Italy - đất nước của những kiệt tác nghệ thuật vĩ đại, nền văn hóa đậm đà và lịch sử phong phú
	. Nằm ở Nam châu Âu, Italy có tầm ảnh hưởng lớn đến nền văn minh thế giới với những thành tựu vượt thời gian.',''),
    (2, N'Phố cổ Hội An', 200, 100, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Hành trình đi qua quá khứ và sắc màu văn hóa Việt Nam'
	, N'Nằm ở miền Trung Việt Nam, Phố Cổ Hội An được coi là một trong những điểm đến du lịch phải đến ít nhất một lần trong đời
	. Với kiến trúc cổ kính, đường phố mềm mại và vị trí ven biển, Hội An là một hội tụ của lịch sử, văn hóa và nét đẹp thiên nhiên.',''),
    (1, N'Vũng Tàu', 120, 60, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Nơi gặp gỡ biển xanh, lịch sử và hương vị hải sản'
	, N'Nằm cách thành phố Hồ Chí Minh khoảng 125 km về phía Đông Nam, Vũng Tàu là một thành phố biển quyến rũ với bãi biển dài, phong cảnh đa dạng và lịch sử độc đáo. Được biết đến như một điểm nghỉ dưỡng yên bình và một cảng biển quan trọng
	, Vũng Tàu là điểm đến lý tưởng cho những ai muốn tránh xa sự ồn ào của thành phố.',''),
    (3, N'Tây Bắc', 180, 90, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Hành trình khám phá vùng đất núi rừng hùng vĩ'
	, N'Khu vực Tây Bắc Việt Nam là một bức tranh thiên nhiên tuyệt đẹp với những dãy núi cao, rừng rậm và vùng đất bản làng của các dân tộc thiểu số đa dạng về văn hóa và truyền thống
	. Đây là nơi bạn có cơ hội tiếp xúc với thiên nhiên hoang sơ và tìm hiểu về cuộc sống bản địa độc đáo.',''),
    (4, N'Paris', 90, 45, 10, 10, N'Hồ Chí Minh', N'Đà Nẵng', 1, 3, N'Thành phố ánh sáng và lãng mạn'
	, N'Paris, thủ đô của nước Pháp, là một trong những thành phố nổi tiếng và lãng mạn nhất thế giới. Với kiến trúc đẹp mắt, nghệ thuật tuyệt vời, và phong cách sống đầy tinh tế
	, Paris là nơi tập trung của văn hóa, thời trang và ẩm thực.', '');
	--thêm lịch trình
	INSERT INTO tour_schedules(tour_id, title, description, time)
VALUES
    -- Lịch trình cho TourId = 1
    (1, N'Tham quan bãi biển Mỹ Khê'
	, N'Được xem là một trong những bãi biển đẹp nhất thế giới, bãi biển Mỹ Khê sở hữu cát trắng mịn màng và nước biển trong xanh, tạo điều kiện lý tưởng cho những hoạt động thư giãn và tận hưởng biển.'
	, '07:00:00'),
    (1, N'Tham quan Ngũ Hành Sơn '
	, N'Khu vực này nổi tiếng với những ngọn núi đá vôi hình thành nên những hình dáng độc đáo. Điểm đặc biệt là Tháp Bàn Thạch, nơi bạn có thể ngắm toàn cảnh vịnh Đà Nẵng từ trên cao.'
	, '07:0:00'),
    (1, N'Sông Hàn và Cầu Rồng'
	, N'Sông Hàn chia thành phố thành hai bên, tạo điểm nhấn độc đáo cho Đà Nẵng. Cầu Rồng là một biểu tượng của thành phố với khả năng "thở lửa" vào buổi tối, tạo nên cảnh quan tuyệt đẹp.'
	, '07:00:00'),
    (1, N'Bán Đảo Sơn Trà'
	, N'Nơi bạn có thể tìm thấy Linh Ứng Bảo Điển, tượng chúa Mẫu lớn thứ nhì thế giới. Từ đây, bạn có thể chiêm ngưỡng toàn cảnh Đà Nẵng và biển cả xanh biếc.'
	, '07:00:00'),

    -- Lịch trình cho TourId = 2
    (2, N'Đảo Sửng Sốt'
	, N'Đỉnh núi ở đây cung cấp tầm nhìn toàn cảnh của Vịnh Hạ Long từ trên cao. Đây cũng là nơi có bức tượng của Chủ tịch Hồ Chí Minh, tượng Quốc Mẫu và các điểm tham quan khác.'
	, '07:00:00'),
    (2, N'Hang Sửng Sốt'
	, N'Được coi là một kiệt tác tự nhiên, hang Sửng Sốt là nơi tụ họp của các hình thù đá vôi độc đáo, tạo nên không gian huyền bí và ma mị.'
	, '07:00:00'),
    (2, N'Đảo Yến'
	, N' Nơi có những ngôi nhà được xây dựng từ lông yến, đảo Yến là nơi quan trọng trong ngành nuôi yến và sản xuất sữa yến nổi tiếng.'
	, '07:00:00'),
    (2, N'Bãi Cháy'
	, N' Bãi biển cát trắng mịn màng và nước biển trong xanh là nơi thích hợp để tận hưởng ánh nắng mặt trời và thư giãn.'
	, '07:00:00'),
	
	(3, N'Tham quan thủ đô Italy'
	, N'Thủ đô Italy và một trong những thành phố cổ đại quan trọng nhất thế giới. Tại đây, bạn có thể thăm Colosseum, Di tích La Mã và Thánh địa Vatican với Nhà thờ Thánh Peter và Bảo tàng Thế giới Kitô giáo.'
	, '07:00:00'),
    (3, N'Firenze'
	, N' Nơi ra đời của Phục hưng, Florence có nhiều bảo tàng nghệ thuật nổi tiếng như Uffizi và Galleria dell Accademia, nơi có tác phẩm David của Michelangelo.'
	, '07:00:00'),
    (3, N'Venice', N'Thành phố độc đáo nổi tiếng với các kênh nước và kiến trúc lâu đời. Điểm nhấn là Quảng trường Thánh Mark và Nhà thờ Thánh Mark, cũng như trải nghiệm du thuyền trên kênh Grand Canal.'
	, '07:00:00'),
    (3, N'Milano '
	, N'Trung tâm thời trang và tài chính của Italy. Tại đây, bạn có thể thăm Cung điện Milan, Nhà thờ Milan và Bảo tàng La Scala.'
	, '07:00:00'),

	(4, N'Nhà Cổ Phùng Hưng'
	, N'Một ngôi nhà cổ kính bậc nhất tại Hội An, nơi giữ gìn nét đẹp và kiến trúc của thời phong kiến.	'
	, '07:00:00'),
    (4, N'Chùa Cầu'
	, N'Biểu tượng của Hội An, cây cầu cổ này kết hợp kiến trúc Nhật Bản và Trung Quốc, mang trong mình nét độc đáo.'
	, '07:00:00'),
    (4, N'Phố Hội'
	, N'Đây là trung tâm sầm uất của Hội An với hàng loạt cửa hàng, chợ và nhà hàng. Đêm xuống, phố Hội sáng bừng với đèn lồng và hoạt động vui chơi, mua sắm.'
	, '07:00:00'),
    (4, N'Bảo Tàng Văn Hóa Sa Huỳnh'
	, N'Bảo tàng này giúp bạn tìm hiểu về cuộc sống của người dân Sa Huỳnh cổ đại qua các hiện vật khảo cổ.'
	, '07:00:00'),

	(5, N'Bãi Trước và Bãi Dứa'
	, N'Hai bãi biển nổi tiếng tại Vũng Tàu với cát trắng mịn và nước biển trong xanh. Đây là nơi tuyệt vời để tận hưởng ánh nắng mặt trời và biển xanh.'
	, '07:00:00'),
    (5, N'Núi Nhạn'
	, N'Từ đỉnh núi Nhạn, bạn có thể chiêm ngưỡng toàn cảnh thành phố Vũng Tàu và biển cả rộng lớn.'
	, '07:00:00'),
    (5, N'Tượng Chúa Kitô Vua'
	, N'Tượng Chúa Kitô toả sáng trên đỉnh đồi Nhạn, tạo nên một hình ảnh ấn tượng khi đêm xuống.'
	, '07:00:00'),
    (5, N'Hải Đăng Vũng Tàu'
	, N'Hải đăng lịch sử này có tháp cao và cung cấp tầm nhìn tốt để ngắm cảnh biển rộng.'
	, '07:00:00'),

	(6, N'Sapa'
	, N'Được biết đến với khí hậu mát mẻ, rừng sương mù và những cánh đồng lúa bậc thang tuyệt đẹp, Sapa là một điểm đến lý tưởng cho việc tham quan thiên nhiên và văn hóa bản địa.'
	, '07:00:00'),
    (6, N'Điện Biên'
	, N'Là nơi diễn ra trận chiến Điện Biên Phủ quyết định, thành phố này mang trong mình lịch sử lớn về cuộc chiến tranh Việt Nam.'
	, '07:00:00'),
    (6, N'Mù Cang Chải'
	, N'Vùng đồi núi bậc thang tại Mù Cang Chải là điểm đến tuyệt vời để ngắm cảnh và chứng kiến cuộc sống bản địa.'
	, '07:00:00'),
    (6, N'Tham Quan Bản Làng Bản Địa'
	, N'Tây Bắc có nhiều bản làng của các dân tộc thiểu số như Hmong, Dao, Tày... Hãy thăm những bản làng này để tìm hiểu về văn hóa và phong tục truyền thống.'
	, '07:00:00'),

	(7, N'Tháp Eiffel'
	, N'Biểu tượng vĩnh cửu của Paris, tháp Eiffel là nơi bạn có thể ngắm toàn cảnh thành phố từ trên cao.'
	, '07:00:00'),
    (7, N'Lăng Kính Đài'
	, N'Nằm ở quảng trường Trocadéro, đây là nơi lý tưởng để có những bức ảnh đẹp về tháp Eiffel.'
	, '07:00:00'),
    (7, N'Louvre'
	, N'Một trong những bảo tàng nghệ thuật lớn nhất thế giới, Louvre chứa hàng ngàn tác phẩm nghệ thuật quý giá.'
	, '07:00:00'),
    (7, N'Montmartre'
	, N'Khu phố nghệ sĩ và lễ đài Basilique du Sacré-Cœur nằm ở đây, tạo nên một không gian văn hóa và tâm linh.'
	, '07:00:00');
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
  );
  use Travel
select * from category_hotels
select * from category_rooms
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