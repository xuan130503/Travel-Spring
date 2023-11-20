package Travel_Foly.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "Tours")
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TourId;
	@Column(columnDefinition = "nvarchar(100)")
	@NotBlank(message = "tên Chuyến du lịch không được để trống")
	private String Name;

	@NotNull(message = "Trạng thái du lịch ko được để trống")
	private Boolean Available;
	@Column(columnDefinition = "nvarchar(500)")
	@NotBlank(message = "Hãy nhập Mô tả cho chuyên du lịch")
	private String Description;

	@Column(columnDefinition = "nvarchar(100)")
	@NotBlank(message = "Vui lòng nhập địa điển đi ")
	private String Departure;

	@Column(columnDefinition = "nvarchar(100)")
	@NotBlank(message = "vui lòng nhập địa điểm đến")
	private String Destination;

	@NotNull(message = "Vui lòng nhập nhập số tiến chuyến du lịch của người lớn")
	private Double PriceAdult;

	@NotNull(message = "Vui lòng nhập số tiền chuyến du lịch của trẻ nhỏ")
	private Double PriceChildren;

	@NotNull(message = "Vui lòng nhập số lượng người lớn")
	private Integer QuantityAdult;
	@NotNull(message = "Vui lòng nhập số lượng trẻ nhỏ")
	private Integer QuantityChildren;

	private String Map;
	@Column(columnDefinition = "nvarchar(500)")
	@NotBlank(message = "Vui lòng giới thiệu về chuyến du lịch")
	private String Introduction;
	@NotNull(message = "vui lòng nhâp thời gian của chuyến đi thăm quan du lịch")
	private Integer Duration;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CategoryTourId")
	private CategoryTour Tour;

	@OneToMany(mappedBy = "TourSchedule")
	private List<TourSchedule> TourSchedules;

	@OneToMany(mappedBy = "TourImage")
	private List<TourImage> TourImages;

	@OneToMany(mappedBy = "TourService")
	private List<TourService> TourServices;

	@OneToMany(mappedBy = "TourCommentId")
	private List<TourComment> TourComments;

	@OneToMany(mappedBy = "OrderDetailTour")
	private List<OrderDetailTour> OrderDetailTours;

	// Cart
	@OneToMany(mappedBy = "TourId")
	private List<CartItem> CartItem;

}
