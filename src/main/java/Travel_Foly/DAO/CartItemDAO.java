package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.DTO.CartItemDTO;
import Travel_Foly.Model.CartItem;
import java.util.List;


@Repository
public interface CartItemDAO  extends JpaRepository<CartItem, Integer>{
	@Query("Select count(ci) From CartItem ci "
			+ "Join Cart c On c.CartId = ci.CartItem.CartId "
			+ "Where c.Cart.UserId = ?1")
	Integer getAmount(Integer id);
	
	@Query("Select c From CartItem c Where c.CartItemId = ?1")
	CartItem findOneCartItemId(Integer id);
	
	@Query("Select ci From CartItem ci Where ci.CartItem.CartId=?1")
	List<CartItem> findByCartId(Integer cartId);
	
	@Query("Select new Travel_Foly.DTO.CartItemDTO(t) From CartItem ci "
			+ "Join Tour t On t.TourId = ci.TourId.TourId"
			+ " Where ci.CartItem.CartId=?1")
	List<CartItemDTO> findCartItemDTOById(Integer cartId);
	
	
	@Query("Select sum(ci.QuantityChildren * ci.TourId.PriceChildren + ci.QuantityAdult * ci.TourId.PriceAdult)  From CartItem ci "
			+ "Join Cart c On c.CartId = ci.CartItem.CartId "
			+ "Join Account a On a.UserId = c.Cart.UserId "
			+ "Where c.Cart.UserId = ?1")
	Double getTotal(Integer UserId);
}
