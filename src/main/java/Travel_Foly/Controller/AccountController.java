package Travel_Foly.Controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;
import java.util.Random;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.client.http.HttpRequest;

import Travel_Foly.Config.Utility;
import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.DAO.IntimateDAO;
import Travel_Foly.DTO.AccountDTO;
import Travel_Foly.DTO.RegisterDTO;
import Travel_Foly.Model.Account;
import Travel_Foly.Service.AccountService;
import Travel_Foly.Service.SessionService;
import Travel_Foly.Service.UserDetailServiceImpl;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("/travelfpoly/account/")
public class AccountController {
	@Autowired
	AccountDAO accountDao;
	
	@Autowired
	IntimateDAO intimateDao;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserDetailServiceImpl userDetail;
	
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

	@GetMapping("login?error")
	public String loginError(Principal principal, Model model) {
		model.addAttribute("message", "Login is Error");
		getPricipal(principal);
		return "user/signin";
	}
	@GetMapping("getPrincipal")
	public String getPrincipal(Principal principal) {
		AccountDTO acDTO = accountDao.findOneUsername(principal.getName());
		if(acDTO == null) {
			Account account = new Account();
			account.setUserName(principal.getName());
			account.setAccount(intimateDao.findById(1).get());
			account.setRole(false);
			account.setAddress("");
			account.setFullName("");
			account.setAddress("");
			account.setAddress("");
			account.setEmail("");
			account.setPhone("");
			account.setPassWord(encoder.encode(principal.getName()));
			account.setAge(0);
			account.setActivated(true);
			accountDao.save(account);
			UserDetails user =  userDetail.loadUserByUsername(account.getUsername());
			
			System.out.println(user.getAuthorities());
		}
		
		System.out.println(principal.toString());
		return "redirect:/travelfpoly/home";
	}
	@PostMapping("login")
	public void loginUser(
			Model model,
			Principal principal,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String checkAccount = accountDao.checkLogin(username);
		if (checkAccount == null)
			model.addAttribute("message", "Tài khoản không tồn tại");

		else {
			if (password.equals(checkAccount))
				model.addAttribute("message", "Tài khoản không tồn tại");
			else
				getPricipal(principal);
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
	public String register(@ModelAttribute @Valid RegisterDTO registerDTO

			, @RequestParam("passwordConfirm") String passworConfirm, BindingResult bindingResult, Model model) {
		List<Account> checkAccount = accountDao.findAll();
		for (Account account : checkAccount) {
			if (account.getUsername().equals(registerDTO.getUsername())) {
				model.addAttribute("errorMessage", "Account already exists");
				return "user/signup";
			} else {
				if (account.getEmail().equals(registerDTO.getEmail())) {
					model.addAttribute("errorMessage", "The Email was registered");
					return "user/signup";
				} else {
					if (!passworConfirm.equals(registerDTO.getPassword())) {
						model.addAttribute("errorMessage", "Password and confirm password are not correct");
						return "user/signup";
					} else {
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

	@GetMapping("forgot_password")
	public String showForgotPasswordForm() {
		return "user/forgot_password_form";
	}

	public void sendEmail(String recipientEmail, String link)
			throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("contact@shopme.com", "TravelFpoly Support");
		helper.setTo(recipientEmail);

		String subject = "Here's the link to reset your password";

		String content = "<p>Hello,</p>"
				+ "<p>You have requested to reset your password.</p>"
				+ "<p>Click the link below to change your password:</p>"
				+ "<p><a href=\"" + link + "\">Change my password</a></p>"
				+ "<br>"
				+ "<p>Ignore this email if you do remember your password, "
				+ "or you have not made the request.</p>";

		helper.setSubject(subject);

		helper.setText(content, true);
		mailSender.send(message);
	}

	@PostMapping("forgot_password")
	public String processForgotPassword(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
		String token = RandomString.make(30);
		try {
			String status = accountService.updateResetPasswordToken(token, email);
			if(status.equals("Success")) {
				String resetPasswordLink = Utility.getSiteURL(request) + "/travelfpoly/account/reset_password?token="
					+ token;
				sendEmail(email, resetPasswordLink);
				model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
			}
			
			else {
				model.addAttribute("message", status);
			}

		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("message", "Error while sending email");
		}
		return "user/forgot_password_form";
	}

	@GetMapping("reset_password")
	public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
		Account account = accountService.getByResetPasswordToken(token);
		model.addAttribute("token", token);
		
		if (account == null) {
			model.addAttribute("message", "Invalid Token");
			return "message";
		}

		return "user/reset_password_form";
	}

	@PostMapping("reset_password")
	public String processResetPassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");

		Account account = accountService.getByResetPasswordToken(token);
		model.addAttribute("title", "Reset your password");

		if (account == null) {
			model.addAttribute("message", "Invalid Token");
			return "user/signin";
		} else {
			accountService.updatePassword(account, password);

			model.addAttribute("message", "You have successfully changed your password.");
		}

		return "user/signin";
	}
	
	@GetMapping("reset_password_user/{id}")
	public String resetPassUser(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("userId", id);
		return "user/reset_password_user_form";
	}
	@PostMapping("reset_password_user/{id}")
	public String resetPassUserPost(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
		Account account = accountDao.findById(id).get();
		System.out.println("name reset:"+account.getFullName());
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passConfirm");
		if(password.equals(passwordConfirm)) {
			account.setPassWord(encoder.encode(password));
			accountDao.save(account);
			return "redirect:/travelfpoly/account/login";
		}
		
		return "redirect:/travelfpoly/account/reset_password_user_form/"+id;
	}
}
