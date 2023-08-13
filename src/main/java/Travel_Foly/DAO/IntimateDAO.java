package Travel_Foly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Travel_Foly.Model.Intimate;
@Repository
public interface IntimateDAO extends JpaRepository<Intimate,Integer>{

}
