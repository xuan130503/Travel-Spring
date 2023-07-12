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
@Table(name="Tours")
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer TourId;
	@Column(columnDefinition = "nvarchar(100)")
	String Name;
	Double Price;
	Boolean Available;
	String Description;
	@ManyToOne @JoinColumn(name="CategoryTourId")
	CategoryTour Tour;
	@OneToMany(mappedBy = "TourSchedule")
	List<TourSchedule> TourSchedules;
	@OneToMany(mappedBy = "TourImage")
	List<TourImage> TourImages;
	@OneToMany(mappedBy = "TourVariant")
	List<TourVariant> TourVariants;
	@OneToMany(mappedBy = "TourCommentId")
	List<TourComment> TourComments;
	@OneToMany(mappedBy = "OrderDetailTour")
	List<OrderDetailTour> OrderDetailTours;
	
}
