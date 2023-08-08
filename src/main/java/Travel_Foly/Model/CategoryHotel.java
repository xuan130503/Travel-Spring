package Travel_Foly.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CategoryHotels")
public class CategoryHotel{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CategoryHotelId;
	@Column(columnDefinition = "nvarchar(100)")
	private String Name;
	@OneToMany(mappedBy = "CategoryHotel")
	private List<Hotel> Hotels;
}
