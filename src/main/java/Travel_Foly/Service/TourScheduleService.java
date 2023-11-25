package Travel_Foly.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Travel_Foly.DAO.TourScheduleDAO;
import Travel_Foly.Model.TourSchedule;

@Service
public class TourScheduleService {

    @Autowired
    private TourScheduleDAO tourScheduleDAO;

    public List<TourSchedule> getAllTourSchedules() {
        return this.tourScheduleDAO.findAll();
    }

    public TourSchedule getTourScheduleById(Integer TourScheduleId) {

        return tourScheduleDAO.findById(TourScheduleId).orElse(null);
    }

    public void saveTourSchedule(TourSchedule tourSchedule) {
        this.tourScheduleDAO.save(tourSchedule);
    }

    public void deleteTourSchedule(Integer TourScheduleId) {
        this.tourScheduleDAO.deleteById(TourScheduleId);
    }

}
