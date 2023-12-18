package Travel_Foly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.TourSchedule;
import Travel_Foly.Model.TourService;

@Repository
public interface TourScheduleDAO extends JpaRepository<TourSchedule, Integer> {
	@Query("Select t From TourSchedule t Where t.TourSchedule.TourId = ?1")
	List<TourSchedule> findByTourId(Integer id);

	@Query("SELECT t FROM TourSchedule t WHERE t.Title like %?1%")
	List<TourSchedule> TourScheduleSearch(String keyword);
}
