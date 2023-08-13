package Travel_Foly.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.DTO.TourWithImageDTO;
import Travel_Foly.Model.Tour;
@Repository
public interface TourDAO extends JpaRepository<Tour,Integer>{
	@Query("SELECT new Travel_Foly.DTO.TourWithImageDTO(t, img.Avatar, v.Duration) FROM Tour t "
			+ "JOIN TourImage img ON img.TourImage.TourId = t.TourId "
			+ "JOIN TourVariant v ON v.TourVariant.TourId = t.TourId ")
	Page<TourWithImageDTO> findAllTourWithImage(Pageable pageable);
	
	@Query("SELECT new Travel_Foly.DTO.TourWithImageDTO(t, img.Avatar, v.Duration) FROM Tour t "
			+ "JOIN TourImage img ON img.TourImage.TourId = t.TourId "
			+ "JOIN TourVariant v ON v.TourVariant.TourId = t.TourId "
			+ "Where t.Tour.CategoryTourId = ?1 ")
	Page<TourWithImageDTO> findByCategoryId(Integer id, Pageable pageable);
	
	@Query("Select t from Tour t Where t.TourId = ?1")
	Tour findByTourId(Integer id);
}
