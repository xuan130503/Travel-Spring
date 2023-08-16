package Travel_Foly.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.DTO.AccountDTO;
import Travel_Foly.Model.Account;
import Travel_Foly.Service.SessionService;

@Controller
@RequestMapping("/travelfpoly/account/")
public class AccountController {
	@Autowired
	AccountDAO accountDao;
	
	@Autowired
	SessionService session;
	
	public void getPricipal(Principal principal) {
		if (principal != null && principal instanceof Authentication) {
            Authentication authentication = (Authentication) principal;
            if (authentication.getPrincipal() instanceof Account) {
                String username = ((Account) authentication.getPrincipal()).getUsername();
                AccountDTO account = accountDao.findOneUsername(username);
                session.setAttribute("account", account);
            }
        }
	}
	@GetMapping("login")
	public String login(Principal principal) {
		getPricipal(principal);
		return "user/signin";
	}
	@PostMapping("login")
	public void loginUser(Principal principal) {
		getPricipal(principal);
	}
	@GetMapping("signup")
	public String logout() {
		return "user/signup";
	}
	@PostMapping("logout")
	public void logoutUser() {
		session.removeAttribute("amount");
		session.removeAttribute("account");
	}
}
