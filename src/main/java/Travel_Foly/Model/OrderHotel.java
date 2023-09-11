package Travel_Foly.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="OrderHotels")
public class OrderHotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer OrderHotelId;
	@Column(columnDefinition = "nvarchar(50)")
	private String Name;
	private String Email;
	@Column(columnDefinition = "nvarchar(200)")
	private String Address;
	private String Phone;
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "AccountId")
	private Account OrderHotel;
	
	@OneToMany(mappedBy = "OrderHotel")
	private List<OrderDetailHotel> OrderDetailHotels;
}
