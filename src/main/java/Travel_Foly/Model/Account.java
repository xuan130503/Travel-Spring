package Travel_Foly.Model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Accounts")

public class Account implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer UserId;
	@Column(unique = true)
	private String UserName;
	private String PassWord;
	private Boolean Role;
	private Boolean Activated;
	private String Image;
	private Integer Age;
	@Column(columnDefinition = "nvarchar(100)")
	private String FullName;
	private String Email;
	@Column(columnDefinition = "nvarchar(200)")
	private String Address;
	private String Phone;
	private String resetPasswordToken;

	@ManyToOne
	@JoinColumn(name = "IntimateId")
	private Intimate Account;

	@OneToMany(mappedBy = "TourCommentUser")
	private List<TourComment> TourComments;

	@OneToMany(mappedBy = "HotelCommentUser")
	private List<HotelComment> HotelComments;

	@OneToMany(mappedBy = "UserOrder")
	private List<OrderDetailTour> OrderDetailTours;

	@OneToMany(mappedBy = "OrderHotel")
	private List<OrderHotel> OrderHotels;

	// One to One Cart
	@OneToOne(mappedBy = "Cart", cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private Cart cart;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrant = new SimpleGrantedAuthority(this.Role ? "ROLE_ADMIN" : "ROLE_USER");

		return Arrays.asList(simpleGrant);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.PassWord;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.UserName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
