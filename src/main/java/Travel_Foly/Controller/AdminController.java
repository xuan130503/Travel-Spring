package Travel_Foly.Controller;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.DAO.CategoryTourDAO;
import Travel_Foly.DAO.HotelDAO;
import Travel_Foly.DAO.OrderDetailHotelDAO;
import Travel_Foly.DAO.OrderDetailTourDAO;
import Travel_Foly.DAO.TourDAO;
import Travel_Foly.DTO.InvoiceDTO;
import Travel_Foly.DTO.MonthlyRevenueDTO;
import Travel_Foly.Helper.DateHelper;
import Travel_Foly.Model.Account;
import Travel_Foly.Model.CategoryTour;
import Travel_Foly.Model.OrderDetailTour;
import Travel_Foly.Model.Tour;
import Travel_Foly.Service.AccountService;
import Travel_Foly.Service.SessionService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class AdminController {
	@Autowired
	private HttpServletRequest req;
	@Autowired
	private TourDAO tourDao;
	@Autowired
	private OrderDetailTourDAO orderDetailTourDao;

	@Autowired
	private OrderDetailHotelDAO orderDetailHotelDao;

	@Autowired
	private HotelDAO hotelDao;

	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private CategoryTourDAO categoryTourDao;

	@Autowired
	private SessionService session;

	@Autowired
	private AccountService accountService;

	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@GetMapping("index")
	public String index(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("pageUser") Optional<Integer> pageUser) {
		Integer reportTour = tourDao.reportTour();
		Integer reportHotel = hotelDao.reportHotel();
		Integer reportTourQuantity = tourDao.reportTourQuantity(1);
		Integer hotelQuantity = hotelDao.reportTourQuantity(1);
		Integer reportOrderTour = orderDetailTourDao.reportOrder();
		Integer reportOrderHotel = orderDetailHotelDao.reportOrder();
		Integer reportUser = accountDao.reportUser();
		Integer getall = orderDetailTourDao.getAllOrderDetailTours();
		Double getRevenue = orderDetailTourDao.getRevenueOrderDetailTour()
				+ orderDetailHotelDao.getRevenueOrderDetailHotel();

		model.addAttribute("tour", reportTour);
		model.addAttribute("hotel", reportHotel);
		model.addAttribute("tourQuantity", reportTourQuantity);
		model.addAttribute("hotelQuantity", hotelQuantity);
		model.addAttribute("orderTour", reportOrderTour);
		model.addAttribute("orderHotel", reportOrderHotel);
		model.addAttribute("user", reportUser);
		model.addAttribute("get", getall);
		model.addAttribute("getRevenue", getRevenue == null ? 0 : getRevenue);

		// table order
		Pageable pageableTour = PageRequest.of(page.orElse(0), 5);
		Page<OrderDetailTour> orderDetail = orderDetailTourDao.findOrder(pageableTour);
		model.addAttribute("listOrder", orderDetail);

		Pageable pageableUser = PageRequest.of(page.orElse(0), 5);
		Page<Account> listAccount = accountDao.findUser(pageableUser);
		model.addAttribute("listAccount", listAccount);

		return "admin/index";
	}

	@GetMapping("addinternal")
	public String addInternal() {
		return "admin/form-add-bi-cam";
	}

	// -- Khong co sua //
	@GetMapping("addorder")
	public String addOrder(Model model, @RequestParam("page") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 4);
		Page<InvoiceDTO> invoices = orderDetailTourDao.findAlldetailInvoice(pageable);
		InvoiceDTO invoice = new InvoiceDTO();
		model.addAttribute("invoice", invoice);
		model.addAttribute("listInvoice", invoices);
		return "admin/form-add-don-hang";
	}

	@GetMapping("addorder/search")
	public String searchInvoice(Model model, @RequestParam("searchKey") String keyword,
			@RequestParam("page") Optional<Integer> page) {
		System.out.println(keyword);
		Pageable pageable = PageRequest.of(page.orElse(0), 4);

		Integer id = null;
		InvoiceDTO invoice = new InvoiceDTO();
		if (isStringNumeric(keyword)) {
			id = Integer.parseInt(keyword);
			invoice = orderDetailTourDao.detailInvoice(id);
		}

		Page<InvoiceDTO> invoices = orderDetailTourDao.searchInvoice(pageable, id, keyword, keyword);
		model.addAttribute("total", invoice.getTotal() == null ? 0 : invoice.getTotal());
		model.addAttribute("invoice", invoice);
		model.addAttribute("listInvoice", invoices);
		return "admin/form-add-don-hang";
	}

	@GetMapping("addorder/{id}")
	public String updateOrder(Model model, @PathVariable("id") Integer id,
			@RequestParam("page") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 4);
		Page<InvoiceDTO> invoices = orderDetailTourDao.findAlldetailInvoice(pageable);
		InvoiceDTO invoice = orderDetailTourDao.detailInvoice(id);
		Double total = invoice.getPriceAdult() * invoice.getQuantityAdult()
				+ invoice.getPriceChildren() * invoice.getQuantityChildren();
		model.addAttribute("total", total == null ? 0 : total);
		model.addAttribute("invoice", invoice);
		model.addAttribute("listInvoice", invoices);
		return "admin/form-add-don-hang";
	}

	@PostMapping("addorder/create/{id}")
	public String updateOrder(Model model,
			@PathVariable("id") Integer id,
			@RequestParam("CustomerName") String userName,
			// @RequestParam("StartDate") java.util.Date date,
			@RequestParam("QuantityAdult") Integer QuantityAdult,
			@RequestParam("QuantityChildren") Integer QuantityChildren) {
		System.out.println(id);
		return "redirect:/travelfpoly/admin/addorder";
	}
	// toi day

	@GetMapping("addstaff")
	public String staff(Model model, @RequestParam("page") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 4);
		Page<Account> accounts = accountDao.findStaff(pageable);
		Account account = new Account();
		model.addAttribute("account", account);
		model.addAttribute("listAccount", accounts);
		return "admin/form-add-nhan-vien";
	}

	@GetMapping("addstaff/{id}")
	public String staffindex(Model model, @PathVariable("id") Integer id,
			@RequestParam("page") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 4);
		Page<Account> accounts = accountDao.findStaff(pageable);
		Account account = accountDao.findById(id).get();
		System.out.println("User name: " + account.getUsername());
		System.out.println("Password: " + account.getPassword());
		model.addAttribute("account", account);
		model.addAttribute("listAccount", accounts);
		return "admin/form-add-nhan-vien";
	}

	@PostMapping("addstaff/create")
	public String addStaff(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("fullname") String fullname,
			@RequestParam("email") String email, @RequestParam("address") String address,
			@RequestParam("phone") String phone, @RequestParam("age") Integer age) {

		Account checkAccount = accountDao.findOneByUserName(username);
		if (checkAccount != null) {
			checkAccount.setPassWord(encoder.encode(password));
			checkAccount.setFullName(fullname);
			checkAccount.setEmail(email);
			checkAccount.setAddress(address);
			checkAccount.setPhone(phone);
			checkAccount.setAge(age);
			// if (file != null) {
			// checkAccount.setImage(file.getOriginalFilename());
			// saveFile(file, "/images");
			// } else {
			// checkAccount.setImage("");
			// }
			checkAccount.setActivated(true);
			checkAccount.setRole(true);
			accountDao.save(checkAccount);
		} else {
			Account account = new Account();
			account.setUserName(username);
			account.setPassWord(encoder.encode(password));
			account.setFullName(fullname);
			account.setEmail(email);
			account.setAddress(address);
			account.setPhone(phone);
			account.setAge(age);
			// if (file != null) {
			// account.setImage(file.getOriginalFilename());
			// saveFile(file, "/images");
			// } else {
			// account.setImage("");
			// }
			account.setRole(true);
			account.setActivated(true);
			accountDao.save(account);
		}

		return "redirect:/travelfpoly/admin/addstaff";
	}

	@GetMapping("addstaff/delete/{id}")
	public String staffDelete(@PathVariable("id") Integer id) {
		accountDao.deleteById(id);
		return "redirect:/travelfpoly/admin/addstaff";
	}

	@GetMapping("addcategory")
	public String addCategory(@RequestParam("categoryName") String name) {
		CategoryTour category = new CategoryTour();
		category.setName(name);
		categoryTourDao.save(category);
		return "redirect:/travelfpoly/admin/addproduct";
	}

	// add Tour

	// @GetMapping("addproduct")
	// public String addProduct(Model model
	// ,@RequestParam("page") Optional<Integer> page) {
	// Tour tour = new Tour();
	// tour.setTour(categoryTourDao.findById(1).get());
	// Pageable pageable = PageRequest.of(page.orElse(0), 4);
	// Page<Tour> tours= tourDao.findAllTour(pageable);
	// List<CategoryTour> categories= categoryTourDao.findAll();
	// model.addAttribute("categories", categories);
	// model.addAttribute("tour", tour);
	// model.addAttribute("tours", tours);

	// return "admin/form-add-san-pham";
	// }
	// @GetMapping("addproduct/{tourId}/{categoryId}")
	// public String productindex(Model model
	// ,@PathVariable("tourId") Integer id
	// ,@PathVariable("categoryId") Integer categoryid
	// ,@RequestParam("page") Optional<Integer> page
	// ) {
	// // Tour tour = new Tour();
	// // Pageable pageable= PageRequest.of(page.orElse(0), 4);
	// // Page<Tour> tours = tourDao.findAllTour(pageable);
	// // tour = tourDao.findById(id).get();
	// // tour.setTour(categoryTourDao.findById(categoryid).get());
	// // List<CategoryTour> categories= categoryTourDao.findAll();
	// // model.addAttribute("categories", categories);
	// // model.addAttribute("tour", tour);
	// // model.addAttribute("tours", tours);
	// return "admin/form-add-san-pham";
	// }
	// @PostMapping("addproduct/create")
	// public String addproduct(Model model
	// ,@RequestParam("id") Integer id
	// ,@RequestParam("name") String name
	// ,@RequestParam("category") Integer category
	// ,@RequestParam("available") Boolean available
	// ,@RequestParam("price") Double price
	// ,@RequestParam("description") String description
	// ) {

	// // Tour checkTour = tourDao.findByTourId(id);
	// // CategoryTour categorys = categoryTourDao.findById(category).get();
	// // if(checkTour !=null) {
	// // checkTour.setName(name);
	// // checkTour.setTour(categorys);
	// // checkTour.setAvailable(available);
	// // checkTour.setDescription(description);
	// // checkTour.setPrice(price);
	// // tourDao.save(checkTour);
	// // }else {
	// // Tour tour = new Tour();
	// // tour.setName(name);
	// // tour.setTour(categorys);
	// // tour.setAvailable(available);
	// // tour.setDescription(description);
	// // tour.setPrice(price);
	// // tourDao.save(tour);
	// // }

	// return "redirect:/travelfpoly/admin/addproduct";
	// }
	// @GetMapping("addproduct/delete/{id}")
	// public String productDelete(@PathVariable("id") Integer id) {
	// tourDao.deleteById(id);
	// return "redirect:/travelfpoly/admin/addproduct";
	// }

	@GetMapping("addsalary")
	public String internal() {
		return "admin/form-add-tien-luong";
	}

	@GetMapping("calendar")
	public String calendar() {
		return "admin/page-calendar";
	}

	@GetMapping("sale")
	public String sale() {
		return "admin/phan-mem-ban-hang";
	}

	@GetMapping("report")
	public String report(Model model) {

		List<MonthlyRevenueDTO> revenueYear = orderDetailTourDao.getListYearlyRevenue();
		model.addAttribute("revenueYear", revenueYear);

		List<MonthlyRevenueDTO> revenueHotelYear = orderDetailHotelDao.getListYearlyRevenue();
		model.addAttribute("revenueHotelYear", revenueHotelYear);

		List<MonthlyRevenueDTO> quantityTourYear = orderDetailTourDao.getListQuantityOrderTour();
		model.addAttribute("quantityTourYear", quantityTourYear);

		List<MonthlyRevenueDTO> quantityHotelYear = orderDetailHotelDao.getListQuantityOrderHotel();
		model.addAttribute("quantityHotelYear", quantityHotelYear);

		Integer reportTour = tourDao.reportTour();
		Integer reportHotel = hotelDao.reportHotel();
		Integer reportTourQuantity = tourDao.reportTourQuantity(0);
		Integer hotelQuantity = hotelDao.reportTourQuantity(0);
		Integer reportOrderTour = orderDetailTourDao.reportOrder();
		Integer reportOrderHotel = orderDetailHotelDao.reportOrder();
		Integer reportAdmin = accountDao.reportAdmin();
		Integer getall = orderDetailTourDao.getAllOrderDetailTours();
		Double getRevenue = orderDetailTourDao.getRevenueOrderDetailTour()
				+ orderDetailHotelDao.getRevenueOrderDetailHotel();
		Integer staff = accountDao.reportStaff();
		Integer staffIsBaned = accountDao.reportStaffisBaned();
		Integer orderCancel = orderDetailTourDao.findOrderCancel();
		Integer reportUser = accountDao.reportUser();

		List<Object[]> bestSellingTour = orderDetailTourDao.getBestSellingTour();
		model.addAttribute("bestSellingTours", bestSellingTour);

		List<Object[]> bestSellingHotel = orderDetailHotelDao.getBestSellingHotel();
		model.addAttribute("bestSellingHotels", bestSellingHotel);

		model.addAttribute("user", reportUser);
		model.addAttribute("staff", staff);
		model.addAttribute("orderCancel", orderCancel);
		model.addAttribute("staffIsBaned", staffIsBaned);
		model.addAttribute("tour", reportTour);
		model.addAttribute("hotel", reportHotel);
		model.addAttribute("tourQuantity", reportTourQuantity);
		model.addAttribute("hotelQuantity", hotelQuantity);
		model.addAttribute("orderTour", reportOrderTour);
		model.addAttribute("orderHotel", reportOrderHotel);
		model.addAttribute("reportAdmin", reportAdmin);
		model.addAttribute("get", getall);
		model.addAttribute("getRevenue", getRevenue == null ? 0 : getRevenue);

		return "admin/quan-ly-bao-cao";

	}

	// Integer staff=accountDao.reportStaff();
	// model.addAttribute("staff", staff);
	// Integer staffIsBaned=accountDao.reportStaffisBaned();
	// model.addAttribute("staffIsBaned", staffIsBaned);
	// Integer reportTour = tourDao.reportTour();
	// model.addAttribute("tour", reportTour);
	// Integer reportTourQuantity = tourDao.reportTourQuantity(0);
	// model.addAttribute("tourQuantity", reportTourQuantity);
	// Integer reportOrder = orderDetailTourDao.reportOrder();
	// model.addAttribute("order", reportOrder);
	// Integer reportUser = accountDao.reportUser();
	// model.addAttribute("user", reportUser);
	// Double totalIncome = orderDetailTourDao.findTotalIncome();
	// model.addAttribute("total", totalIncome);
	// Integer orderCancel = orderDetailTourDao.findOrderCancel();
	// model.addAttribute("orderCancel", orderCancel);
	// List<Tour> bestSellingTours = tourService.getBestSellingTours();
	// model.addAttribute("bestSellingTours", bestSellingTours);
	@GetMapping("testreport")
	public String testReport() {
		List<MonthlyRevenueDTO> revenueYear = orderDetailTourDao.getListYearlyRevenue();
		System.out.println(revenueYear);
		return "hello";
	}

	@GetMapping("login")
	public String login() {
		return "admin/index";
	}

	public File saveFile(MultipartFile file, String path) {
		if (!file.isEmpty()) {
			File dir = new File(req.getServletContext().getRealPath(path));
			if (!dir.exists()) {
				dir.mkdirs();
			}
			try {
				File saveFile = new File(dir, file.getOriginalFilename());
				file.transferTo(saveFile);
				return saveFile;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean isStringNumeric(String input) {
		String regex = "^[-+]?\\d+(\\.\\d+)?$";
		return input.matches(regex);
	}

	// hiển thị thông tin user information

	@GetMapping("user_information")
	public String userinformation(Model model, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
			@Param("keyword") String keyword) {
		Page<Account> account = accountService.getAll(pageNo);
		if (keyword != null) {
			account = accountService.SearchPageTourService(keyword, pageNo);
			model.addAttribute("keyword", keyword);

		}
		model.addAttribute("account", account);
		model.addAttribute("totalPage", account.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		return "admin/userInformation";
	}
}
