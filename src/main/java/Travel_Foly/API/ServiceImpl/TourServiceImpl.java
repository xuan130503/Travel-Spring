package Travel_Foly.API.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import Travel_Foly.API.Service.TourService;
import Travel_Foly.DAO.TourDAO;
import Travel_Foly.Model.Tour;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourDAO tourDAO;

    @Override
    public List<Tour> getAllTour() {
        return tourDAO.findAll();
    }

    @Override
    public Tour getTourById(Integer TourId) {
        return tourDAO.findById(TourId).orElse(null);
    }

    @Override
    public void addTour(Tour tour) {
        tourDAO.save(tour);
    }

    @Override
    public void deleteTour(Integer TourId) {
        tourDAO.deleteById(TourId);
    }

    @Override
    public Page<Tour> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 3);
        return this.tourDAO.findAll(pageable);
    }

}
