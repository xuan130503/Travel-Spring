package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.HotelComment;
@Repository
public interface HotelCommentDAO extends JpaRepository<HotelComment,Integer>{

}
