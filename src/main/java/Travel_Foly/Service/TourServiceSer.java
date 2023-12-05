package Travel_Foly.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Travel_Foly.DAO.TourServiceDAO;
import Travel_Foly.Model.TourSchedule;
import Travel_Foly.Model.TourService;

@Service
public class TourServiceSer {

    @Autowired
    private TourServiceDAO tourServiceDAO;

    public List<TourService> getAllTourServices() {
        return this.tourServiceDAO.findAll();
    }

    public TourService getTourServiceById(Integer TourServiceId) {
        return this.tourServiceDAO.findById(TourServiceId).orElse(null);
    }

    public void SaveTourService(TourService tourService) {
        this.tourServiceDAO.save(tourService);
    }

    public void DeleteTourService(Integer TourServiceId) {
        this.tourServiceDAO.deleteById(TourServiceId);
    }

    public Page<TourService> getAll(Pageable pageable) {
        return this.tourServiceDAO.findAll(pageable);
    }

}
