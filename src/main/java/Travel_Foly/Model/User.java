package Travel_Foly.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Users")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer UserId;
	private String UserName;
	private String PassWord;
	private Boolean Role;
	private Boolean Activated;
	private String Image;
	private Integer Age;
	@Column(columnDefinition = "nvarchar(100)")
	private String FullName;
	private String Email;
	@Column(columnDefinition = "nvarchar(200)")
	private String Address;
	private String Phone;
	
	@OneToOne @JoinColumn(name="IntimateId")
	private Intimate User;
	
	@OneToMany(mappedBy = "TourCommentUser")
	private List<TourComment> TourComments;
	
	@OneToMany(mappedBy = "HotelCommentUser")
	private List<HotelComment> HotelComments;
	
	@OneToMany(mappedBy = "OrderTour")
	private List<OrderTour> OrderTours;
	
	//One to One Cart
	@OneToOne(mappedBy = "Cart", cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private Cart cart;
}
