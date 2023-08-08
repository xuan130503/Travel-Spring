package Travel_Foly.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Intimates")
public class Intimate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IntimateId;
	private String name;
	@OneToOne(mappedBy = "User", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User User;
}
