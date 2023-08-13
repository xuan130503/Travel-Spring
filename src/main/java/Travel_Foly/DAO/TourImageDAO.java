package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.TourImage;
@Repository
public interface TourImageDAO extends JpaRepository<TourImage, Integer>{
	@Query("Select img from TourImage img Where img.TourImage.TourId = ?1")
	TourImage findByTourId(Integer id);
}
