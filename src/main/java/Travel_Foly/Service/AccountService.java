package Travel_Foly.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.Model.Account;
import Travel_Foly.Model.TourService;
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
        } else {
            return "Can not find your email";
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

    public Page<Account> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5);
        return this.accountDAO.findAll(pageable);
    }

    public List<Account> searchTourService(String keyword) {
        return this.accountDAO.AccountSearch(keyword);
    }

    public Page<Account> SearchPageTourService(String keyword, Integer pageNo) {
        List list = this.accountDAO.AccountSearch(keyword);

        Pageable pageable = PageRequest.of(pageNo - 1, 5);

        Integer start = (int) pageable.getOffset();
        Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
                : pageable.getOffset() + pageable.getPageSize());

        list = list.subList(start, end);

        return new PageImpl<Account>(list, pageable,
                this.accountDAO.AccountSearch(keyword).size());
    }
}
