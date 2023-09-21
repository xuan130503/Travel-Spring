package Travel_Foly.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.DTO.AccountDTO;
import Travel_Foly.DTO.RegisterDTO;
import Travel_Foly.Model.Account;
import Travel_Foly.Service.SessionService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/travelfpoly/account/")
public class AccountController {
	@Autowired
	AccountDAO accountDao;
	
	@Autowired
	SessionService session;
	
	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
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
	public void loginUser(
				Model model,
				Principal principal,
				@RequestParam("username") String username,
				@RequestParam("password") String password
				) {
		String checkAccount = accountDao.checkLogin(username);
		if(checkAccount==null)  model.addAttribute("message", "Tài khoản không tồn tại");
		
		else {
			if(password.equals(checkAccount)) model.addAttribute("message", "Tài khoản không tồn tại");
			else getPricipal(principal);
		}
	}
	@GetMapping("signup")
	public String signup(Model model) {
		model.addAttribute("registerDTO", new RegisterDTO());
		return "user/signup";
	}
	@PostMapping("logout")
	public void logoutUser() {
		session.removeAttribute("amount");
		session.removeAttribute("account");
	}
	
	@PostMapping("register")
	public String register(@ModelAttribute  @Valid RegisterDTO registerDTO
							
							,@RequestParam("passwordConfirm") String passworConfirm
							,BindingResult bindingResult, Model model) {
		List<Account> checkAccount = accountDao.findAll();
		for (Account account : checkAccount) {
			if(account.getUsername().equals(registerDTO.getUsername())) {
				model.addAttribute("errorMessage", "Account already exists");
				return "user/signup";
			}
			else {
				if(account.getEmail().equals(registerDTO.getEmail())) {
					model.addAttribute("errorMessage", "The Email was registered");
					return "user/signup";
				}
				else {
					if(!passworConfirm.equals(registerDTO.getPassword())) {
						model.addAttribute("errorMessage", "Password and confirm password are not correct");
						return "user/signup";
					}
					else {
						Account user = new Account();
						user.setUserName(registerDTO.getUsername());
						user.setPassWord(encoder.encode(registerDTO.getPassword()));
						user.setEmail(registerDTO.getEmail());
						user.setActivated(true);
						user.setRole(false);
		
						accountDao.save(user);
						return "user/signin";
					}
				}
			}
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorMessage", "Error, please register again !");
			return "user/signup";
		}
		
		return "user/signup";
	}
}
