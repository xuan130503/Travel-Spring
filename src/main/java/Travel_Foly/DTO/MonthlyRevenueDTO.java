package Travel_Foly.DTO;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyRevenueDTO {
	private int year;
    private Map<Integer, Double> monthlyRevenues;
}
