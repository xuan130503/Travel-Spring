package Travel_Foly.Model;


import java.sql.Date;

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
@Table(name="CartItems")
public class CartItem {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CartItemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CartId")
	private Cart CartItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="HotelId")
	private Hotel HotelId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TourId")
	private Tour TourId;
	
	private Integer QuantityChildren;
	private Integer QuantityAdult;
	private Date StartDate;
	private Date EndDate;
}
