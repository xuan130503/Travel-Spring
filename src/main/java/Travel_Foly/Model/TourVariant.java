package Travel_Foly.Model;

import java.sql.Date;

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
@Table(name="TourVariants")
public class TourVariant{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TourVariantId;
	@Column(columnDefinition = "nvarchar(100)")
	private String Departure;
	@Column(columnDefinition = "nvarchar(100)")
	private String Destination;
	private Integer Quantity;
	private Integer QuantityChildren;
	private Date date;
	private String map;
	@Column(columnDefinition = "nvarchar(500)")
	private String Introduction;
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="TourId")
	private Tour TourVariant;
	
	private Integer Duration;
}
