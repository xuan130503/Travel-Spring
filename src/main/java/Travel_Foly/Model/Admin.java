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
	Integer Admin;
	String Account;
	String PassWord;
	Boolean Role;
	Boolean Activated;
	String Image;
	@Column(columnDefinition = "nvarchar(100)")
	String FullName;
	String Email;
	@Column(columnDefinition = "nvarchar(200)")
	String Address;
	String Phone;
}
