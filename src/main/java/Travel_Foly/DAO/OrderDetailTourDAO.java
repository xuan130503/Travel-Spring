package Travel_Foly.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.DTO.InvoiceDTO;
import Travel_Foly.DTO.MonthlyRevenueDTO;
import Travel_Foly.Model.OrderDetailTour;

@Repository
public interface OrderDetailTourDAO extends JpaRepository<OrderDetailTour, Integer> {
	@Query("SELECT de FROM OrderDetailTour de "
			+ "WHERE de.UserOrder.UserId = ?1 AND de.Available = true")
	Page<OrderDetailTour> findOrderByUserId(Integer userId, Pageable page);

	@Query("Select de From OrderDetailTour de Where de.OrderDetailTourId = ?1")
	OrderDetailTour findByOrderDetailTourId(Integer Id);

	// @Query("Select de From OrderDetailTour de "
	// + "Join OrderTour o On o.OrderTourId = de.OrderTour.OrderTourId "
	// + "Join Tour t On t.TourId = de.OrderDetailTour.TourId "
	// + "Join Account a On a.UserId = o.OrderTour.UserId "
	// + "Where o.OrderTour.UserId =?1 "
	// + "And de.Status=true "
	// + "And Lower(t.Name) Like Lower(Concat('%', ?2 ,'%')) "
	// + "Or t.Price Between ?3 and ?4 ")
	// Page<OrderDetailTour> findOrderByUserIdAndKeyword(Integer id,String
	// keyword,Double minPrice, Double maxPrice,Pageable page);
	//
	// //admin
	@Query("Select count(de) From OrderDetailTour de")
	Integer reportOrder();

	@Query("Select de From OrderDetailTour de "
			+ "Join OrderTour o On o.OrderTourId = de.OrderTour.OrderTourId ")
	Page<OrderDetailTour> findOrder(Pageable page);
	//
	// @Query("Select Sum(de.TotalPrice) From OrderDetailTour de Where
	// de.Status=true")
	// Double findTotalIncome();
	//
	// @Query("Select count(*) From OrderDetailTour de Where de.Status=false")
	// Integer findOrderCancel();

	@Query("Select new Travel_Foly.DTO.InvoiceDTO("
			+ "de.OrderDetailTourId, de.OrderTour.Name, de.OrderTour.Email, de.OrderTour.Phone, t.Name, t.Departure, t.Destination, t.Duration, de.PriceAdult, de.PriceChildren, de.QuantityAdult, de.QuantityChildren, de.Total, de.StarDate, de.EndDate, de.Base64, de.Status) "
			+ "from OrderDetailTour de "
			+ "Join Tour t On t.TourId = de.OrderDetailTour.TourId "
			+ "Join OrderTour o On o.OrderTourId = de.OrderTour.OrderTourId "
			+ "where de.OrderDetailTourId = ?1")
	InvoiceDTO detailInvoice(Integer orderDetailId);

	@Query("Select new Travel_Foly.DTO.InvoiceDTO("
			+ "de.OrderDetailTourId, de.OrderTour.Name, de.OrderTour.Email, de.OrderTour.Phone, t.Name, t.Departure, t.Destination, t.Duration, de.PriceAdult, de.PriceChildren, de.QuantityAdult, de.QuantityChildren, de.Total, de.StarDate, de.EndDate, de.Base64, de.Status) "
			+ "from OrderDetailTour de "
			+ "Join Tour t On t.TourId = de.OrderDetailTour.TourId "
			+ "Join OrderTour o On o.OrderTourId = de.OrderTour.OrderTourId ")
	Page<InvoiceDTO> findAlldetailInvoice(Pageable page);

	@Query("Select new Travel_Foly.DTO.InvoiceDTO("
			+ "de.OrderDetailTourId, de.OrderTour.Name, de.OrderTour.Email, de.OrderTour.Phone, t.Name, t.Departure, t.Destination, t.Duration, de.PriceAdult, de.PriceChildren, de.QuantityAdult, de.QuantityChildren, de.Total, de.StarDate, de.EndDate, de.Base64, de.Status) "
			+ "from OrderDetailTour de "
			+ "Join Tour t On t.TourId = de.OrderDetailTour.TourId "
			+ "Join OrderTour o On o.OrderTourId = de.OrderTour.OrderTourId "
			+ "Where de.OrderDetailTourId =?1 "
			+ "Or Lower(t.Name) Like Lower(Concat('%', ?2 ,'%')) "
			+ "Or Lower(de.OrderTour.Name) Like Lower(Concat('%', ?3 ,'%')) ")
	Page<InvoiceDTO> searchInvoice(Pageable page, Integer tourId, String tourName, String userName);

	@Query("Select count(o) from OrderDetailTour o")
	Integer getAllOrderDetailTours();

	@Query("Select SUM(o.Total) FROM OrderDetailTour o "
			+ "WHERE YEAR(o.BookDate) = ?1 "
			+ "Or MONTH(o.BookDate) = ?2  "
			+ "Or MONTH(o.BookDate) BETWEEN ?3 and ?4 ")
	Double getRevenueOrderDetailTour(Integer year, Integer month, Integer startMonth, Integer endMonth);
	
	@Query("SELECT NEW Travel_Foly.DTO.MonthlyRevenueDTO(YEAR(o.BookDate), MONTH(o.BookDate), " +
	        "SUM(o.Total)) " +
	        "FROM OrderDetailTour o " +
	        "GROUP BY YEAR(o.BookDate), MONTH(o.BookDate)")
	List<MonthlyRevenueDTO> getListYearlyRevenue();
	@Query("SELECT NEW Travel_Foly.DTO.MonthlyRevenueDTO(YEAR(o.BookDate), MONTH(o.BookDate), " +
	        "CAST(COUNT(o.QuantityAdult+o.QuantityChildren) AS DOUBLE)) " +
	        "FROM OrderDetailTour o " +
	        "GROUP BY YEAR(o.BookDate), MONTH(o.BookDate)")
	List<MonthlyRevenueDTO> getListQuantityOrderTour();
}
