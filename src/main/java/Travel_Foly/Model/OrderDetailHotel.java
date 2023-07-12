package Travel_Foly.Model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="OrderDetailHotels")
public class OrderDetailHotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer OrderDetailHotelId;
	Date CheckInDate;
	Date CheckOutDate;
	Integer Quantity;
	Double Price;
	Date Date;
	@ManyToOne @JoinColumn(name = "HotelId")
	Hotel OrderDetailHotel;
	@OneToMany(mappedBy = "OrderDetailHotel")
	List<OrderHotel> OrderHotels;
}
