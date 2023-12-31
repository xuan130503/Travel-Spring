package Travel_Foly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.DTO.InvoiceDTO;
import Travel_Foly.DTO.MonthlyRevenueDTO;
import Travel_Foly.DTO.orderHotelDTO;
import Travel_Foly.Model.OrderDetailHotel;

@Repository
public interface OrderDetailHotelDAO extends JpaRepository<OrderDetailHotel, Integer> {
    @Query("Select new Travel_Foly.DTO.orderHotelDTO("
            + "de.OrderDetailHotelId, de.OrderDetailHotel.Name, de.CheckIn,de.CheckOut,de.Quantity,de.Price,de.Status,de.BookDate,de.OrderHotel.Name, de.OrderHotel.Email, de.OrderHotel.Phone,de.total ) "
            + "from OrderDetailHotel de "
            + "Join OrderHotel o On o.OrderHotelId = de.OrderHotel.OrderHotelId "
            + "where de.OrderDetailHotelId = ?1")
    orderHotelDTO OrderdetailHotelInvoice(Integer orderDetailId);
    
    @Query("Select de From OrderDetailHotel de Where de.OrderDetailHotelId=?1")
    OrderDetailHotel findOneById(Integer id);
    
    @Query("SELECT NEW Travel_Foly.DTO.MonthlyRevenueDTO(YEAR(o.BookDate), MONTH(o.BookDate), " +
	        "SUM(o.total) ) " +
	        "FROM OrderDetailHotel o " +
	        "GROUP BY YEAR(o.BookDate), MONTH(o.BookDate) ")
	List<MonthlyRevenueDTO> getListYearlyRevenue();
    
    @Query("SELECT NEW Travel_Foly.DTO.MonthlyRevenueDTO(YEAR(o.BookDate), MONTH(o.BookDate), " +
	        "CAST(COUNT(o.Quantity) AS DOUBLE)) " +
	        "FROM OrderDetailHotel o " +
	        "GROUP BY YEAR(o.BookDate), MONTH(o.BookDate)")
	List<MonthlyRevenueDTO> getListQuantityOrderHotel();
    
    @Query("Select SUM(o.total) FROM OrderDetailHotel o")
	Double getRevenueOrderDetailHotel();
    
    @Query("Select count(de) From OrderDetailHotel de")
	Integer reportOrder();
    
    @Query("SELECT t.HotelId, t.Name, SUM(t.Quantity) AS TotalQuantity, t.Price, t.CategoryHotel.Name, t.CategoryRoom.Name "
			+ "FROM Hotel t "
			+ "JOIN OrderDetailHotel de ON t.HotelId = de.OrderDetailHotel.HotelId "
			+ "GROUP BY t.HotelId, t.Name, t.Price, t.CategoryHotel.Name, t.CategoryRoom.Name "
			+ "ORDER BY TotalQuantity DESC "
			+ "LIMIT 5")
	List<Object[]> getBestSellingHotel();
}
