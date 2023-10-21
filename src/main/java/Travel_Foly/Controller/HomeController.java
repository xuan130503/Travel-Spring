package Travel_Foly.Controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.DAO.CartDAO;
import Travel_Foly.DAO.CartItemDAO;
import Travel_Foly.DAO.CategoryTourDAO;
import Travel_Foly.DAO.HotelDAO;
import Travel_Foly.DAO.OrderDetailTourDAO;
import Travel_Foly.DAO.OrderTourDAO;
import Travel_Foly.DAO.TourDAO;
import Travel_Foly.DAO.TourImageDAO;
import Travel_Foly.DAO.TourScheduleDAO;
import Travel_Foly.DTO.AccountDTO;
import Travel_Foly.DTO.CartItemDTO;
import Travel_Foly.DTO.HotelDTO;
import Travel_Foly.DTO.TourWithImageDTO;
import Travel_Foly.Helper.DateHelper;
import Travel_Foly.Model.Account;
import Travel_Foly.Model.Cart;
import Travel_Foly.Model.CartItem;
import Travel_Foly.Model.OrderDetailTour;
import Travel_Foly.Model.OrderTour;
import Travel_Foly.Model.Tour;
import Travel_Foly.Model.TourImage;
import Travel_Foly.Model.TourSchedule;
import Travel_Foly.Service.SessionService;

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
	private TourScheduleDAO tourScheduleDao;
	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private CartDAO cartDao;
	@Autowired
	private OrderDetailTourDAO orderDetailTourDao;
	
	@Autowired
	private CartItemDAO cartItemDao;
	
	@Autowired
	private OrderTourDAO orderTourDao;
	
	//get information after login successfully
	public void getPricical(Principal principal) {
		if (principal != null && principal instanceof Authentication) {
            Authentication authentication = (Authentication) principal;
            if (authentication.getPrincipal() instanceof Account) {
                String username = ((Account) authentication.getPrincipal()).getUsername();
                AccountDTO account = accountDao.findOneUsername(username);
                Integer amount = cartItemDao.getAmount(account.getUserId());
                session.setAttribute("account", account);
                session.setAttribute("amount", amount);
            }
        }
	}
	public void setAmount() {
		AccountDTO account = (AccountDTO) session.getAttribute("account");
        Integer amount = cartItemDao.getAmount(account.getUserId());
        session.setAttribute("amount", amount);
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
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		session.setAttribute("account", account);
		return "user/index-2";
		
	}
	@PostMapping("search")
	public String search(Model model
			,@RequestParam("searchKey") Optional<String> keyword
			,@RequestParam("pageTour") Optional<Integer> pageTour
			,@RequestParam("pageHotel") Optional<Integer> pageHotel
		) {
//		//Set key
		Double minPrice=null;
		Double maxPrice=null;
		String nameProduct=keyword.orElse(session.getAttribute("keyword"));
		if(isStringNumeric(nameProduct)) {
			minPrice=Double.parseDouble(nameProduct);
			maxPrice=Double.parseDouble(nameProduct)+100000;
		}
		session.setAttribute("keyword", nameProduct);
//		// Tour 
		Pageable pageableTour= PageRequest.of(pageTour.orElse(0), 8);
		Page<TourWithImageDTO> tour = tourDao.searchByKeyWord(nameProduct,minPrice,maxPrice,pageableTour);
		
//		//Category
		List<Object[]> categories = categoryTourDao.findAllCategory();
//		
//		//Hotel
		Pageable pageableHotel= PageRequest.of(pageHotel.orElse(0), 8);
		Page<HotelDTO> hotel = hotelDao.findAllHotelWithImage(pageableHotel);
		
		model.addAttribute("productTour", tour);
		model.addAttribute("categories", categories);
		model.addAttribute("productHotel", hotel);
		return "user/index-2";
	}
	@GetMapping("searchTour")
	public String searchTour(Model model
			,@RequestParam("searchKey") Optional<String> keyword
			,@RequestParam("pageTour") Optional<Integer> page
		) {
			Double minPrice=null;
			Double maxPrice=null;
			String nameProduct=keyword.orElse(session.getAttribute("keyword"));
			if(isStringNumeric(nameProduct)) {
				minPrice=Double.parseDouble(nameProduct)-1000;
				maxPrice=Double.parseDouble(nameProduct);
			}
			Pageable pageable=PageRequest.of(page.orElse(0), 9);
			Page<TourWithImageDTO> tours = tourDao.searchByKeyWord(nameProduct, minPrice, maxPrice, pageable);
			model.addAttribute("tours", tours);
//		
		return "user/tour";
	}
	@GetMapping("cart")
	public String cart(Model model) {
		AccountDTO account = (AccountDTO)session.getAttribute("account");
		System.out.println(account.getUserName());
//		System.out.println(account.getUserName());
		Integer userId = account.getUserId();
		Account user = accountDao.findById(userId).get();
		Cart cart = cartDao.findByUserId(userId);
		if(cart == null) {
			Cart cart1 = new Cart();
			cart1.setAddress(user.getAddress());
			cart1.setCart(user);
			cart1.setName(user.getFullName());
			cart1.setPhone(user.getPhone());
			cart1.setEmail(user.getEmail());
			cartDao.save(cart1);
			
			//
			Double totalPrice = cartItemDao.getTotal(userId);
			List<CartItem> cartItems = cartItemDao.findByCartId(cart1.getCartId());
//			List<CartItemDTO> cartItems = cartItemDao.findCartItemDTOById(cart1.getCartId());
			model.addAttribute("cart", cart);
			model.addAttribute("cartItems", cartItems);
			model.addAttribute("totalPrice", totalPrice);
		}
		else {
			Double totalPrice = cartItemDao.getTotal(userId);
			List<CartItem> cartItems = cartItemDao.findByCartId(cart.getCartId());
//			List<CartItemDTO> cartItems = cartItemDao.findCartItemDTOById(cart.getCartId());
			model.addAttribute("cart", cart);
			model.addAttribute("cartItems", cartItems);
			model.addAttribute("totalPrice", totalPrice);
		}
		return "user/cart1";
	}
	@GetMapping("cart/delete/{id}")
	public String deleteCartItem(@PathVariable("id") Integer id) {
		cartItemDao.deleteById(id);
		setAmount();
		return "redirect:/travelfpoly/cart";
	}
	@PostMapping("cart/book/{id}")
	public String book(@PathVariable("id") Integer id
			,Model model
			,@RequestParam("fullname") String fullname
			,@RequestParam("phone") String phone
			,@RequestParam("address") String address
			,@RequestParam("email") String email
			) {
		
		Account account = accountDao.findById(id).get();
		Integer cartId = cartDao.findByUserId(id).getCartId();
		List<CartItem> listCart = cartItemDao.findByCartId(cartId);
		if(fullname!=null && phone!=null && address!=null && email!=null) {
			//addToOrder
			OrderTour order = new OrderTour();
			order.setAddress(address);
			order.setName(fullname);
			order.setEmail(email);
			order.setPhone(phone);
			order.setOrderTour(account);
			orderTourDao.save(order);
			//add list CartItem in order Detail tour
		
			for (CartItem cartItem : listCart) {
				OrderDetailTour detailOrder = new OrderDetailTour();
				Tour tour = tourDao.findByTourId(cartItem.getTourId().getTourId());
				detailOrder.setOrderTour(order);
				detailOrder.setBookDate(new Date());
				detailOrder.setStarDate(cartItem.getStartDate());
				detailOrder.setEndDate(cartItem.getEndDate());
				detailOrder.setPriceAdult(cartItem.getTourId().getPriceAdult());
				detailOrder.setPriceChildren(cartItem.getTourId().getPriceChildren());
				detailOrder.setQuantityAdult(cartItem.getQuantityAdult());
				detailOrder.setQuantityChildren(cartItem.getQuantityChildren());
				detailOrder.setStatus(1);
				detailOrder.setOrderDetailTour(tour);
				
				orderDetailTourDao.save(detailOrder);
				cartItemDao.deleteById(cartItem.getCartItemId());
				
				//set quantity tour
				
				tour.setQuantityAdult(tour.getQuantityAdult()-cartItem.getQuantityAdult());
				tour.setQuantityChildren(tour.getQuantityChildren()-cartItem.getQuantityChildren());
				tourDao.save(tour);
			}
			
			session.setAttribute("amount", cartItemDao.getAmount(id));
			return "redirect:/travelfpoly/order";
		}
		else {
			model.addAttribute("message", "Không được bỏ trống các trường");
			return "user/cart1";
		}
		
	}
	@GetMapping("order")
	public String orderTour(Model model
							,@RequestParam("field") Optional<String> field
							,@RequestParam("sort") Optional<String> sortOrder
							,@RequestParam("page") Optional<Integer> page
					) {
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		Sort.Direction sortDirection = sortOrder.map(value -> value.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC)
                .orElse(Sort.Direction.DESC);
		Sort sort=Sort.by(sortDirection,field.orElse("StarDate"));
		Pageable pageable = PageRequest.of(page.orElse(0), 3,sort);
		Page<OrderDetailTour> orderDetails = orderDetailTourDao.findOrderByUserId(account.getUserId(),pageable);
		OrderDetailTour orderDetailTour = new OrderDetailTour();
		model.addAttribute("orderDetailTour", orderDetailTour);
		model.addAttribute("list", orderDetails);
		return "user/order";
	}
	@GetMapping("order/search")
	public String searchorderTour(Model model
							,@RequestParam("field") Optional<String> field
							,@RequestParam("sort") Optional<String> sortOrder
							,@RequestParam("page") Optional<Integer> page
							,@RequestParam("searchKey") Optional<String> keyword
					) {
		
//		Double minPrice=null;
//		Double maxPrice=null;
//		String nameProduct=keyword.orElse(session.getAttribute("keyword"));
//		if(isStringNumeric(nameProduct)) {
//			minPrice=Double.parseDouble(nameProduct);
//			maxPrice=Double.parseDouble(nameProduct)+50;
//		}
//		AccountDTO account = (AccountDTO) session.getAttribute("account");
//		Sort.Direction sortDirection = sortOrder.map(value -> value.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC)
//                .orElse(Sort.Direction.DESC);
//		Sort sort=Sort.by(sortDirection,field.orElse("StarDate"));
//		Pageable pageable = PageRequest.of(page.orElse(0), 3,sort);
//		Page<OrderDetailTour> orderDetails = orderDetailTourDao.findOrderByUserIdAndKeyword(account.getUserId(),nameProduct,minPrice,maxPrice,pageable);
//		model.addAttribute("list", orderDetails);
		return "user/order";
	}
	@GetMapping("order/delete/{id}")
	public String deleteTour(@PathVariable("id") Integer id) {
		OrderDetailTour order = orderDetailTourDao.findById(id).get();
		order.setStatus(0);
		orderDetailTourDao.save(order);
		//set quantity tour
		Integer tourId=order.getOrderDetailTour().getTourId();
		Tour tour = tourDao.findByTourId(tourId);
		tour.setQuantityAdult(tour.getQuantityAdult()+order.getQuantityAdult());
		tour.setQuantityChildren(tour.getQuantityChildren()+order.getQuantityChildren());
		tourDao.save(tour);
		return "redirect:/travelfpoly/order";
	}
	@GetMapping("order/fill/{id}")
	public String fillTour(@PathVariable("id") Integer id,Model model
								,@RequestParam("field") Optional<String> field
								,@RequestParam("sort") Optional<String> sortOrder
								,@RequestParam("page") Optional<Integer> page
							) {
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		Sort.Direction sortDirection = sortOrder.map(value -> value.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC)
		.orElse(Sort.Direction.DESC);
		Sort sort=Sort.by(sortDirection,field.orElse("StarDate"));
		Pageable pageable = PageRequest.of(page.orElse(0), 3,sort);
		Page<OrderDetailTour> orderDetails = orderDetailTourDao.findOrderByUserId(account.getUserId(),pageable);
		
		model.addAttribute("list", orderDetails);
		OrderDetailTour order = orderDetailTourDao.findById(id).get();
		model.addAttribute("orderDetailTour", order);
		return "/user/order";
	}
	@PostMapping("order/update")
	public String updateTour(
					Model model,
					@RequestParam("hiddenTourId") Integer id,
					@RequestParam("quantityAdult") Integer qtyAdult,
					@RequestParam("quantityChildren") Integer qtyChildren,
					@RequestParam("starDate") java.sql.Date startdate
			
			) {
		
		OrderDetailTour order = orderDetailTourDao.findByOrderDetailTourId(id);
		order.setStarDate(DateHelper.converDateSql(startdate));
		order.setQuantityAdult(qtyAdult);
		order.setQuantityChildren(qtyChildren);
		order.setBookDate(new Date());
		orderDetailTourDao.save(order);
		return "redirect:/travelfpoly/order";
	}
	@PostMapping("addToCart/{tourId}/{userId}")
	public String addToCart(Model model
			,@PathVariable("tourId") Integer TourId
			,@PathVariable("userId") Integer UserId
			,@RequestParam("fullname") String fullname
			,@RequestParam("email") String email
			,@RequestParam("phone") String phone
			,@RequestParam("address") String address
			,@RequestParam("startdate") java.sql.Date startdate
			,@RequestParam("quantityAdult") Integer quantityAdult
			,@RequestParam("quantityAdult") Integer quantityChildren) {
		
		try {
			Account account = accountDao.findById(UserId).get();
			Tour tour =tourDao.findById(TourId).get();
			Cart checkCart = cartDao.findByUserId(UserId);
			
			model.addAttribute("account", account);
			if(fullname!=null && email!=null && startdate!=null && phone!=null && quantityAdult!=null && quantityChildren!=null) {
				//add to cart
				if(checkCart==null) {
					checkCart = new Cart();
					checkCart.setEmail(email);
					checkCart.setName(fullname);
					checkCart.setAddress(address);
					checkCart.setPhone(phone);
					checkCart.setCart(account);
					cartDao.save(checkCart);
				}
//				//add to cart item
				CartItem cartItem = new CartItem();
				cartItem.setStartDate(DateHelper.converDateSql(startdate));
				cartItem.setEndDate(DateHelper.addDaysToDate(startdate, tour.getDuration()));
				cartItem.setQuantityAdult(quantityAdult);
				cartItem.setQuantityChildren(quantityChildren);
				cartItem.setTourId(tour);
				cartItem.setCartItem(checkCart);
				cartItemDao.save(cartItem);
				session.setAttribute("amount", cartItemDao.getAmount(UserId));
				return "redirect:/travelfpoly/cart";
			}
			model.addAttribute("message", "Insert cart is error please check your information!");
			return "user/productdetail";
		} catch (Exception e) {
			model.addAttribute("message", "Insert cart tour");
			e.printStackTrace();
			return "user/productdetail";

		}
	}
