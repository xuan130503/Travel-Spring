package Travel_Foly.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Travel_Foly.DAO.TourScheduleDAO;
import Travel_Foly.Model.Tour;
import Travel_Foly.Model.TourSchedule;
import Travel_Foly.Model.TourService;

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

    public Page<TourSchedule> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5);
        return this.tourScheduleDAO.findAll(pageable);
    }

    public List<TourSchedule> searchTourSchedule(String keyword) {
        return this.tourScheduleDAO.TourScheduleSearch(keyword);
    }

    public Page<TourSchedule> SearchPageTourService(String keyword, Integer pageNo) {
        List list = this.tourScheduleDAO.TourScheduleSearch(keyword);

        Pageable pageable = PageRequest.of(pageNo - 1, 5);

        Integer start = (int) pageable.getOffset();
        Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
                : pageable.getOffset() + pageable.getPageSize());

        list = list.subList(start, end);

        return new PageImpl<TourSchedule>(list, pageable,
                this.tourScheduleDAO.TourScheduleSearch(keyword).size());
    }

}
