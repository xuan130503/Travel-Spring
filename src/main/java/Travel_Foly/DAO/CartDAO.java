package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer>{
	@Query("Select c From Cart c Where c.Cart.UserId = ?1")
	Cart findByUserId(Integer id);
}
