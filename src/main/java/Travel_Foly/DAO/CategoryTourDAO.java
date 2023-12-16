package Travel_Foly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.CategoryTour;
@Repository
public interface CategoryTourDAO extends JpaRepository<CategoryTour,Integer>{
	@Query("SELECT c.CategoryTourId, c.Name, c.Avatar, COUNT(t.TourId) AS quantity " +
		       "FROM CategoryTour c " +
		       "JOIN Tour t ON t.Tour.CategoryTourId = c.CategoryTourId " +
		       "GROUP BY c.CategoryTourId, c.Name, c.Avatar " +
		       "ORDER BY quantity DESC")
		List<Object[]> findAllCategory();
}
