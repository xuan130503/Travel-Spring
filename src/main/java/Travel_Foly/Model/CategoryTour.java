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
@Table(name="CategoryTours")
public class CategoryTour{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CategoryTourId;
	@Column(columnDefinition = "nvarchar(100)")
	private String Name;
	private String Avatar;
	@OneToMany(mappedBy = "Tour")
	private List<Tour> Tours;
}
