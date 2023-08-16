package Travel_Foly.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Carts")
public class Cart {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CartId;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String Name;
	private String Phone;
	private String Email;
	@Column(columnDefinition = "nvarchar(200)")
	private String Address;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Account Cart;
	
	@OneToMany(mappedBy = "CartItem")
	private List<CartItem> CartItems;
}
