package Travel_Foly.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.Model.Account;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountService {

    @Autowired
    AccountDAO accountDAO;

    public String updateResetPasswordToken(String token, String email) {
        Account account = accountDAO.findByEmail(email);
        if (account != null) {
            account.setResetPasswordToken(token);
            accountDAO.save(account);
            return "Success";
        }
        else {
        	return"Can not find your email";
        }
        
    }

    public Account getByResetPasswordToken(String token) {
        return accountDAO.findByResetPasswordToken(token);
    }

    public void updatePassword(Account account, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(newPassword);
        account.setPassWord(encodePassword);
        account.setResetPasswordToken(null);
        accountDAO.save(account);
    }
}
