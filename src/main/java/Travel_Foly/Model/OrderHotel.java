package Travel_Foly.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="OrderHotels")
public class OrderHotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer OrderHotelId;
	@ManyToOne @JoinColumn(name = "UserName")
	User OrderHotel;
	@ManyToOne @JoinColumn(name = "OrderDetailHotelId")
	OrderDetailHotel OrderDetailHotel;
}
