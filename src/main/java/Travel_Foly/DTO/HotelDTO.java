package Travel_Foly.DTO;

import Travel_Foly.Model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
	private Integer hotelId;
	private String name;
	private Double price;
	private String description;
	private String avatar;

}
