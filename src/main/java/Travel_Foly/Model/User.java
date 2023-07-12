package Travel_Foly.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Users")
public class User {
	@Id
	String UserName;
	String PassWord;
	Boolean Role;
	Boolean Activated;
	String Image;
	Integer Age;
	@Column(columnDefinition = "nvarchar(100)")
	String FullName;
	String Email;
	@Column(columnDefinition = "nvarchar(200)")
	String Address;
	String Phone;
	@OneToOne @JoinColumn(name="IntimateId")
	Intimate User;
	@OneToMany(mappedBy = "TourCommentUser")
	List<TourComment> TourComments;
	@OneToMany(mappedBy = "HotelCommentUser")
	List<HotelComment> HotelComments;
	@OneToMany(mappedBy = "OrderTour")
	List<OrderTour> OrderTours;
}
