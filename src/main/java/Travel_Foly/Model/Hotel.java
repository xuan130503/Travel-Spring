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
	Integer HotelId;
	@Column(columnDefinition = "nvarchar(100)")
	String Name;
	Double Price;
	Boolean Available;
	@Column(columnDefinition = "nvarchar(500)")
	String Description;
	String Address;
	String Map;
	Integer Start;
	Integer Quantity;
	@ManyToOne @JoinColumn(name="CategoryHotelId")
	CategoryHotel CategoryHotel;
	@ManyToOne @JoinColumn(name="CategoryRoomId")
	CategoryRoom CategoryRoom;
	@OneToMany(mappedBy = "HotelImage")
	List<HotelImage> HotelImages;
	@OneToMany(mappedBy = "HotelCommentId")
	List<HotelComment> HotelComments;
	@OneToMany(mappedBy = "OrderDetailHotel")
	List<OrderDetailHotel> OrderDetailHotels;
	
}
