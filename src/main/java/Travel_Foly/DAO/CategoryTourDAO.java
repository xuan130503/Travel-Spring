package Travel_Foly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.CategoryTour;
@Repository
public interface CategoryTourDAO extends JpaRepository<CategoryTour,Integer>{
	@Query("Select c.CategoryTourId, c.Name, img.Avatar, count(t.TourId) From CategoryTour c "
			+ "Join Tour t On t.Tour.CategoryTourId = c.CategoryTourId "
			+ "Join TourImage img On img.TourImage.TourId = t.TourId "
			+ "Group By c.CategoryTourId, c.Name, img.Avatar "
			+ "Order By Rand()"
			)
	List<Object[]> findAllCategory();
}
