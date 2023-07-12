package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Travel_Foly.Model.User;

public interface UserDAO extends JpaRepository<User,String>{

}
