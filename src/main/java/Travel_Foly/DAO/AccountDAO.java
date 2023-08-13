package Travel_Foly.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import Travel_Foly.DTO.AccountDTO;
import Travel_Foly.Model.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account,String>{
	@Query("Select a from Account a")
	List<Account> findAllUser();
	
	@Query("Select a From Account a Where a.UserName=?1")
	Optional<Account> findByUsername(String Username);
	
	@Query("Select new Travel_Foly.DTO.AccountDTO(a.UserId, a.UserName, a.Role)  From Account a Where a.UserName=?1")
	AccountDTO findOneUsername(String Username);
}
