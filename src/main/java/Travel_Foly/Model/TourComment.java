package Travel_Foly.Model;

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

@Entity
@Data
@Table(name="TourComments")
public class TourComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CommentId;
	@Column(columnDefinition = "nvarchar(500)")
	private String Content;
	private Integer Vote;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="AccountId")
	private Account TourCommentUser;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="TourId")
	private Tour TourCommentId;
}
