package Travel_Foly.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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

    public Page<TourService> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5);
        return this.tourServiceDAO.findAll(pageable);
    }

    public List<TourService> searchTourService(String keyword) {
        return this.tourServiceDAO.searchTourSearch(keyword);
    }

    public Page<TourService> SearchPageTourService(String keyword, Integer pageNo) {
        List list = this.tourServiceDAO.searchTourSearch(keyword);

        Pageable pageable = PageRequest.of(pageNo - 1, 5);

        Integer start = (int) pageable.getOffset();
        Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
                : pageable.getOffset() + pageable.getPageSize());

        list = list.subList(start, end);

        return new PageImpl<TourService>(list, pageable,
                this.tourServiceDAO.searchTourSearch(keyword).size());
    }

}