//	@GetMapping("tour-detail")
//	public String tourdetail(Model model) {
//		AccountDTO checkUser = (AccountDTO) session.getAttribute("account");
//		if(checkUser == null) {
//			checkUser = new AccountDTO();
//			session.setAttribute("account", checkUser);
//		}
//		return "user/productdetail";
//	}
	
	@GetMapping("tour-detail/{id}")
	public String productDetail(@PathVariable("id") Integer id, Model model) {
		
		TourImage image = tourImageDao.findByTourId(id);
		Tour tour = tourDao.findByTourId(id);
		List<TourSchedule> schedules = tourScheduleDao.findByTourId(id);
		model.addAttribute("image", image);
		model.addAttribute("tour", tour);
		model.addAttribute("schedules", schedules);
		return "user/productdetail";
	}
	@PostMapping("bookNow/{tourId}/{userId}")
	public String booknow(Model model
			,@PathVariable("tourId") Integer TourId
			,@PathVariable("userId") Integer UserId
			,@RequestParam("fullname") String fullname
			,@RequestParam("email") String email
			,@RequestParam("address") String address
			,@RequestParam("phone") String phone
			,@RequestParam("startdate") java.sql.Date date
			,@RequestParam("quantityAdult") Integer quantityAdult
			,@RequestParam("quantityChildren") Integer quantityChildren
			) {
		Account account = accountDao.findById(UserId).get();
		Tour tour= tourDao.findById(TourId).get();
		try {
			if(fullname!=null && email!=null && date!=null && phone!=null && quantityAdult!=null && quantityChildren!=null) {
				//addToOrder Tour
				OrderTour order = new OrderTour();
				order.setAddress(address);
				order.setName(fullname);
				order.setEmail(email);
				order.setPhone(phone);
				order.setOrderTour(account);
				orderTourDao.save(order);
				//Add to Order detail Tour
				OrderDetailTour orderDetail= new OrderDetailTour();
				orderDetail.setStarDate(DateHelper.converDateSql(date));
				orderDetail.setEndDate(DateHelper.addDaysToDate(date, tour.getDuration()));
				orderDetail.setBookDate(new Date());
				orderDetail.setPriceAdult(tour.getPriceAdult());
				orderDetail.setPriceChildren(tour.getPriceChildren());
				orderDetail.setStatus(1);
				orderDetail.setQuantityAdult(quantityAdult);
				orderDetail.setQuantityChildren(quantityChildren);
				orderDetail.setOrderDetailTour(tour);
				orderDetail.setOrderTour(order);
				orderDetailTourDao.save(orderDetail);
				//set quantity Tour
				tour.setQuantityAdult(tour.getQuantityAdult() - quantityAdult);
				tour.setQuantityChildren(tour.getQuantityChildren() - quantityChildren);
				tourDao.save(tour);
				return "redirect:/travelfpoly/order";
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
	
	public boolean isStringNumeric(String input) {
        String regex = "^[-+]?\\d+(\\.\\d+)?$";
        return input.matches(regex);
    }
}
