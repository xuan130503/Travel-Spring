package Travel_Foly.DTO;

import Travel_Foly.Model.Tour;
import Travel_Foly.Model.TourVariant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourAndVariantDTO {
	private Tour tour;
	private TourVariant tourVariant;

}
