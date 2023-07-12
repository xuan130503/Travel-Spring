package Travel_Foly.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	Integer TourVariantId;
	@Column(columnDefinition = "nvarchar(100)")
	String Departure;
	@Column(columnDefinition = "nvarchar(100)")
	String Destination;
	Integer Quantity;
	Date date;
	String map;
	@Column(columnDefinition = "nvarchar(500)")
	String Introduction;
	@ManyToOne @JoinColumn(name="TourId")
	Tour TourVariant;
}
