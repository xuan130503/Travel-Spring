package Travel_Foly.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Travel_Foly.DAO.CategoryTourDAO;
import Travel_Foly.DAO.HotelDAO;
import Travel_Foly.DAO.TourDAO;
import Travel_Foly.DAO.TourImageDAO;
import Travel_Foly.DTO.TourWithImageDTO;
import Travel_Foly.Model.Tour;
import Travel_Foly.Model.TourImage;

@Controller
@RequestMapping("/travelfpoly/")
public class HomeController {
	@Autowired
	TourDAO tourDao;
	@Autowired
	HotelDAO hotelDao;
	@Autowired
	TourImageDAO tourImageDao;
	
	@Autowired
	CategoryTourDAO categoryTourDao;
	
	@GetMapping("home")
	public String home(Model model, 
			@RequestParam("pageTour") Optional<Integer> pageTour
//			,@RequestParam("pageHotel") Optional<Integer> pageHotel
			) {
		Pageable pageableTour= PageRequest.of(pageTour.orElse(0), 8);
		Page<TourWithImageDTO> tour = tourDao.findAllTourWithImage(pageableTour);
		List<Object[]> categories = categoryTourDao.findAllCategory();
//		Pageable pageableHotel= PageRequest.of(pageHotel.orElse(0), 10);
//		Page<Hotel> hotel = hotelDao.findAll(pageableHotel);
		model.addAttribute("productTour", tour);
		model.addAttribute("categories", categories);
//		model.addAttribute("productHotel", hotel);
		return "user/index-2";
	}
	@GetMapping("test")
	public String testData(Model model
				,@RequestParam("pageTour") Optional<Integer> pageTour
				) {
		Pageable pageableTour= PageRequest.of(pageTour.orElse(0), 8);
		Page<TourWithImageDTO> tour = tourDao.findAllTourWithImage(pageableTour);
		List<Object[]> categories = categoryTourDao.findAllCategory();
		model.addAttribute("productTour", tour);
		model.addAttribute("categories", categories);
		return "user/index-2";
	}
	@GetMapping("productdetail")
	public String productDetail() {
		return "user/productDetail";
	}
	@GetMapping("home2")
	public String home2() {
		return "user/index-2";
	}
	@GetMapping("about")
	public String about() {
		return "user/about";
	}
	@GetMapping("blog")
	public String blog() {
		return "user/blog";
	}
	@GetMapping("blogdetail")
	public String blogDetail() {
		return "user/blog-single";
	}
	@GetMapping("contact")
	public String contact() {
		return "user/contact";
	}
	@GetMapping("hotel")
	public String hotel() {
		return "user/hotel";
	}
	@GetMapping("hotel-Detail")
	public String hotelDetail() {
		return "user/hotel-single";
	}
	@GetMapping("tour")
	public String tour(Model model,
					@RequestParam("pageTour") Optional<Integer> page) {
		Pageable pageable=PageRequest.of(page.orElse(0), 9);
		Page<TourWithImageDTO> tours = tourDao.findAllTourWithImage(pageable);
		model.addAttribute("tours", tours);
		return "user/tour";
	}
	@GetMapping("tour/{id}")
	public String tourid(Model model, 
					@PathVariable("id") Integer id,
					@RequestParam("pageTour") Optional<Integer> page) {
		Pageable pageable=PageRequest.of(page.orElse(0), 9);
		Page<TourWithImageDTO> tours = tourDao.findByCategoryId(id, pageable);
		model.addAttribute("tours", tours);
		return "user/tour";
	}
	@GetMapping("login")
	public String login() {
		return "user/login";
	}
}
