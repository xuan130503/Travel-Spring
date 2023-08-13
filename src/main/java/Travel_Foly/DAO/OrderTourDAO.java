package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.OrderTour;
@Repository
public interface OrderTourDAO extends JpaRepository<OrderTour,Integer>{

}
