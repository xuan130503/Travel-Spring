package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.CategoryHotel;
@Repository
public interface CategoryHotelDAO extends JpaRepository<CategoryHotel,Integer>{

}
