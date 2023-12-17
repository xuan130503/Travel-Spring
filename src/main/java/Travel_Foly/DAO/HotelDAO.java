package Travel_Foly.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.DTO.HotelDTO;
import Travel_Foly.Model.Hotel;

@Repository
public interface HotelDAO extends JpaRepository<Hotel, Integer> {
	@Query("Select new Travel_Foly.DTO.HotelDTO(h.HotelId, h.Name, h.Price, h.Description, img.Avatar) from Hotel h "
			+ "Join HotelImage img On img.HotelImage.HotelId = h.HotelId")
	Page<HotelDTO> findAllHotelWithImage(Pageable page);

	@Query("SELECT c FROM Hotel c WHERE c.Name like %?1%")
	List<Hotel> searchHotels(String keyword);
	
	@Query("Select count(h) From Hotel h")
	Integer reportHotel();
	
	@Query("Select count(h) From Hotel h "
			+ "Where h.Quantity <= ?1 ")
	Integer reportTourQuantity(Integer quantity);
}
