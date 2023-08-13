package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.HotelImage;
import Travel_Foly.Model.TourImage;
@Repository
public interface HotelImageDAO extends JpaRepository<HotelImage,Integer>{
	
}
