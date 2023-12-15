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
            + "de.OrderDetailHotelId, de.CheckIn,de.CheckOut,de.Quantity,de.Price,de.Status,de.BookDate,de.OrderHotel.Name, de.OrderHotel.Email, de.OrderHotel.Phone,de.total ) "
            + "from OrderDetailHotel de "
            + "Join OrderHotel o On o.OrderHotelId = de.OrderHotel.OrderHotelId "
            + "where de.OrderDetailHotelId = ?1")
    orderHotelDTO OrderdetailHotelInvoice(Integer orderDetailId);
    
    @Query("SELECT NEW Travel_Foly.DTO.MonthlyRevenueDTO(YEAR(o.BookDate), MONTH(o.BookDate), " +
	        "SUM(o.Price * o.Quantity) ) " +
	        "FROM OrderDetailHotel o " +
	        "GROUP BY YEAR(o.BookDate), MONTH(o.BookDate) ")
	List<MonthlyRevenueDTO> getListYearlyRevenue();
}
