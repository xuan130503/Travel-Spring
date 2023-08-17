package Travel_Foly.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Travel_Foly.DAO.TourDAO;
import Travel_Foly.Model.Tour;
@Service
public class TourService {
	 	@Autowired
	    private TourDAO tourDao;
	
	    public List<Tour> getBestSellingTours() {
	        List<Object[]> result = tourDao.findBestSellingTours();
	        
	        List<Tour> bestSellingTours = new ArrayList<>();
	        
	        for (Object[] obj : result) {
	            Tour tour = (Tour) obj[0];
	            bestSellingTours.add(tour);
	        }
	        
	        return bestSellingTours;
	    }

}
