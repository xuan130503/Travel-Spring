package Travel_Foly.DAO;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.OrderDetailTour;
@Repository
public interface OrderDetailTourDAO extends JpaRepository<OrderDetailTour,Integer>{
	@Query("Select de From OrderDetailTour de "
			+ "Join OrderTour o On o.OrderTourId = de.OrderTour.OrderTourId "
			+ "Join Tour t On t.TourId = de.OrderDetailTour.TourId "
			+ "Join Account a On a.UserId = o.OrderTour.UserId "
			+ "Where o.OrderTour.UserId =?1 "
			+ "And de.Status=1"
			)
	Page<OrderDetailTour> findOrderByUserId(Integer id,Pageable page);

	@Query("Select de From OrderDetailTour de Where de.OrderDetailTourId = ?1")
	OrderDetailTour findByOrderDetailTourId(Integer Id);
	
//	@Query("Select de From OrderDetailTour de "
//			+ "Join OrderTour o On o.OrderTourId = de.OrderTour.OrderTourId "
//			+ "Join Tour t On t.TourId = de.OrderDetailTour.TourId "
//			+ "Join Account a On a.UserId = o.OrderTour.UserId "
//			+ "Where o.OrderTour.UserId =?1 "
//			+ "And de.Status=true "
//			+ "And Lower(t.Name) Like Lower(Concat('%', ?2 ,'%')) "
//			+ "Or t.Price Between ?3 and ?4 ")
//	Page<OrderDetailTour> findOrderByUserIdAndKeyword(Integer id,String keyword,Double minPrice, Double maxPrice,Pageable page);
//	
//	//admin
	@Query("Select count(de) From OrderDetailTour de")
	Integer reportOrder();
	
	@Query("Select de From OrderDetailTour de "
			+ "Join OrderTour o On o.OrderTourId = de.OrderTour.OrderTourId ")
	Page<OrderDetailTour> findOrder(Pageable page);
//	
//	@Query("Select Sum(de.TotalPrice) From OrderDetailTour de Where de.Status=true")
//	Double findTotalIncome();
//	
//	@Query("Select count(*) From OrderDetailTour de Where de.Status=false")
//	Integer findOrderCancel();
}
