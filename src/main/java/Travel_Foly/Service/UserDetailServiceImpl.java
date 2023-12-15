package Travel_Foly.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.DTO.AccountDTO;
import Travel_Foly.Model.Account;
import jakarta.servlet.http.HttpSession;

@Service 
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private AccountDAO accountDao;
	
	public UserDetailServiceImpl(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}
	public UserDetailServiceImpl() {
//		this.accountDao = null;
//		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> account = accountDao.findByUsername(username);
		System.out.println(account.get().getUsername());
		return account.orElseThrow(() -> new UsernameNotFoundException("User not available"));
	}

}
