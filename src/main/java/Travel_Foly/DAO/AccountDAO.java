package Travel_Foly.DAO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import Travel_Foly.DTO.AccountDTO;
import Travel_Foly.Model.Account;
import Travel_Foly.Model.Hotel;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {
	@Query("Select a from Account a")
	List<Account> findAllUser();

	@Query("Select a From Account a Where a.UserName=?1")
	Optional<Account> findByUsername(String Username);

	@Query("Select a.PassWord From Account a Where a.UserName=?1")
	String checkLogin(String UserName);

	@Query("Select new Travel_Foly.DTO.AccountDTO(a.UserId, a.UserName, a.Role)  From Account a Where a.UserName=?1")
	AccountDTO findOneUsername(String Username);

	@Query("Select count(a) from Account a "
			+ "Where a.Role=false "
			+ "and a.Activated=true")
	Integer reportUser();

	@Query("Select count(a) from Account a "
			+ "Where a.Role=false "
			+ "and a.Activated=false")
	Integer reportAdmin();

	@Query("Select count(a) from Account a "
			+ "Where a.Role=true "
			+ "and a.Activated=true")
	Integer reportStaff();

	@Query("Select count(a) from Account a "
			+ "Where a.Role=true "
			+ "and a.Activated=false")
	Integer reportStaffisBaned();

	@Query("Select a From Account a where a.Role=True")
	Page<Account> findStaff(Pageable page);

	@Query("Select a From Account a Where a.UserName=?1")
	Account findOneByUserName(String username);

	@Query("Select a From Account a where a.Role=false")
	Page<Account> findUser(Pageable page);

	@Query("Select a From Account a where a.Email = ?1")
	Account findByEmail(String email);

	Account findByResetPasswordToken(String token);

	@Query("SELECT t FROM Account t WHERE t.Email like %?1%")
	List<Account> AccountSearch(String keyword);
}
