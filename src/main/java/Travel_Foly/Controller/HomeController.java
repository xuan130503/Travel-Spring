package Travel_Foly.Controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.util.StringUtils;
import org.checkerframework.checker.units.qual.min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.temporal.ChronoUnit;

import Travel_Foly.Service.FileUpload;

import Travel_Foly.API.Service.Base64Service;
import Travel_Foly.API.Service.QRCodeService;
import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.DAO.CartDAO;
import Travel_Foly.DAO.CartItemDAO;
import Travel_Foly.DAO.CategoryTourDAO;
import Travel_Foly.DAO.HotelDAO;
import Travel_Foly.DAO.HotelImageDAO;
import Travel_Foly.DAO.IntimateDAO;
import Travel_Foly.DAO.OrderDetailHotelDAO;
import Travel_Foly.DAO.OrderDetailTourDAO;
import Travel_Foly.DAO.OrderHotelDAO;
import Travel_Foly.DAO.OrderTourDAO;
import Travel_Foly.DAO.TourDAO;
import Travel_Foly.DAO.TourImageDAO;
import Travel_Foly.DAO.TourScheduleDAO;
import Travel_Foly.DTO.AccountDTO;
import Travel_Foly.DTO.CartItemDTO;
import Travel_Foly.DTO.CheckoutCartDTO;
import Travel_Foly.DTO.HotelDTO;
import Travel_Foly.DTO.InvoiceDTO;
import Travel_Foly.DTO.TourWithImageDTO;
import Travel_Foly.DTO.orderHotelDTO;
import Travel_Foly.Helper.DateHelper;
import Travel_Foly.Model.Account;
import Travel_Foly.Model.Cart;
import Travel_Foly.Model.CartItem;
import Travel_Foly.Model.Hotel;
import Travel_Foly.Model.HotelComment;
import Travel_Foly.Model.HotelImage;
import Travel_Foly.Model.Intimate;
import Travel_Foly.Model.OrderDetailHotel;
import Travel_Foly.Model.OrderDetailTour;
import Travel_Foly.Model.OrderHotel;
import Travel_Foly.Model.OrderTour;
import Travel_Foly.Model.Tour;
import Travel_Foly.Model.TourImage;
import Travel_Foly.Model.TourSchedule;
import Travel_Foly.API.Service.MailService;
import Travel_Foly.Service.SessionService;
import jakarta.mail.internet.MimeMessage;
import jakarta.persistence.EntityNotFoundException;

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

	@Autowired
	private MailService mailService;

	@Autowired
	private QRCodeService qrCodeService;
	@Autowired
	private Base64Service base64Service;

	@Autowired
	private HotelDAO hotelDAO;
	@Autowired
	private HotelImageDAO hotelImageDAO;

	@Autowired
	IntimateDAO intimateDao;

	@Autowired
	JavaMailSender javaMailSender;

	// get information after login successfully
	public void getPricical(Principal principal) {
		if (principal != null && principal instanceof Authentication) {
			Authentication authentication = (Authentication) principal;
			if (authentication.getPrincipal() instanceof Account) {
				String username = ((Account) authentication.getPrincipal()).getUsername();
				if (username != null) {
					AccountDTO account = accountDao.findOneUsername(username);
					Integer amount = cartItemDao.getAmount(account.getUserId()) == null ? 0
							: cartItemDao.getAmount(account.getUserId());

					session.setAttribute("account", account);
					session.setAttribute("amount", amount);
				}

			} else {
				AccountDTO account = accountDao.findOneUsername(principal.getName());
				Integer amount = cartItemDao.getAmount(account.getUserId()) == null ? 0
						: cartItemDao.getAmount(account.getUserId());
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
			Principal princical, Model model, @RequestParam("pageTour") Optional<Integer> pageTour,
			@RequestParam("pageHotel") Optional<Integer> pageHotel) {

		// Tour
		Pageable pageableTour = PageRequest.of(pageTour.orElse(0), 8);
		Page<TourWithImageDTO> tour = tourDao.findAllTourWithImage(pageableTour);

		// Category
		List<Object[]> categories = categoryTourDao.findAllCategory();

		// Hotel
		Pageable pageableHotel = PageRequest.of(pageHotel.orElse(0), 8);
		Page<HotelDTO> hotel = hotelDao.findAllHotelWithImage(pageableHotel);

		model.addAttribute("productTour", tour);
		model.addAttribute("categories", categories);
		model.addAttribute("productHotel", hotel);
		getPricical(princical);
		return "user/index-2";

	}

	@PostMapping("search")
	public String search(Model model, @RequestParam("searchKey") Optional<String> keyword,
			@RequestParam("pageTour") Optional<Integer> pageTour,
			@RequestParam("pageHotel") Optional<Integer> pageHotel) {
		// //Set key
		Double minPrice = null;
		Double maxPrice = null;
		String nameProduct = keyword.orElse(session.getAttribute("keyword"));
		if (isStringNumeric(nameProduct)) {
			minPrice = Double.parseDouble(nameProduct);
			maxPrice = Double.parseDouble(nameProduct) + 100000;
		}
		session.setAttribute("keyword", nameProduct);
		// // Tour
		Pageable pageableTour = PageRequest.of(pageTour.orElse(0), 8);
		Page<TourWithImageDTO> tour = tourDao.searchByKeyWord(nameProduct, minPrice, maxPrice, pageableTour);

		// //Category
		List<Object[]> categories = categoryTourDao.findAllCategory();
		//
		// //Hotel
		Pageable pageableHotel = PageRequest.of(pageHotel.orElse(0), 8);
		Page<HotelDTO> hotel = hotelDao.findAllHotelWithImage(pageableHotel);

		model.addAttribute("productTour", tour);
		model.addAttribute("categories", categories);
		model.addAttribute("productHotel", hotel);
		return "user/index-2";
	}

	@GetMapping("searchTour")
	public String searchTour(Model model, @RequestParam("searchKey") Optional<String> keyword,
			@RequestParam("pageTour") Optional<Integer> page) {
		Double minPrice = null;
		Double maxPrice = null;
		String nameProduct = keyword.orElse(session.getAttribute("keyword"));
		if (isStringNumeric(nameProduct)) {
			minPrice = Double.parseDouble(nameProduct) - 1000;
			maxPrice = Double.parseDouble(nameProduct);
		}
		Pageable pageable = PageRequest.of(page.orElse(0), 9);
		Page<TourWithImageDTO> tours = tourDao.searchByKeyWord(nameProduct, minPrice, maxPrice, pageable);
		model.addAttribute("tours", tours);
		//
		return "user/tour";
	}

	@GetMapping("cart")
	public String cart(Model model) {
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		Integer userId = account.getUserId();
		Account user = accountDao.findById(userId).get();
		Cart cart = cartDao.findByUserId(userId);
		if (cart == null) {
			cart.setAddress(user.getAddress());
			cart.setCart(user);
			cart.setName(user.getFullName());
			cart.setPhone(user.getPhone());
			cart.setEmail(user.getEmail());
			cartDao.save(cart);
		}

		List<CartItem> cartItems = cartItemDao.findByCartId(cart.getCartId());
		model.addAttribute("cart", cart);
		model.addAttribute("cartItems", cartItems);
		// Object [] cartItemDTO=cartItems.toArray();
		// Map<Integer, Boolean> selectedTours = new HashMap<>();
		//
		// for (CartItem item : cartItems) {
		// selectedTours.put(item.getTourId().getTourId(), false);
		// }
		// model.addAttribute("selectedTours", selectedTours);
		return "user/cart1";
	}

	@GetMapping("cart/delete/{id}")
	public String deleteCartItem(@PathVariable("id") Integer id) {
		cartItemDao.deleteById(id);
		setAmount();
		return "redirect:/travelfpoly/cart";
	}

	@PostMapping("cart/update/{id}")
	public String updateCartItem(@PathVariable("id") Integer id,
			Model model,
			@RequestParam("startDate") java.sql.Date startDate,
			@RequestParam("adult") Integer quantityAdult,
			@RequestParam("children") Integer quantityChildren) {
		CartItem item = cartItemDao.findById(id).get();
		Tour tour = tourDao.findByTourId(item.getTourId().getTourId());
		if (quantityAdult > tour.getQuantityAdult() || quantityChildren > tour.getQuantityChildren()) {
			model.addAttribute("message", "The number of tickets exceeds the allowed number");
			AccountDTO account = (AccountDTO) session.getAttribute("account");
			Integer userId = account.getUserId();
			Account user = accountDao.findById(userId).get();
			Cart cart = cartDao.findByUserId(userId);
			List<CartItem> cartItems = cartItemDao.findByCartId(cart.getCartId());
			model.addAttribute("cart", cart);
			model.addAttribute("cartItems", cartItems);
			return "user/cart1";
		}
		item.setStartDate(startDate);
		item.setQuantityAdult(quantityAdult);
		item.setQuantityChildren(quantityChildren);
		cartItemDao.save(item);
		return "redirect:/travelfpoly/cart";
	}
	// @PostMapping("cart/book/{id}")
	// public String book(@PathVariable("id") Integer id,
	// Model model,
	// @RequestBody Map<String, Object> payload
	// ) {
	// Integer quantityAdult = (Integer) payload.get("quantityAdult");
	// Integer quantityChildren = (Integer) payload.get("quantityChildren");
	// String fullname = (String) payload.get("fullname");
	// String phone = (String) payload.get("phone");
	// String address = (String) payload.get("address");
	// String email = (String) payload.get("email");
	// System.out.println(quantityAdult);
	// System.out.println(quantityChildren);
	// Account account = accountDao.findById(id).get();
	// Integer cartId = cartDao.findByUserId(id).getCartId();
	// List<CartItem> listCart = cartItemDao.findByCartId(cartId);
	// if(fullname!=null && phone!=null && address!=null && email!=null) {
	// //addToOrder
	// OrderTour order = new OrderTour();
	// order.setAddress(address);
	// order.setName(fullname);
	// order.setEmail(email);
	// order.setPhone(phone);
	// orderTourDao.save(order);
	// //add list CartItem in order Detail tour
	//
	// for (CartItem cartItem : listCart) {
	// OrderDetailTour detailOrder = new OrderDetailTour();
	// Tour tour = tourDao.findByTourId(cartItem.getTourId().getTourId());
	// detailOrder.setOrderTour(order);
	// detailOrder.setBookDate(new Date());
	// detailOrder.setStarDate(cartItem.getStartDate());
	// detailOrder.setEndDate(cartItem.getEndDate());
	// detailOrder.setPriceAdult(cartItem.getTourId().getPriceAdult());
	// detailOrder.setPriceChildren(cartItem.getTourId().getPriceChildren());
	// detailOrder.setQuantityAdult(quantityAdult);
	// detailOrder.setQuantityChildren(quantityChildren);
	// detailOrder.setStatus(0);
	// detailOrder.setOrderDetailTour(tour);
	//
	// orderDetailTourDao.save(detailOrder);
	// cartItemDao.deleteById(cartItem.getCartItemId());
	//
	// //set quantity tour
	//
	// tour.setQuantityAdult(tour.getQuantityAdult()-cartItem.getQuantityAdult());
	// tour.setQuantityChildren(tour.getQuantityChildren()-cartItem.getQuantityChildren());
	// tourDao.save(tour);
	// }
	//
	// session.setAttribute("amount", cartItemDao.getAmount(id));
	// return "redirect:/travelfpoly/order";
	// }
	// else {
	// model.addAttribute("message", "Không được bỏ trống các trường");
	// return "user/cart1";
	// }
	//
	// }

	@PostMapping("cart/buySelectedItems")
	public ResponseEntity<String> checkoutCart(@RequestBody CheckoutCartDTO selectedItems) {
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		Integer userId = account.getUserId();
		Account user = accountDao.findById(userId).get();
		List<Integer> listOrderId = new ArrayList<>();
		
		for (Integer item : selectedItems.getSelectedItems()) {

			OrderTour order = new OrderTour();
			order.setName(selectedItems.getFullname());
			order.setEmail(selectedItems.getEmail());
			order.setAddress(selectedItems.getAddress());
			order.setPhone(selectedItems.getPhone());
			orderTourDao.save(order);

			CartItem cart = new CartItem();
			OrderDetailTour orderDetail = new OrderDetailTour();
			cart = cartItemDao.findOneCartItemId(item);

			orderDetail.setStarDate(cart.getStartDate());
			orderDetail.setEndDate(cart.getEndDate());
			orderDetail.setBookDate(new Date());
			orderDetail.setPriceAdult(cart.getTourId().getPriceAdult());
			orderDetail.setPriceChildren(cart.getTourId().getPriceChildren());
			orderDetail.setStatus(0);
			orderDetail.setAvailable(true);
			orderDetail.setQuantityAdult(cart.getQuantityAdult());
			orderDetail.setQuantityChildren(cart.getQuantityChildren());
			orderDetail.setOrderDetailTour(cart.getTourId());
			orderDetail.setTotal(( cart.getTourId().getPriceAdult() * cart.getQuantityAdult())+( cart.getTourId().getPriceChildren() * cart.getQuantityChildren() ));
			orderDetail.setOrderTour(order);
			orderDetail.setUserOrder(user);
			orderDetail = orderDetailTourDao.saveAndFlush(orderDetail);
			orderDetail.setBase64(base64Service.generateQRCodeAndEncodeToBase64(orderDetail.getOrderDetailTourId()));
			orderDetailTourDao.save(orderDetail);

			listOrderId.add(orderDetail.getOrderDetailTourId());
			// mailService.sendMailWithCustomer(invoice);
			// set quantity tour
			Tour tour = tourDao.findByTourId(cart.getTourId().getTourId());
			tour.setQuantityAdult(tour.getQuantityAdult() - cart.getQuantityAdult());
			tour.setQuantityChildren(tour.getQuantityChildren() - cart.getQuantityChildren());
			tourDao.save(tour);
			cartItemDao.deleteById(cart.getCartItemId());
			setAmount();
		}

		if (selectedItems.getPayment().equals("cash") || selectedItems.getPayment() == null) {
			for (Integer index : listOrderId) {
				InvoiceDTO invoice = orderDetailTourDao.detailInvoice(index);
				mailService.sendMailWithCustomer(invoice);
			}
			return ResponseEntity.ok("/travelfpoly/order");
		}
		if (selectedItems.getPayment().equals("paypal")) {
			for (Integer invoice : listOrderId) {
				OrderDetailTour detail = orderDetailTourDao.findById(invoice).get();
				detail.setStatus(1);
				orderDetailTourDao.save(detail);
			}
			String redirectUrl = "/travelfpoly/payment/listOrder?listOrderId="
					+ StringUtils.collectionToCommaDelimitedString(listOrderId);
			return ResponseEntity.ok(redirectUrl);

		}
		if (selectedItems.getPayment().equals("vnpay")) {
			for (Integer invoice : listOrderId) {
				OrderDetailTour detail = orderDetailTourDao.findById(invoice).get();
				detail.setStatus(1);
				orderDetailTourDao.save(detail);
			}
			String redirectUrl = "/travelfpoly/payment/vnpay/paylist?listOrderId="
					+ StringUtils.collectionToCommaDelimitedString(listOrderId);
			return ResponseEntity.ok(redirectUrl);
		}

		return ResponseEntity.ok("/travelfpoly/order");
	}

	@GetMapping("order")
	public String orderTour(Model model, @RequestParam("field") Optional<String> field,
			@RequestParam("sort") Optional<String> sortOrder, @RequestParam("page") Optional<Integer> page) {
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		Sort.Direction sortDirection = sortOrder
				.map(value -> value.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC)
				.orElse(Sort.Direction.DESC);
		Sort sort = Sort.by(sortDirection, field.orElse("StarDate"));
		Pageable pageable = PageRequest.of(page.orElse(0), 3, sort);
		Page<OrderDetailTour> orderDetails = orderDetailTourDao.findOrderByUserId(account.getUserId(), pageable);
		OrderDetailTour orderDetailTour = new OrderDetailTour();
		model.addAttribute("orderDetailTour", orderDetailTour);
		model.addAttribute("list", orderDetails);
		return "user/order";
	}

	@GetMapping("order/search")
	public String searchorderTour(Model model, @RequestParam("field") Optional<String> field,
			@RequestParam("sort") Optional<String> sortOrder, @RequestParam("page") Optional<Integer> page,
			@RequestParam("searchKey") Optional<String> keyword) {

		// Double minPrice=null;
		// Double maxPrice=null;
		// String nameProduct=keyword.orElse(session.getAttribute("keyword"));
		// if(isStringNumeric(nameProduct)) {
		// minPrice=Double.parseDouble(nameProduct);
		// maxPrice=Double.parseDouble(nameProduct)+50;
		// }
		// AccountDTO account = (AccountDTO) session.getAttribute("account");
		// Sort.Direction sortDirection = sortOrder.map(value -> value.equals("asc") ?
		// Sort.Direction.ASC : Sort.Direction.DESC)
		// .orElse(Sort.Direction.DESC);
		// Sort sort=Sort.by(sortDirection,field.orElse("StarDate"));
		// Pageable pageable = PageRequest.of(page.orElse(0), 3,sort);
		// Page<OrderDetailTour> orderDetails =
		// orderDetailTourDao.findOrderByUserIdAndKeyword(account.getUserId(),nameProduct,minPrice,maxPrice,pageable);
		// model.addAttribute("list", orderDetails);
		return "user/order";
	}

	@GetMapping("order/delete/{id}")
	public String deleteTour(@PathVariable("id") Integer id) {
		OrderDetailTour order = orderDetailTourDao.findById(id).get();
		order.setAvailable(false);
		orderDetailTourDao.save(order);
		// set quantity tour
		Integer tourId = order.getOrderDetailTour().getTourId();
		Tour tour = tourDao.findByTourId(tourId);
		tour.setQuantityAdult(tour.getQuantityAdult() + order.getQuantityAdult());
		tour.setQuantityChildren(tour.getQuantityChildren() + order.getQuantityChildren());
		tourDao.save(tour);
		return "redirect:/travelfpoly/order";
	}

	@GetMapping("order/fill/{id}")
	public String fillTour(@PathVariable("id") Integer id, Model model, @RequestParam("field") Optional<String> field,
			@RequestParam("sort") Optional<String> sortOrder, @RequestParam("page") Optional<Integer> page) {
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		Sort.Direction sortDirection = sortOrder
				.map(value -> value.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC)
				.orElse(Sort.Direction.DESC);
		Sort sort = Sort.by(sortDirection, field.orElse("StarDate"));
		Pageable pageable = PageRequest.of(page.orElse(0), 3, sort);
		Page<OrderDetailTour> orderDetails = orderDetailTourDao.findOrderByUserId(account.getUserId(), pageable);

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
	public String addToCart(Model model, @PathVariable("tourId") Integer TourId, @PathVariable("userId") Integer UserId,
			@RequestParam("fullname") String fullname, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("address") String address,
			@RequestParam("startdate") java.sql.Date startdate, @RequestParam("quantityAdult") Integer quantityAdult,
			@RequestParam("quantityChildren") Integer quantityChildren) {

		try {
			Account account = accountDao.findById(UserId).get();
			Tour tour = tourDao.findById(TourId).get();
			Cart checkCart = cartDao.findByUserId(UserId);

			model.addAttribute("account", account);
			if (fullname != null && email != null && startdate != null && phone != null && quantityAdult != null
					&& quantityChildren != null) {
				// add to cart
				if (checkCart == null) {
					checkCart = new Cart();
					checkCart.setEmail(email);
					checkCart.setName(fullname);
					checkCart.setAddress(address);
					checkCart.setPhone(phone);
					checkCart.setCart(account);
					cartDao.save(checkCart);
				}
				// //add to cart item
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
			return "user/productDetail";
		} catch (Exception e) {
			model.addAttribute("message", "Insert cart tour");
			e.printStackTrace();
			return "user/productDetail";

		}
	}
	// @GetMapping("tour-detail")
	// public String tourdetail(Model model) {
	// AccountDTO checkUser = (AccountDTO) session.getAttribute("account");
	// if(checkUser == null) {
	// checkUser = new AccountDTO();
	// session.setAttribute("account", checkUser);
	// }
	// return "user/productDetail";
	// }

	@GetMapping("tour-detail/{id}")
	public String productDetail(@PathVariable("id") Integer id, Model model) {

		TourImage image = tourImageDao.findByTourId(id);
		Tour tour = tourDao.findByTourId(id);
		List<TourSchedule> schedules = tourScheduleDao.findByTourId(id);
		Map<String, String> paymentMethods = new HashMap<>();
		paymentMethods.put("cash", "Payment in cash");
		paymentMethods.put("paypal", "PayPal");
		paymentMethods.put("vnpay", "VN Pay");

		model.addAttribute("paymentMethods", paymentMethods);
		model.addAttribute("image", image);
		model.addAttribute("tour", tour);
		model.addAttribute("schedules", schedules);
		return "user/productDetail";
	}

	@PostMapping("bookNow/{tourId}/{userId}")
	public String booknow(Model model, @PathVariable("tourId") Integer TourId, @PathVariable("userId") Integer UserId,
			@RequestParam("fullname") String fullname, @RequestParam("email") String email,
			@RequestParam("address") String address, @RequestParam("phone") String phone,
			@RequestParam("startdate") java.sql.Date date, @RequestParam("quantityAdult") Integer quantityAdult,
			@RequestParam("quantityChildren") Integer quantityChildren,
			@RequestParam("paymentMethod") String paymentMethod) {
		Account account = accountDao.findById(UserId).get();
		Tour tour = tourDao.findById(TourId).get();
		try {
			if (fullname != null && email != null && date != null && phone != null && quantityAdult != null
					&& quantityChildren != null) {
				// addToOrder Tour
				OrderTour order = new OrderTour();
				order.setAddress(address);
				order.setName(fullname);
				order.setEmail(email);
				order.setPhone(phone);
				orderTourDao.save(order);

				// Add to Order detail Tour
				OrderDetailTour orderDetail = new OrderDetailTour();
				orderDetail.setStarDate(DateHelper.converDateSql(date));
				orderDetail.setEndDate(DateHelper.addDaysToDate(date, tour.getDuration()));
				orderDetail.setBookDate(new Date());
				orderDetail.setPriceAdult(tour.getPriceAdult());
				orderDetail.setPriceChildren(tour.getPriceChildren());
				orderDetail.setStatus(0);
				orderDetail.setAvailable(true);
				orderDetail.setQuantityAdult(quantityAdult);
				orderDetail.setQuantityChildren(quantityChildren);
				orderDetail.setTotal( (quantityAdult * tour.getPriceAdult())+ (quantityChildren * tour.getPriceChildren()) );
				orderDetail.setOrderDetailTour(tour);
				orderDetail.setOrderTour(order);
				orderDetail.setUserOrder(account);
				orderDetail = orderDetailTourDao.saveAndFlush(orderDetail);
				orderDetail
						.setBase64(base64Service.generateQRCodeAndEncodeToBase64(orderDetail.getOrderDetailTourId()));
				orderDetailTourDao.save(orderDetail);

				// set t quantity tour
				tour.setQuantityAdult(tour.getQuantityAdult() - orderDetail.getQuantityAdult());
				tour.setQuantityChildren(tour.getQuantityChildren() - orderDetail.getQuantityChildren());
				tourDao.save(tour);
				
				if (paymentMethod.equals("paypal")) {
					OrderDetailTour detail = orderDetailTourDao.findById(orderDetail.getOrderDetailTourId()).get();
					detail.setStatus(1);
					orderDetailTourDao.save(detail);
					return "redirect:/travelfpoly/payment/index?id=" + orderDetail.getOrderDetailTourId();
				}
				if (paymentMethod.equals("vnpay")) {
					OrderDetailTour detail = orderDetailTourDao.findById(orderDetail.getOrderDetailTourId()).get();
					detail.setStatus(1);
					orderDetailTourDao.save(detail);
					return "redirect:/travelfpoly/payment/vnpay/pay?id=" + orderDetail.getOrderDetailTourId();
				}
				
				InvoiceDTO invoice = orderDetailTourDao.detailInvoice(orderDetail.getOrderDetailTourId());
				mailService.sendMailWithCustomer(invoice);


				return "redirect:/travelfpoly/order";
			}
			model.addAttribute("message", "Book tour is error please check your information!");
			return "user/productDetail";
		} catch (Exception e) {
			model.addAttribute("message", "Can't book tour");
			e.printStackTrace();
			return "user/productDetail";

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

	@GetMapping("tour")
	public String tour(Model model,
			@RequestParam("pageTour") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 9);
		Page<TourWithImageDTO> tours = tourDao.findAllTourWithImage(pageable);
		model.addAttribute("tours", tours);
		return "user/tour";
	}

	@GetMapping("tour/{id}")
	public String tourid(Model model,
			@PathVariable("id") Integer id,
			@RequestParam("pageTour") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 9);
		Page<TourWithImageDTO> tours = tourDao.findByCategoryId(id, pageable);
		model.addAttribute("tours", tours);
		return "user/tour";
	}

	public boolean isStringNumeric(String input) {
		String regex = "^[-+]?\\d+(\\.\\d+)?$";
		return input.matches(regex);
	}

	@Autowired
	private OrderHotelDAO orderHotelDAO;

	@Autowired
	private OrderDetailHotelDAO orderDetailHotelDAO;

	@GetMapping("hotel")
	public String hotel(Model model,
			@RequestParam("pageHotel") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 9);
		Page<HotelDTO> hotels = hotelDao.findAllHotelWithImage(pageable);
		model.addAttribute("hotels", hotels);

		return "user/hotel";
	}

	@GetMapping("hotel-detail/{id}")
	public String hotelDetail(@PathVariable("id") Integer id, Model model) {
		Hotel hotel = hotelDAO.findById(id).orElse(null);
		HotelImage hotelImage = hotelImageDAO.findById(id).orElse(null);
		List<TourSchedule> schedules = tourScheduleDao.findByTourId(id);

		model.addAttribute("schedules", schedules);
		model.addAttribute("hotel", hotel);
		model.addAttribute("hotelImage", hotelImage);

		return "user/hotel-single";
	}

	@PostMapping("hotel-detail/{id}")
	public String submitForm(@PathVariable(name = "id", required = false) Integer id,
			String fullname, String email, String phone,
			String BookingDate, String checkin, String checkout) {
		return "redirect:/travelfpoly/hotel-detail/" + id + "/page2?fullname=" + fullname
				+ fullname + "?email=" + email
				+ "?phone=" + phone + "?BookingDate=" + BookingDate + "?checkin=" + checkin +
				"?checkout=" + checkout;
	}

	@GetMapping("hotel-detail/{id}/page2")
	public String ShowPage(Model model, @PathVariable(name = "id", required = false) Integer id,
			@RequestParam String fullname,
			@RequestParam("email") String email,
			@RequestParam String phone, @RequestParam java.sql.Date BookingDate,
			@RequestParam java.sql.Date checkin,
			@RequestParam java.sql.Date checkout) {
		Hotel hotel = hotelDAO.findById(id).orElse(null);
		HotelImage hotelImage = hotelImageDAO.findById(id).orElse(null);
		List<TourSchedule> schedules = tourScheduleDao.findByTourId(id);

		Map<String, String> paymentMethods = new HashMap<>();
		paymentMethods.put("cash", "Payment in cash");
		paymentMethods.put("paypal", "PayPal");
		paymentMethods.put("vnpay", "VN Pay");

		model.addAttribute("paymentMethods", paymentMethods);

		model.addAttribute("schedules", schedules);
		model.addAttribute("hotel", hotel);
		model.addAttribute("hotelImage", hotelImage);
		model.addAttribute("fullname", fullname);
		model.addAttribute("email", email);
		model.addAttribute("phone", phone);
		model.addAttribute("BookingDate", BookingDate);
		model.addAttribute("checkin", checkin);
		model.addAttribute("checkout", checkout);

		return "user/orderhotel";
	}

	@PostMapping("cartOrderHotel/{HotelId}/{userId}")
	public String saveOrderHotel(
			@PathVariable(name = "HotelId") Integer HotelId,
			@PathVariable(name = "userId") Integer UserId,
			@RequestParam String fullname,
			@RequestParam("email") String email,
			@RequestParam String phone,
			@RequestParam java.sql.Date checkin,
			@RequestParam java.sql.Date checkout,
			@RequestParam java.sql.Date BookingDate,
			@RequestParam Double price,
			@RequestParam("paymentMethod") String paymentMethod) {
		Account account = accountDao.findById(UserId).get();

		LocalDate checkinlocal = checkin.toLocalDate();
		LocalDate checkoutlocal = checkout.toLocalDate();
		long daysBetween = ChronoUnit.DAYS.between(checkinlocal, checkoutlocal);
		int monthsBetween = (int) (daysBetween / 30);

		try {

			OrderHotel orderHotel = new OrderHotel();
			orderHotel.setName(fullname);
			orderHotel.setEmail(email);
			orderHotel.setPhone(phone);
			orderHotelDAO.save(orderHotel);

			OrderDetailHotel orderDetailHotel = new OrderDetailHotel();
			orderDetailHotel.setCheckIn(DateHelper.converDateSql(checkin));
			orderDetailHotel.setCheckOut(DateHelper.converDateSql(checkout));
			orderDetailHotel.setPrice(price);
			orderDetailHotel.setQuantity(1);
			orderDetailHotel.setBookDate(DateHelper.converDateSql(BookingDate));
			orderDetailHotel.setStatus(1);
			orderDetailHotel.setOrderHotel(orderHotel);
			orderDetailHotel.setAccount(account);
			orderDetailHotel.setOrderDetailHotel(hotelDao.findById(UserId).get());
			orderDetailHotelDAO.saveAndFlush(orderDetailHotel);
			orderDetailHotel.setBase64(
					base64Service.generateQRCodeAndEncodeToBase64Hotel(orderDetailHotel.getOrderDetailHotelId()));
			orderDetailHotel.setTotal((double) daysBetween * price);
			orderDetailHotelDAO.save(orderDetailHotel);


			if (paymentMethod.equals("paypal")) {
				OrderDetailHotel orderhotel = orderDetailHotelDAO
						.findById(orderDetailHotel.getOrderDetailHotelId()).get();
				orderDetailHotel.setStatus(2);
				orderDetailHotelDAO.save(orderhotel);
				return "redirect:/travelfpoly/payment/paypalhotel?id=" +
						orderDetailHotel.getOrderDetailHotelId();
			}
			if (paymentMethod.equals("vnpay")) {
				OrderDetailHotel orderhotel = orderDetailHotelDAO
						.findById(orderDetailHotel.getOrderDetailHotelId()).get();
				orderDetailHotel.setStatus(0);
				orderDetailHotelDAO.save(orderhotel);
				return "redirect:/travelfpoly/payment/vnpay/payhotel?id=" +
						orderDetailHotel.getOrderDetailHotelId();
			}
			
			orderHotelDTO order = orderDetailHotelDAO.OrderdetailHotelInvoice(orderDetailHotel.getOrderDetailHotelId());
			mailService.sendMailwithCustomerOrderHotel(order);
			
			return "redirect:/travelfpoly/hotel";
		} catch (Exception e) {
			e.getStackTrace();
			return "user/nextPay";
		}
	}

}
