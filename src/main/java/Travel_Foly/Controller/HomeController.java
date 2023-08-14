package Travel_Foly.Controller;

import java.security.Principal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.DAO.CategoryTourDAO;
import Travel_Foly.DAO.HotelDAO;
import Travel_Foly.DAO.OrderDetailTourDAO;
import Travel_Foly.DAO.TourDAO;
import Travel_Foly.DAO.TourImageDAO;
import Travel_Foly.DAO.TourScheduleDAO;
import Travel_Foly.DAO.TourVariantDAO;
import Travel_Foly.DTO.AccountDTO;
import Travel_Foly.DTO.HotelDTO;
import Travel_Foly.DTO.TourWithImageDTO;
import Travel_Foly.Model.Account;
import Travel_Foly.Model.OrderDetailTour;
import Travel_Foly.Model.Tour;
import Travel_Foly.Model.TourImage;
import Travel_Foly.Model.TourSchedule;
import Travel_Foly.Model.TourVariant;
import Travel_Foly.Service.SessionService;
import Travel_Foly.Service.UserDetailServiceImpl;

@Controller
@RequestMapping("/travelfpoly/")
public class HomeController {
	@Autowired
	private SessionService session;
	@Autowired
	private TourDAO tourDao;
	@Autowired
	private HotelDAO hotelDao;
	
	@Autowired
	private TourImageDAO tourImageDao;
	
	@Autowired
	private CategoryTourDAO categoryTourDao;
	
	@Autowired
	private TourVariantDAO tourVatiantDao;
	
	@Autowired 
	private TourScheduleDAO tourScheduleDao;
	@Autowired
	private AccountDAO accountDao;
	
	@Autowired
	private OrderDetailTourDAO orderDetailTourDao;
	
	//get information after login successfully
	public void getPricical(Principal principal) {
		if (principal != null && principal instanceof Authentication) {
            Authentication authentication = (Authentication) principal;
            if (authentication.getPrincipal() instanceof Account) {
                String username = ((Account) authentication.getPrincipal()).getUsername();
                AccountDTO account = accountDao.findOneUsername(username);
                session.setAttribute("account", account);
            }
        }
	}
	@GetMapping("home")
	public String home(
				Principal princical
				,Model model
				,@RequestParam("pageTour") Optional<Integer> pageTour
				,@RequestParam("pageHotel") Optional<Integer> pageHotel
			) {
		
		// Tour 
		Pageable pageableTour= PageRequest.of(pageTour.orElse(0), 8);
		Page<TourWithImageDTO> tour = tourDao.findAllTourWithImage(pageableTour);
		
		//Category
		List<Object[]> categories = categoryTourDao.findAllCategory();
		
		//Hotel
		Pageable pageableHotel= PageRequest.of(pageHotel.orElse(0), 8);
		Page<HotelDTO> hotel = hotelDao.findAllHotelWithImage(pageableHotel);
		
		model.addAttribute("productTour", tour);
		model.addAttribute("categories", categories);
		model.addAttribute("productHotel", hotel);
		getPricical(princical);
		return "user/index-2";
		
	}
	@GetMapping("cart")
	public String cart(Model model) {
		
		return "user/cart1";
	}
	@PostMapping("addToCart")
	public String addToCart(Model model) {
		
		return "user/cart1";
	}
	@GetMapping("tour-detail")
	public String tourdetail(Model model) {
		
		return "user/productdetail";
	}
	@GetMapping("tour-detail/{id}")
	public String productDetail(@PathVariable("id") Integer id, Model model) {
		TourImage image = tourImageDao.findByTourId(id);
		TourVariant variant = tourVatiantDao.findAllByTourId(id);
		List<TourSchedule> schedules = tourScheduleDao.findByTourId(id);
		model.addAttribute("image", image);
		model.addAttribute("variant", variant);
		model.addAttribute("schedules", schedules);
		return "user/productdetail";
	}
	@PostMapping("bookNow/{id}")
	public String booknow(Model model,@PathVariable("id") Integer TourId
			,@RequestParam("fullname") String fullname
			,@RequestParam("email") String email
			,@RequestParam("phone") String phone
			,@RequestParam("startdate") Date date
			,@RequestParam("quantityAdult") Integer quantityAdult
			,@RequestParam("quantityAdult") Integer quantityChildren
			,TourVariant variant
			) {
		Double price =(Double) tourDao.findPriceByTourId(TourId);
		Tour tour= tourDao.findById(TourId).get();
		try {
			if(fullname!=null && email!=null && date!=null && phone!=null && quantityAdult!=null && quantityChildren!=null) {
				//Add to Order detail Tour
				OrderDetailTour order= new OrderDetailTour();
				order.setDate(date);
				order.setPrice(price);
				order.setQuantity(quantityAdult);
				order.setQuantityChildren(quantityChildren);
				order.setOrderDetailTour(tour);
				orderDetailTourDao.save(order);
				System.out.println("OrderId: " + order.getOrderDetailTourId());
				//Add to Order Tour
				
				return "user/order";
			}
			model.addAttribute("message", "Book tour is error please check your information!");
			return "user/productdetail";
		} catch (Exception e) {
			model.addAttribute("message", "Can't book tour");
			e.printStackTrace();
			return "user/productdetail";

		}
		
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
	public String hotel(Model model, 
			@RequestParam("pageHotel") Optional<Integer> page) {
		Pageable pageable=PageRequest.of(page.orElse(0), 9);
		Page<HotelDTO> hotels = hotelDao.findAllHotelWithImage(pageable);
		model.addAttribute("hotels", hotels);
		
		return "user/hotel";
	}
	@GetMapping("hotel-detail")
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
}
