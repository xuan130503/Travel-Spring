package Travel_Foly.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="OrderTours")
public class OrderTour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer OrderTourId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AccountId")
	private Account OrderTour;
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "OrderDetailTourId")
	private OrderDetailTour OrderDetailTour;
	@Column(columnDefinition = "nvarchar(50)")
	private String Name;
	private String Email;
	private String Address;
	private String Phone;
}
