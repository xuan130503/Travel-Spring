package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.DTO.InvoiceDTO;
import Travel_Foly.DTO.orderHotelDTO;
import Travel_Foly.Model.OrderDetailHotel;

@Repository
public interface OrderDetailHotelDAO extends JpaRepository<OrderDetailHotel, Integer> {
    @Query("Select new Travel_Foly.DTO.orderHotelDTO("
            + "de.OrderDetailHotelId, de.CheckIn,de.CheckOut,de.Quantity,de.Price,de.Status,de.BookDate,de.OrderHotel.Name, de.OrderHotel.Email, de.OrderHotel.Phone ) "
            + "from OrderDetailHotel de "
            + "Join OrderHotel o On o.OrderHotelId = de.OrderHotel.OrderHotelId "
            + "where de.OrderDetailHotelId = ?1")
    orderHotelDTO OrderdetailHotelInvoice(Integer orderDetailId);

}
