package Travel_Foly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite;
import org.springframework.web.multipart.MultipartFile;

import Travel_Foly.DAO.HotelImageDAO;
import Travel_Foly.Model.Hotel;
import Travel_Foly.Model.HotelImage;
import Travel_Foly.Service.FileUpload;
import Travel_Foly.Service.HotelService;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private FileUpload fileUpload;

    @Autowired
    private HotelImageDAO hotelImageDAO;

    @GetMapping("hotel")
    public String indexHotel(Model model) {
        List<Hotel> hotels = hotelService.getAllHotel();
        model.addAttribute("hotels", hotels);
        model.addAttribute("hotel", new Hotel());
        return "admin/Hotel";
    }

    @PostMapping("saveHotel")
    public String SaveHotel(Model model, @ModelAttribute Hotel hotel,
            @RequestParam("image1") MultipartFile image1,
            @RequestParam("images") List<MultipartFile> images

    ) throws Exception {
        hotelService.addHotel(hotel);
        String image = fileUpload.uploadWithNameHotel(image1, hotel.getName(), "avatar");
        List<String> listImageName = fileUpload.uploadHotel(images, hotel.getName());
        HotelImage hotelImage = new HotelImage();
        hotelImage.setAvatar(image);
        hotelImage.setImage1(listImageName.get(0));
        hotelImage.setImage2(listImageName.get(1));
        hotelImage.setImage3(listImageName.get(2));
        hotelImage.setImage4(listImageName.get(3));
        hotelImage.setImage5(listImageName.get(4));
        hotelImage.setImage6(listImageName.get(5));
        hotelImage.setHotelImage(hotel);
        this.hotelImageDAO.save(hotelImage);

        return "redirect:/travelfpoly/admin/hotel";
    }

    @GetMapping("updateHotel/{HotelId}")
    public String updateHotel(@PathVariable Integer HotelId, Model model) {
        Hotel hotel = hotelService.getHotelById(HotelId);
        model.addAttribute("hotel", hotel);
        List<Hotel> hotels = hotelService.getAllHotel();
        model.addAttribute("hotels", hotels);
        return "admin/Hotel";
    }

    @GetMapping("deleteHotel/{HotelId}")
    public String deleteHotel(@PathVariable Integer HotelId) {
        this.hotelService.deleteHotel(HotelId);
        return "riderect:/travelfpoly/admin/hotel";
    }
}