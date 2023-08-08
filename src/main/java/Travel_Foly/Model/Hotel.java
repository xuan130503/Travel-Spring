package Travel_Foly.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Hotels")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer HotelId;
	@Column(columnDefinition = "nvarchar(100)")
	private String Name;
	private Double Price;
	private Boolean Available;
	@Column(columnDefinition = "nvarchar(500)")
	private String Description;
	@Column(columnDefinition = "nvarchar(200)")
	private String Address;
	private String Map;
	private Integer Start;
	private Integer Quantity;
	@ManyToOne @JoinColumn(name="CategoryHotelId")
	private CategoryHotel CategoryHotel;
	@ManyToOne @JoinColumn(name="CategoryRoomId")
	private CategoryRoom CategoryRoom;
	@OneToMany(mappedBy = "HotelImage")
	private List<HotelImage> HotelImages;
	@OneToMany(mappedBy = "HotelCommentId")
	private List<HotelComment> HotelComments;
	@OneToMany(mappedBy = "OrderDetailHotel")
	private List<OrderDetailHotel> OrderDetailHotels;
	
	//Cart
	@OneToMany(mappedBy = "HotelId")
	private List<CartItem> CartItems;
	
}
