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
@Table(name="CategoryRooms")
public class CategoryRoom{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CategoryRoomId;
	@Column(columnDefinition = "nvarchar(100)")
	private String Name;
	@OneToMany(mappedBy = "CategoryRoom")
	private List<Hotel> Hotels;
}
