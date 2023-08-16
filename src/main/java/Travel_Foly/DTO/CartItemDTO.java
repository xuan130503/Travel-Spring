package Travel_Foly.DTO;

import Travel_Foly.Model.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
	private CartItem cartItem;
	private Integer quantityTotalAdult;
	private Integer quantityTotalChildren;
}
