package Travel_Foly.Model;

import java.sql.Time;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TourSchedules")
public class TourSchedule{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TourScheduleId;
	@Column(columnDefinition = "nvarchar(200)")
	private String Title;
	@Column(columnDefinition = "nvarchar(500)")
	private String Description;
	private Date Date;
	private Time Time;
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="TourId")
	private Tour TourSchedule;
}
