package Travel_Foly.Model;

import java.util.Date;
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
	private Integer QuantityChildren;
	private Double Price;
	private Date StarDate;
	private Date EndDate;
	private Date BookDate;
	private Boolean Status;
	private Double TotalPrice;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TourId")
	private Tour OrderDetailTour;
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "OrderTourId")
	private OrderTour OrderTour;
}
