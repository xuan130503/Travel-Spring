package Travel_Foly.DTO;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class AccountDTO {
	private Integer UserId;
	private String UserName;
	private Boolean Role;
	
}
