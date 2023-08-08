package Travel_Foly.Model;


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
@Table(name="TourImages")
public class TourImage{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TourImageId;
	private String Avatar;
	private String Image1;
	private String Image2;
	private String Image3;
	private String Image4;
	private String Image5;
	private String Image6;
	private String Image7;
	private String Image8;
	private String Image9;
	private String Image10;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TourId")
	private Tour TourImage;
}
