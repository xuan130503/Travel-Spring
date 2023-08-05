use TravelFPoly
ALTER TABLE admins
ALTER COLUMN account varchar(50)
 INSERT INTO admins( account, activated, [address], email, full_name, pass_word, phone, [role], [image])
 VALUES( 'tanduong001', 1, '112 Trần Hưn g Đạo', 'tanduong69@gmail.com', 'Dương Nhựt Tân', '123abc', '0785123654',1, '')
 INSERT INTO admins( account, activated, [address], email, full_name, pass_word, phone, [role], [image])
 VALUES( 'thanhtu002', 1, '338 Nguyễn Văn Quá', 'tuthanh22012003@gmail.com', 'Ung Thanh Tú', '123abc', '07541254',1, '')
 INSERT INTO admins( account, activated, [address], email, full_name, pass_word, phone, [role], [image])
 VALUES( 'vantu003', 1, '168 Võ Văn Kiệt', 'vantu@gmail.com', 'Tô Vân Tú', '123abc', '0785123655',1, '')
 INSERT INTO admins( account, activated, [address], email, full_name, pass_word, phone, [role], [image])
 VALUES( 'vantien004', 1, '78/2 Trần Thị Điệu', 'vantien21@gmail.com', 'Trần Văn Tiến', '123abc', '0785122654',1, '')
 INSERT INTO admins( account, activated, [address], email, full_name, pass_word, phone, [role], [image])
 VALUES( 'ngocdao005', 1, '719 Phạm Văn Đồng', 'ngocdao78@gmail.com', 'Trần Ngọc Đào', '123abc', '0785123654',1, '')
 INSERT INTO admins( account, activated, [address], email, full_name, pass_word, phone, [role], [image])
 VALUES( 'thaitu006', 1, '54/4 Tô Ký', 'thaitu@gmail.com', 'Trịnh Thái Tú', '123abc', '0785124754',1, '')

 INSERT INTO category_hotels([name])
 VALUES('Nhân Đức')
  INSERT INTO category_hotels([name])
 VALUES('Lotte Hotel Seoul')
  INSERT INTO category_hotels([name])
 VALUES('Park Hyatt Busan')
  INSERT INTO category_hotels([name])
 VALUES(' Maison Glad Jeju')
  INSERT INTO category_hotels([name])
 VALUES('Mondrian Seoul Itaewon')
  INSERT INTO category_hotels([name])
 VALUES('Emirates Palace')
  INSERT INTO category_hotels([name])
 VALUES(' Wilson President')
  INSERT INTO category_hotels([name])
 VALUES('Lagonissi – Athen')
  INSERT INTO category_hotels([name])
 VALUES('The Raj Palace, Jaipur')
  INSERT INTO category_hotels([name])
 VALUES('Palms Casino Resort')
  INSERT INTO category_hotels([name])
 VALUES('Cala di Volpe')
  INSERT INTO category_hotels([name])
 VALUES(' Plaza Athenee')
   INSERT INTO category_hotels([name])
 VALUES(' Plaza Athenee') 

 INSERT INTO category_hotels([name])
 VALUES(' Intercontinental') 
 INSERT INTO category_hotels([name])
 VALUES(' Intercontinental') 
 INSERT INTO category_hotels([name])
 VALUES(' Rosewood Hotel') 
 INSERT INTO category_hotels([name])
 VALUES('  Aman')
 INSERT INTO category_hotels([name])
 VALUES(' St Reis') 
 INSERT INTO category_hotels([name])
 VALUES(' Mandarin') 
 INSERT INTO category_hotels([name])
 VALUES(' Banyan Tree') 
 INSERT INTO category_hotels([name])
 VALUES(' Peninsula Hotels')

 INSERT INTO category_rooms([name])
 VALUES(' 001')
  INSERT INTO category_rooms([name])
 VALUES(' 002')
  INSERT INTO category_rooms([name])
 VALUES(' 003')
  INSERT INTO category_rooms([name])
 VALUES(' 004')
  INSERT INTO category_rooms([name])
 VALUES(' 005')
  INSERT INTO category_rooms([name])
 VALUES(' 006')
  INSERT INTO category_rooms([name])
 VALUES(' 007')
  INSERT INTO category_rooms([name])
 VALUES(' 008')
  INSERT INTO category_rooms([name])
 VALUES(' 009')
  INSERT INTO category_rooms([name])
 VALUES(' 010')
  INSERT INTO category_rooms([name])
 VALUES(' 011')
  INSERT INTO category_rooms([name])
 VALUES(' 012')
  INSERT INTO category_rooms([name])
 VALUES(' 013')
  INSERT INTO category_rooms([name])
 VALUES(' 014')
  INSERT INTO category_rooms([name])
 VALUES(' 015')
  INSERT INTO category_rooms([name])
 VALUES(' 016')
 INSERT INTO category_rooms([name])
 VALUES(' 017')
  INSERT INTO category_rooms([name])
 VALUES(' 018')
  INSERT INTO category_rooms([name])
 VALUES(' 019')
  INSERT INTO category_rooms([name])
 VALUES(' 020')
  INSERT INTO category_rooms([name])
 VALUES(' 021')
  INSERT INTO category_rooms([name])
 VALUES(' 022')
  INSERT INTO category_rooms([name])
 VALUES(' 023')

  INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Los Angeles', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' Maison Glad Jeju', 500, 30, 5)
 
  INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' Lotte Hotel Seoul', 300, 40, 5)
 
  INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' LPark Hyatt Busan', 200, 70, 4)
 
  INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' Intercontinental', 200, 50, 3)
 
  INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' Cala di Volpe', 600, 50, 5)
 
  INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' Plaza Athenee', 800, 50, 4)
 
  INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' Mondrian Seoul Itaewon', 200, 50, 4)
 
  INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' Emirates Palace', 800, 50, 5)
 
  INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' Peninsula Hotels', 1000, 50, 2)
 
  INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' The Raj Palace, Jaipur', 900, 50, 2)
   INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' osewood Hotel', 700, 50, 4) 
 INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' Aman', 400, 50, 4) 
 INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' St Reis', 500, 50, 3) 
 INSERT INTO hotels([address], available, [description], [name], price, quantity, [start] )
 VALUES('Đà Nẵng', 1, 'Luôn luôn mang đến trải nghiệm tốt nhất đối với khách hàng', ' Mandarin', 20000, 70, 4)


 INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES(
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
  )
  INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690013899/Travel_FPoly/Image_Hotel/Marriott_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690013899/Travel_FPoly/Image_Hotel/Marriott_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690013899/Travel_FPoly/Image_Hotel/Marriott_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690013898/Travel_FPoly/Image_Hotel/Marriott_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690013898/Travel_FPoly/Image_Hotel/Marriott_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014024/Travel_FPoly/Image_Hotel/Marriott_Hotel/image5.jpg'
 )
   INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015571/Travel_FPoly/Image_Hotel/Plateno_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015568/Travel_FPoly/Image_Hotel/Plateno_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015568/Travel_FPoly/Image_Hotel/Plateno_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015568/Travel_FPoly/Image_Hotel/Plateno_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015568/Travel_FPoly/Image_Hotel/Plateno_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015568/Travel_FPoly/Image_Hotel/Plateno_Hotel/image5.jpg'
 )
    INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015559/Travel_FPoly/Image_Hotel/Starwood_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015560/Travel_FPoly/Image_Hotel/Starwood_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015558/Travel_FPoly/Image_Hotel/Starwood_Hotel/image3.webp',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015558/Travel_FPoly/Image_Hotel/Starwood_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015558/Travel_FPoly/Image_Hotel/Starwood_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015558/Travel_FPoly/Image_Hotel/Starwood_Hotel/image5.jpg'
 )
     INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016182/Travel_FPoly/Image_Hotel/CHI_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016182/Travel_FPoly/Image_Hotel/CHI_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016181/Travel_FPoly/Image_Hotel/CHI_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016181/Travel_FPoly/Image_Hotel/CHI_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016181/Travel_FPoly/Image_Hotel/CHI_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016181/Travel_FPoly/Image_Hotel/CHI_Hotel/image5.jpg'
 )
      INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015215/Travel_FPoly/Image_Hotel/Wyndham_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015216/Travel_FPoly/Image_Hotel/Wyndham_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015213/Travel_FPoly/Image_Hotel/Wyndham_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015204/Travel_FPoly/Image_Hotel/Wyndham_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015204/Travel_FPoly/Image_Hotel/Wyndham_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690015204/Travel_FPoly/Image_Hotel/Wyndham_Hotel/image5.jpg'
 )
       INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014869/Travel_FPoly/Image_Hotel/InterCondinetal_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014870/Travel_FPoly/Image_Hotel/InterCondinetal_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014870/Travel_FPoly/Image_Hotel/InterCondinetal_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014870/Travel_FPoly/Image_Hotel/InterCondinetal_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014867/Travel_FPoly/Image_Hotel/InterCondinetal_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014868/Travel_FPoly/Image_Hotel/InterCondinetal_Hotel/image5.jpg'
 )
     INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016168/Travel_FPoly/Image_Hotel/Best_Western_Hotel/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016210/Travel_FPoly/Image_Hotel/Best_Western_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016183/Travel_FPoly/Image_Hotel/Best_Western_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016168/Travel_FPoly/Image_Hotel/Best_Western_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016167/Travel_FPoly/Image_Hotel/Best_Western_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016167/Travel_FPoly/Image_Hotel/Best_Western_Hotel/image5.jpg'
 )
    INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016951/Travel_FPoly/Image_Hotel/Dalat%20Palace/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016950/Travel_FPoly/Image_Hotel/Dalat%20Palace/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016951/Travel_FPoly/Image_Hotel/Dalat%20Palace/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016951/Travel_FPoly/Image_Hotel/Dalat%20Palace/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016950/Travel_FPoly/Image_Hotel/Dalat%20Palace/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690016950/Travel_FPoly/Image_Hotel/Dalat%20Palace/image5.jpg'
 )
     INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017660/Travel_FPoly/Image_Hotel/Hotel%20Six%20Senses/avatar1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017644/Travel_FPoly/Image_Hotel/Hotel%20Six%20Senses/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017590/Travel_FPoly/Image_Hotel/Hotel%20Six%20Senses/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017552/Travel_FPoly/Image_Hotel/Hotel%20Six%20Senses/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017552/Travel_FPoly/Image_Hotel/Hotel%20Six%20Senses/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017551/Travel_FPoly/Image_Hotel/Hotel%20Six%20Senses/image5.jpg'
 )
     INSERT INTO hotel_images(avatar, image1, image2, image3, image4, image5 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017345/Travel_FPoly/Image_Hotel/Accor/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017345/Travel_FPoly/Image_Hotel/Accor/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017345/Travel_FPoly/Image_Hotel/Accor/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017345/Travel_FPoly/Image_Hotel/Accor/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017345/Travel_FPoly/Image_Hotel/Accor/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690017345/Travel_FPoly/Image_Hotel/Accor/image5.jpg'
 )
    
