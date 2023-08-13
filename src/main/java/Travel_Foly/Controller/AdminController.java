package Travel_Foly.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class AdminController {
	@GetMapping("index")
	public String index() {
		return "admin/index";
	}
	@GetMapping("addinternal")
	public String addInternal() {
		return "admin/form-add-bi-cam";
	}
	@GetMapping("addOrder")
	public String addOrder() {
		return "admin/form-add-don-hang";
	}
	@GetMapping("addstaff")
	public String addStaff() {
		return "admin/form-add-nhan-vien";
	}
	@GetMapping("addproduct")
	public String addProduct() {
		return "admin/form-add-san-pham";
	}
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
	public String report() {
		return "admin/quan-ly-bao-cao";
	}
	@GetMapping("login")
	public String login() {
		return "admin/index";
	}
	
}
