package Travel_Foly.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/TravelFpoly/")
public class HomeController {

	@GetMapping("Home")
	public String home() {
		return "user/index";
	}
	@GetMapping("ProductDetail")
	public String productDetail() {
		return "user/test";
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
