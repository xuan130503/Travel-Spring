package Travel_Foly.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Admins")
public class Admin {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Admin;
	private String Account;
	private String PassWord;
	private Boolean Role;
	private Boolean Activated;
	private String Image;
	@Column(columnDefinition = "nvarchar(100)")
	private String FullName;
	private String Email;
	@Column(columnDefinition = "nvarchar(200)")
	private String Address;
	private String Phone;
}
