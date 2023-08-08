package Travel_Foly.Model;

import java.sql.Date;
import java.util.List;

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

@Entity
@Data
@Table(name="OrderDetailTours")
public class OrderDetailTour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer OrderDetailTourId;
	private Integer Quantity;
	private Double Price;
	private Date Date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TourId")
	private Tour OrderDetailTour;
	@OneToMany(mappedBy = "OrderDetailTour")
	private List<OrderTour> OrderTours;
}
