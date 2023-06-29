package Travel_Foly.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/TravelFpoly/Admin/")
public class AdminController {
	@GetMapping("Index")
	public String index() {
		return "admin/index";
	}
	@GetMapping("AddInternal")
	public String addInternal() {
		return "admin/form-add-bi-cam";
	}
	@GetMapping("AddOrder")
	public String addOrder() {
		return "admin/form-add-don-hang";
	}
	@GetMapping("AddStaff")
	public String addStaff() {
		return "admin/form-add-nhan-vien";
	}
	@GetMapping("AddProduct")
	public String addProduct() {
		return "admin/form-add-san-pham";
	}
	@GetMapping("AddSalary")
	public String internal() {
		return "admin/form-add-tien-luong";
	}
	@GetMapping("Calendar")
	public String calendar() {
		return "admin/page-calendar";
	}
	@GetMapping("Sale")
	public String sale() {
		return "admin/phan-mem-ban-hang";
	}
	@GetMapping("Report")
	public String report() {
		return "admin/quan-ly-bao-cao";
	}
	@GetMapping("Login")
	public String login() {
		return "admin/index";
	}
	
}
