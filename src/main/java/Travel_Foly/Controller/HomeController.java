package Travel_Foly.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Travel_Foly.DAO.HotelDAO;
import Travel_Foly.DAO.TourDAO;
import Travel_Foly.Model.Hotel;
import Travel_Foly.Model.Tour;

@Controller
@RequestMapping("/TravelFpoly/")
public class HomeController {
	@Autowired
	TourDAO tourDao;
	@Autowired
	HotelDAO hotelDao;
	@GetMapping("Home")
	public String home(Model model, 
			@RequestParam("pageTour") Optional<Integer> pageTour
//			,@RequestParam("pageHotel") Optional<Integer> pageHotel
			) {
		Pageable pageableTour= PageRequest.of(pageTour.orElse(0), 10);
		Page<Tour> tour = tourDao.findAll(pageableTour);
//		Pageable pageableHotel= PageRequest.of(pageHotel.orElse(0), 10);
//		Page<Hotel> hotel = hotelDao.findAll(pageableHotel);
		model.addAttribute("productTour", tour);
//		model.addAttribute("productHotel", hotel);
		return "user/index";
	}
	@GetMapping("ProductDetail")
	public String productDetail() {
		return "user/productDetail";
	}
	@GetMapping("Home2")
	public String home2() {
		return "user/index-2";
	}
	@GetMapping("About")
	public String about() {
		return "user/about";
	}
	@GetMapping("Blog")
	public String blog() {
		return "user/blog";
	}
	@GetMapping("BlogDetail")
	public String blogDetail() {
		return "user/blog-single";
	}
	@GetMapping("Contact")
	public String contact() {
		return "user/contact";
	}
	@GetMapping("Hotel")
	public String hotel() {
		return "user/hotel";
	}
	@GetMapping("Hotel-Detail")
	public String hotelDetail() {
		return "user/hotel-single";
	}
	@GetMapping("Tour")
	public String tour() {
		return "user/tour";
	}
}