INSERT INTO tour_images(avatar, image1, image2, image3, image4, image5, image6,image7, image8, image9 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018141/Travel_FPoly/Image_Tourism/Da_Nang/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018092/Travel_FPoly/Image_Tourism/Da_Nang/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018091/Travel_FPoly/Image_Tourism/Da_Nang/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018090/Travel_FPoly/Image_Tourism/Da_Nang/image5.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018090/Travel_FPoly/Image_Tourism/Da_Nang/image6.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018090/Travel_FPoly/Image_Tourism/Da_Nang/image7.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018090/Travel_FPoly/Image_Tourism/Da_Nang/image8.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018095/Travel_FPoly/Image_Tourism/Da_Nang/image9.jpg'

 )
     
INSERT INTO tour_images(avatar, image1, image2, image3, image4, image5, image6,image7, image8, image9 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940772/Travel_FPoly/Image_Tourism/Ha_Long_Bay/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940609/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940609/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940609/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940608/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940608/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image5.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940608/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image6.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940608/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image7.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940608/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image8.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1689940608/Travel_FPoly/Image_Tourism/Ha_Long_Bay/image9.jpg'

 )
 INSERT INTO tour_images(avatar, image1, image2, image3, image4, image5, image6,image7, image8, image9 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image5.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image6.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image7.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image8.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018682/Travel_FPoly/Image_Tourism/ITALY/image9.jpg'

 )
 INSERT INTO tour_images(avatar, image1, image2, image3, image4, image5, image6,image7, image8, image9 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image5.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image6.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image7.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image8.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018511/Travel_FPoly/Image_Tourism/Paris/image9.jpg'
 )
 select *from tour_images
 INSERT INTO tour_images(avatar, image1, image2, image3, image4, image5, image6,image7, image8, image9 )
 VALUES( 
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018943/Travel_FPoly/Image_Tourism/VungTau/avatar.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image5.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image6.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image7.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image8.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690018942/Travel_FPoly/Image_Tourism/VungTau/image9.jpg'
 )
	SELECT * FROM tour_images

	INSERT INTO tours(available, [description], [name], price)
	VALUES(1, '	Khám phá những địa điểm đẹp trên  đất  nước  hình chữ S', 'Da Nang Tour',   1000)
	
	INSERT INTO tours(available, [description], [name], price)
	VALUES(1, '	Khám phá những địa điểm đẹp trên  đất  nước  hình chữ S', 'Ha  Long Bay Tour',   2000)
	
	INSERT INTO tours(available, [description], [name], price)
	VALUES(1, '	Tìm hiểu văn hóa , ẩm  thực trời Tây', 'Italy Trip',   10000)
	
	INSERT INTO tours(available, [description], [name], price)
	VALUES(1, '	Khám phá những địa điểm đẹp trên  đất  nước  hình chữ S', 'Da Nang Tour',   1000)
	
	INSERT INTO tours(available, [description], [name], price)
	VALUES(1, '	Tìm hiểu văn hóa , ẩm  thực trời Tây', 'Paris Tour',   10000)
	
	INSERT INTO tours(available, [description], [name], price)
	VALUES(1, '	Khám phá những địa điểm đẹp trên  đất  nước  hình chữ S', 'Ha Giang Tour',   1000)
	
	INSERT INTO tours(available, [description], [name], price)
	VALUES(1, '	Khám phá những địa điểm đẹp trên  đất  nước  hình chữ S', 'Vung Tau Tour',   1000)
	
	INSERT INTO users([user_name] ,activated, [address], age, email,  full_name, [image],  pass_word, phone, [role])
	VALUES('hung123', 1, '324 Phạm Văn Đồng',  '29' , 'hungvt@gmail.com', 'Trần Văn Hùng', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690022806/Travel_FPoly/Image--user/user.jpg', '2201' ,'0987658765', 0  )
		INSERT INTO users([user_name] ,activated, [address], age, email,  full_name, [image],  pass_word, phone, [role])
	VALUES('van2144', 1, '32 Xa Lộ Hà Nội',  '59',  'vanlth@gmail.com', 'Lê Thị Hồng Vân', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690022806/Travel_FPoly/Image--user/user.jpg', '123', '0987658765' ,0  )
		INSERT INTO users([user_name] ,activated, [address], age, email,  full_name, [image],  pass_word, phone, [role])
	VALUES('namgavai', 1, '76 Trường Chinh',  '22',  'namgv@gmail.com', 'Nguyễn Trần Nam', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690022806/Travel_FPoly/Image--user/user.jpg', '2201', '0987658765', 0  )
		INSERT INTO users([user_name] ,activated, [address], age, email,  full_name, [image],  pass_word, phone, [role])
	VALUES('hung4456', 1, '324 Quang Trung ',  '54',  'hungvtt@gmail.com', 'Tô Trần Văn Hùng', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690022806/Travel_FPoly/Image--user/user.jpg', '2201', '0987658765', 0  )
		INSERT INTO users([user_name] ,activated, [address], age, email,  full_name, [image],  pass_word, phone, [role])
	VALUES('hung789', 1, '329 Phạm Văn Đồng',  '19' , 'hungvtv@gmail.com', 'Nguyễn Thanh Hùng', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690022806/Travel_FPoly/Image--user/user.jpg', '2201', '0987658765', 0  )
		INSERT INTO users([user_name] ,activated, [address], age, email,  full_name, [image],  pass_word, phone, [role])
	VALUES('hung78990', 1, '57 Phạm Văn Đồng',  '20',  'hungntt@gmail.com', 'Nguyễn Trần  Thanh Hưng', 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690022806/Travel_FPoly/Image--user/user.jpg', '2201', '0987658765', 0  )




-- Mẫu Của Tân
	select * from category_tours
	delete category_tours
	-- Thêm loại tours
	INSERT INTO category_tours (name) 
	VALUES
    (N'Tour du lịch thiên nhiên'),
    (N'Tour tham quan di tích lịch sử'),
    (N'Tour du lịch mạo hiểm'),
    (N'Tour du lịch nghỉ dưỡng');

	--Thêm tour
	select *from tours
	INSERT INTO tours (category_tour_id, Name, Price, Available, Description)
VALUES
    (1, N'Tour du lịch tự nhiên', 100, 1, N'Khám phá thiên nhiên tươi đẹp và hùng vĩ.'),
    (2, N'Tour di tích lịch sử', 80, 1, N'Khám phá những di tích lịch sử và văn hóa độc đáo.'),
    (3, N'Tour mạo hiểm', 150, 1, N'Những trải nghiệm mạo hiểm đầy hấp dẫn.'),
    (4, N'Tour nghỉ dưỡng', 200, 1, N'Nghỉ dưỡng tuyệt vời tại các khu resort sang trọng.'),
    (1, N'Tour biển hấp dẫn', 120, 1, N'Thư giãn và tận hưởng biển xanh, cát trắng.'),
    (2, N'Tour leo núi', 180, 1, N'Hành trình chinh phục đỉnh núi cao.'),
    (3, N'Tour di sản văn hóa UNESCO', 90, 1, N'Khám phá các di sản văn hóa của nhân loại được UNESCO công nhận.'),
	(1, N'Tour cảnh quan đồng quê', 120, 1, N'Khám phá vẻ đẹp thôn quê yên bình và hấp dẫn.'),
    (1, N'Tour lặn biển', 250, 1, N'Trải nghiệm lặn biển và khám phá đại dương sinh sôi.'),
    (2, N'Tour chùa và đền đài', 70, 1, N'Thăm thú các chùa và đền đài tôn giáo độc đáo.'),
    (3, N'Tour leo dốc đồi núi', 180, 1, N'Hành trình vượt qua đồi núi hiểm trở.'),
    (1, N'Tour ngắm hoàng hôn', 80, 1, N'Thưởng thức cảnh hoàng hôn đẹp nhất.'),
    (2, N'Tour các khu phố cổ', 100, 1, N'Đi dạo và khám phá các khu phố cổ truyền thống.'),
    (1, N'Tour thám hiểm hang động', 190, 1, N'Khám phá hang động bí ẩn với nhiều điều kỳ thú.'),
    (4, N'Tour du lịch xe đạp', 120, 1, N'Trải nghiệm du lịch bằng xe đạp qua các cảnh đẹp.'),
    (3, N'Tour thung lũng hoa', 90, 1, N'Thăm thú thung lũng hoa rực rỡ màu sắc.'),
    (1, N'Tour kiến trúc đương đại', 110,1, N'Khám phá kiến trúc đương đại độc đáo.'),
    (2, N'Tour tham quan đảo', 220, 1, N'Du ngoạn và khám phá đảo hoang sơ.'),
    (4, N'Tour bộ lạc bản địa', 150, 1, N'Tiếp cận văn hóa bộ lạc bản địa truyền thống.');


	--thêm lịch trình
	select * from tour_schedules;

	INSERT INTO tour_schedules(tour_id, title, description, date, time)
VALUES
    -- Lịch trình cho TourId = 1
    (1, N'Lịch trình ngày 1', N'Lịch trình tham quan các điểm du lịch trong ngày đầu tiên.', '2023-08-10', '09:00:00'),
    (1, N'Lịch trình ngày 2', N'Lịch trình các hoạt động ngoài trời trong ngày thứ hai.', '2023-08-11', '10:30:00'),
    (1, N'Lịch trình ngày 3', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ ba.', '2023-08-12', '08:45:00'),
    (1, N'Lịch trình ngày 4', N'Lịch trình nghỉ ngơi và thưởng thức món ăn địa phương.', '2023-08-13', '12:00:00'),

    -- Lịch trình cho TourId = 2
    (2, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (2, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (2, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (2, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', N'2023-08-17', '09:45:00'),
	
	(3, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (3, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (3, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (3, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(4, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (4, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (4, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (4, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(5, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (5, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (5, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (5, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(6, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (6, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (6, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (6, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(7, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (7, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (7, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (7, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(8, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (8, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (8, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (8, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(9, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (9, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (9, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (9, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(10, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (10, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (10, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (10, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(11, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (11, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (11, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (11, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(12, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (12, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (12, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (12, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(13, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (13, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (13, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (13, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(14, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (14, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (14, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (14, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(15, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (15, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (15, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (15, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(16, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (16, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (16, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (16, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(17, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (17, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (17, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (17, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(18, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (18, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (18, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (18, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00'),

	(19, N'Lịch trình ngày 1', N'Lịch trình tham quan các chùa và đền đài trong ngày đầu tiên.', '2023-08-14', '09:15:00'),
    (19, N'Lịch trình ngày 2', N'Lịch trình tham quan các di tích lịch sử trong ngày thứ hai.', '2023-08-15', '10:00:00'),
    (19, N'Lịch trình ngày 3', N'Lịch trình các hoạt động ngoài trời và trải nghiệm độc đáo.', '2023-08-16', '11:30:00'),
    (19, N'Lịch trình ngày 4', N'Lịch trình thư giãn và tận hưởng phong cảnh đẹp.', '2023-08-17', '09:45:00')
	;
	--thêm hình ảnh cho tour
	select * from tours
	select * from tour_images
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
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image1.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014981/Travel_FPoly/Image_Hotel/Hilton_Hotel/image2.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image3.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014980/Travel_FPoly/Image_Hotel/Hilton_Hotel/image4.jpg',
 'https://res.cloudinary.com/dpyp2vvdm/image/upload/v1690014979/Travel_FPoly/Image_Hotel/Hilton_Hotel/image5.jpg'
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
  select * from tour_variants
  insert into tour_variants(tour_id,departure,quantity,destination,date,map,introduction)
  VALUES
    (1, N'Hà Nội', 20, N'Hạ Long Bay', '2023-08-20', 'https://example.com/map_halong', N'Hành trình khám phá vịnh Hạ Long đẹp nhất Việt Nam.'),
    (2, N'Hà Nội', 25, N'Sapa', '2023-09-02', 'https://example.com/map_sapa', N'Khám phá vùng cao nguyên bí ẩn và thăm thú bản làng Sapa.'),
    (3, N'Hồ Chí Minh', 15, N'Đà Lạt', '2023-08-25', N'https://example.com/map_dalat', N'Du ngoạn thành phố ngàn hoa và thưởng thức không khí trong lành.'),
    (4, N'Hồ Chí Minh', 18, N'Cần Thơ', '2023-09-10', 'https://example.com/map_cantho', N'Khám phá vùng đồng bằng sông Cửu Long và trải nghiệm văn hóa miền Tây.'),
    (5, N'Đà Nẵng', 12, N'Hội An', '2023-08-15', 'https://example.com/map_hoian', N'Tham quan các di sản văn hóa tại phố cổ Hội An.'),
    (6, N'Đà Nẵng', 14, N'Huế', '2023-09-05', 'https://example.com/map_hue', N'Khám phá các di tích lịch sử và kiến trúc cổ đại của đô thành Huế.'),
	(7, N'Hà Nội', 30, N'Tam Đảo', '2023-08-20', 'https://example.com/map_tamdao', N'Du ngoạn cao nguyên mát mẻ với Tam Đảo xinh đẹp.'),
    (8, N'Hà Nội', 25, N'Mai Châu', '2023-09-02', 'https://example.com/map_maichau', N'Khám phá văn hóa dân tộc sắc sảo tại Mai Châu.'),
    (9, N'Hồ Chí Minh', 20, N'Phú Quốc', '2023-08-25', 'https://example.com/map_phuquoc', N'Thư giãn và tận hưởng biển xanh tại đảo ngọc Phú Quốc.'),
    (10, N'Hồ Chí Minh', 15, N'Côn Đảo', '2023-09-10', 'https://example.com/map_condao', N'Khám phá cảnh đẹp hoang sơ của quần đảo Côn Đảo.'),
    (11, N'Đà Nẵng', 18, N'Bà Nà Hills', '2023-08-15', 'https://example.com/map_banahills', N'Trải nghiệm cảm giác mạnh tại khu du lịch Bà Nà Hills.'),
    (12, N'Đà Nẵng', 20, N'Cù Lao Chàm', '2023-09-05', 'https://example.com/map_culaocham', N'Thư giãn và ngắm san hô tuyệt đẹp tại Cù Lao Chàm.'),
	(13, N'Hà Nội', 25, N'Mộc Châu', '2023-08-20', 'https://example.com/map_mocchau', N'Khám phá vùng cao nguyên Mộc Châu tuyệt đẹp vào mùa hoa tam giác mạch.'),
    (14, N'Hà Nội', 20, N'Điện Biên', '2023-09-02', 'https://example.com/map_dienbien', N'Thăm thú các di tích lịch sử và văn hóa độc đáo tại Điện Biên Phủ.'),
    (15, N'Hồ Chí Minh', 15, N'Vũng Tàu', '2023-08-25', 'https://example.com/map_vungtau', N'Thưởng thức các món hải sản tươi ngon và tắm biển tại Vũng Tàu.'),
    (16, N'Hồ Chí Minh', 18, N'Cần Giờ', '2023-09-10', 'https://example.com/map_cangio', N'Khám phá vùng đồng bằng sông Sài Gòn và hệ sinh thái đa dạng tại Cần Giờ.'),
    (17, N'Đà Nẵng', 12, 'Bán đảo Sơn Trà', '2023-08-15', 'https://example.com/map_sontra', N'Tham quan cảnh đẹp hoang sơ của bán đảo Sơn Trà.'),
    (18, N'Đà Nẵng', 14, N'Bà Nà Hills', '2023-09-05', 'https://example.com/map_banahills2', N'Tận hưởng không gian nghỉ dưỡng tại khu du lịch Bà Nà Hills.'),
	(19, N'Hồ Chí Minh', 15, N'Vũng Tàu', '2023-08-25', 'https://example.com/map_vungtau', N'Thưởng thức các món hải sản tươi ngon và tắm biển tại Vũng Tàu.');
    
	-- Insert CategoryHotel

	use TravelFPoly
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
    ('Phòng Đơn'),
    ('Phòng Đôi'),
    ('Phòng Gia Đình'),
    ('Phòng Hạng Sang'),
    ('Phòng Suite'),
    ('Phòng Studio'),
    ('Phòng Biển View'),
    ('Phòng Cao Cấp'),
    ('Phòng Góc'),
    ('Phòng Giường Kích Thước Lớn');

--Insert Hotel

Insert Into hotels(category_hotel_id,category_room_id,category_room_id,name,available,description,start,address,map,price,quantity)
values
(1, 1, N'Khách sạn Mẫu 1', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', '2023-08-05', N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(1, 1, N'Khách sạn Mẫu 1', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', '2023-08-05', N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(1, 1, N'Khách sạn Mẫu 1', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', '2023-08-05', N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(1, 1, N'Khách sạn Mẫu 1', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', '2023-08-05', N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(1, 1, N'Khách sạn Mẫu 1', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', '2023-08-05', N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(1, 1, N'Khách sạn Mẫu 1', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', '2023-08-05', N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(1, 1, N'Khách sạn Mẫu 1', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', '2023-08-05', N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(1, 1, N'Khách sạn Mẫu 1', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', '2023-08-05', N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),
(1, 1, N'Khách sạn Mẫu 1', 1, N'Khách sạn sang trọng với các tiện nghi hiện đại', '2023-08-05', N'Địa chỉ khách sạn Mẫu 1', N'Mã địa điểm bản đồ', 150, 10),

   