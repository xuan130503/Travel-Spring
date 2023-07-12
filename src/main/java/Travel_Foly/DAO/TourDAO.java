package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Travel_Foly.Model.Tour;

public interface TourDAO extends JpaRepository<Tour,Integer>{
	
}
