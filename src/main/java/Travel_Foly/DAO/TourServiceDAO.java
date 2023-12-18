package Travel_Foly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Travel_Foly.Model.TourService;

public interface TourServiceDAO extends JpaRepository<TourService, Integer> {
    @Query("SELECT t FROM TourService t WHERE t.Name like %?1%")
    List<TourService> searchTourSearch(String keyword);
}
