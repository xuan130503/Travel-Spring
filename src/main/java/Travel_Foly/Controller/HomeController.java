package Travel_Foly.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/TravelFpoly/")
public class HomeController {

	@GetMapping("Home")
	public String home() {
		return "index";
	}
	@GetMapping("Home2")
	public String home2() {
		return "index-2";
	}
	@GetMapping("About")
	public String about() {
		return "about";
	}
	@GetMapping("Blog")
	public String blog() {
		return "blog";
	}
	@GetMapping("BlogDetail")
	public String blogDetail() {
		return "blog-single";
	}
	@GetMapping("Contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("Hotel")
	public String hotel() {
		return "hotel";
	}
	@GetMapping("Hotel-Detail")
	public String hotelDetail() {
		return "hotel-single";
	}
	@GetMapping("Tour")
	public String tour() {
		return "tour";
	}
}
