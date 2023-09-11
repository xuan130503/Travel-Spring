package Travel_Foly.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Intimates")
public class Intimate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IntimateId;
	private String Name;
	@OneToMany(mappedBy = "Account")
	private List<Account> Accounts;
}
