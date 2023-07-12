package Travel_Foly.Model;


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
@Table(name="HotelImages")
public class HotelImage{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer HotelImageId;
	String Avatar;
	String Image1;
	String Image2;
	String Image3;
	String Image4;
	String Image5;
	String Image6;
	String Image7;
	String Image8;
	String Image9;
	String Image10;
	@ManyToOne @JoinColumn(name="HotelId")
	Hotel HotelImage;
}
