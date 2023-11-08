package Travel_Foly.API.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Travel_Foly.API.Service.TourService;
import Travel_Foly.DAO.TourDAO;
import Travel_Foly.Model.Tour;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourDAO tourDAO;

    @Override
    public List<Tour> getAllTours() {
        return this.tourDAO.findAll();
    }

    @Override
    public void saveTour(Tour tour) {
        this.tourDAO.save(tour);
    }

    @Override
    public Tour getTourById(Integer TourId) {
        return tourDAO.findById(TourId).orElse(null);

    }

    @Override
    public void deleteTour(Integer TourId) {
        this.tourDAO.deleteById(TourId);
    }

}
