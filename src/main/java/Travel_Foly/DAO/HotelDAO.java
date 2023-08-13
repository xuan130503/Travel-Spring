package Travel_Foly.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.DTO.HotelDTO;
import Travel_Foly.Model.Hotel;
@Repository
public interface HotelDAO extends JpaRepository<Hotel,Integer>{
	@Query("Select new Travel_Foly.DTO.HotelDTO(t,img.Avatar) from Hotel t "
			+ "Join HotelImage img On img.HotelImage.HotelId = t.HotelId")
	Page<HotelDTO> findAllHotelWithImage(Pageable page);
}
