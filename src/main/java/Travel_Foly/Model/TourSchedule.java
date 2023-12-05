package Travel_Foly.Model;

import java.sql.Time;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "TourSchedules")
public class TourSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TourScheduleId;
	@Column(columnDefinition = "nvarchar(200)")

	@NotBlank(message = "Please enter your name")
	private String Title;
	@Column(columnDefinition = "nvarchar(500)")
	@NotBlank(message = "Please enter your Description")
	private String Description;
	@NotNull(message = "Please enter your Time")
	private LocalTime Time;
	@NotBlank(message = "Please enter your Date")
	private String Date;

	private String Image;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TourId")
	private Tour TourSchedule;
}
