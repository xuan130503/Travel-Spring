package Travel_Foly.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TourComments")
public class TourComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer CommentId;
	@Column(columnDefinition = "nvarchar(500)")
	String Content;
	Integer Vote;
	@ManyToOne @JoinColumn(name="UserName")
	User TourCommentUser;
	@ManyToOne @JoinColumn(name="TourId")
	Tour TourCommentId;
}
