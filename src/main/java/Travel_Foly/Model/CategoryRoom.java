package Travel_Foly.Model;

import java.util.List;

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
	Integer CategoryRoomId;
	String Name;
	@OneToMany(mappedBy = "CategoryRoom")
	List<Hotel> Hotels;
}
