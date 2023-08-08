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

@Data
@Entity
@Table(name="Tours")
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TourId;
	@Column(columnDefinition = "nvarchar(100)")
	private String Name;
	private Double Price;
	private Boolean Available;
	
	@Column(columnDefinition = "nvarchar(500)")
	private String Description;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="CategoryTourId")
	private CategoryTour Tour;
	
	@OneToMany(mappedBy = "TourSchedule")
	private List<TourSchedule> TourSchedules;
	
	@OneToMany(mappedBy = "TourImage")
	private List<TourImage> TourImages;
	
	@OneToMany(mappedBy = "TourVariant")
	private List<TourVariant> TourVariants;
	
	@OneToMany(mappedBy = "TourCommentId")
	private List<TourComment> TourComments;
	
	@OneToMany(mappedBy = "OrderDetailTour")
	private List<OrderDetailTour> OrderDetailTours;
	
	//Cart
	@OneToMany(mappedBy = "TourId")
	private List<CartItem> CartItem;
	
}
