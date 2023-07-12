package Travel_Foly.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Intimates")
public class Intimate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer IntimateId;
	String name;
	@OneToOne(mappedBy = "User")
	User User;
}
