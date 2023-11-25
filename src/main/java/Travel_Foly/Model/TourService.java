package Travel_Foly.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TourServices")
public class TourService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TourServiceId;

	@Column(columnDefinition = "nvarchar(100)")
	private String Name;

	@Column(columnDefinition = "nvarchar(200)")
	private String Description;

	private Double Surcharge;

	@ManyToOne
	@JoinColumn(name = "TourId")
	private Tour TourService;
}
