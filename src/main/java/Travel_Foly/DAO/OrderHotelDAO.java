package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.OrderHotel;
@Repository
public interface OrderHotelDAO extends JpaRepository<OrderHotel,Integer>{

}
