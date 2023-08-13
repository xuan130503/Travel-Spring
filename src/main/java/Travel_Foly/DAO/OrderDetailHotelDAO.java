package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.OrderDetailHotel;
@Repository
public interface OrderDetailHotelDAO extends JpaRepository<OrderDetailHotel,Integer>{

}
