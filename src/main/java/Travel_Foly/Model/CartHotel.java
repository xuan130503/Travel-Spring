package Travel_Foly.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CartHotels")
public class CartHotel {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CartHotelId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CartId")
	private Cart CartHotel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="HotelId")
	private Hotel HotelId;
	
	private Integer Quantity;
	private Date CheckIn;
	private Date CheckOut;
}
