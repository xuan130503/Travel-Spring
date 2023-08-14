package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.TourVariant;
@Repository
public interface TourVariantDAO extends JpaRepository<TourVariant,Integer>{
	@Query("Select tv from TourVariant tv Where tv.TourVariant.TourId = ?1")
	TourVariant findAllByTourId(Integer id);

}
