package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.CategoryRoom;

@Repository
public interface CategoryRoomDAO extends JpaRepository<CategoryRoom,Integer>{
	
}
