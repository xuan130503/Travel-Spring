package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.TourComment;
@Repository
public interface TourCommentDAO extends JpaRepository<TourComment,Integer>{

}
