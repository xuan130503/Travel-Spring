package Travel_Foly.Model;

import java.sql.Time;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	Integer TourScheduleId;
	@Column(columnDefinition = "nvarchar(200)")
	String Title;
	@Column(columnDefinition = "nvarchar(500)")
	String Description;
	Date Date;
	Time Time;
	@ManyToOne @JoinColumn(name="TourId")
	Tour TourSchedule;
}
