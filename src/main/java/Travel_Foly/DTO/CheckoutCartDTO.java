package Travel_Foly.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutCartDTO {
	private String fullname;
    private String phone;
    private String address;
    private String email;
    private String payment;
    private List<Integer> selectedItems;
}
