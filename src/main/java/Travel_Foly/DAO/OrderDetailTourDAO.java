package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.OrderDetailTour;
@Repository
public interface OrderDetailTourDAO extends JpaRepository<OrderDetailTour,Integer>{

}
