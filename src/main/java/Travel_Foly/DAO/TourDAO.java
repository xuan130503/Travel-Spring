package Travel_Foly.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.DTO.TourWithImageDTO;
import Travel_Foly.Model.Tour;
@Repository
public interface TourDAO extends JpaRepository<Tour,Integer>{
	
	@Query("SELECT new Travel_Foly.DTO.TourWithImageDTO(t.TourId, t.Name, t.PriceAdult, t.PriceChildren, t.Description, t.Duration, img.Avatar) FROM Tour t "
			+ "JOIN TourImage img ON img.TourImage.TourId = t.TourId ")
	Page<TourWithImageDTO> findAllTourWithImage(Pageable pageable);
	
	@Query("SELECT new Travel_Foly.DTO.TourWithImageDTO(t.TourId, t.Name, t.PriceAdult, t.PriceChildren, t.Description, t.Duration, img.Avatar) FROM Tour t "
			+ "JOIN TourImage img ON img.TourImage.TourId = t.TourId "
			+ "Where t.Tour.CategoryTourId = ?1 ")
	Page<TourWithImageDTO> findByCategoryId(Integer id, Pageable pageable);
	
	@Query("Select t from Tour t Where t.TourId = ?1")
	Tour findByTourId(Integer id);
//	
//	@Query("Select t.Price from Tour t Where t.TourId = ?1")
//	Double findPriceByTourId(Integer id);
//	
//	@Query("Select new Travel_Foly.DTO.TourWithImageDTO(t, img.Avatar, v.Duration) From Tour t "
//			+ "JOIN TourImage img ON img.TourImage.TourId = t.TourId "
//			+ "JOIN TourVariant v ON v.TourVariant.TourId = t.TourId "
//			+ "Where Lower(t.Name) Like Lower(Concat('%', ?1 ,'%')) "
//			+ "Or Lower(t.Tour.Name) Like Lower(Concat('%', ?1 ,'%')) "
//			+ "Or Lower(t.Description) Like Lower(Concat('%', ?1 ,'%')) "
//			+ "Or t.Price Between ?2 and ?3 "
//			)
//	Page<TourWithImageDTO> searchByKeyWord(String keyword, Double minPrice, Double maxPrice, Pageable pageable);
//	
//	@Query("Select count(t) From Tour t")
//	Integer reportTour();
//	
//	@Query("Select count(t) From Tour t "
//			+ "Join TourVariant tv On tv.TourVariant.TourId=t.TourId "
//			+ "Where tv.Quantity <= ?1 Or tv.QuantityChildren <= ?1")
//	Integer reportTourQuantity(Integer quantity);
//	
//	@Query("Select t From Tour t")
//	Page<Tour> findAllTour(Pageable page);
//	
//	 @Query("SELECT t, SUM(odt.Quantity) AS totalQuantity FROM Tour t JOIN t.OrderDetailTours odt GROUP BY t ORDER BY totalQuantity DESC")
//	 List<Object[]> findBestSellingTours();
//	
//	@Query("Select new Travel_Foly.DTO.TourAndVariantDTO(t,tv) Tour t "
//			+ "Join TourVariant tv On tv.TourVariant.TourId=t.TourId")
//	Page<TourAndVariantDTO> findAllTourAndVariant(Pageable page);
	
}
