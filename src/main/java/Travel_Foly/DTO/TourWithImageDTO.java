package Travel_Foly.DTO;


import Travel_Foly.Model.Tour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourWithImageDTO {
	private Integer tourId;
	private String name;
	private Double priceAdult;
	private Double priceChildren;
	private String description;
	private Integer duration;
	private String avatar;
}
