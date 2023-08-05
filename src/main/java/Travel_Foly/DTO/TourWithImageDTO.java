package Travel_Foly.DTO;

import Travel_Foly.Model.Tour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourWithImageDTO {
	private Tour Tour;
	private String Image;
}
