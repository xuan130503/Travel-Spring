package Travel_Foly.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Travel_Foly.DAO.HotelDAO;
import Travel_Foly.Model.Hotel;
import Travel_Foly.Model.TourService;

@Service
public class HotelService {
    @Autowired
    private HotelDAO hotelDAO;

    public List<Hotel> getAllHotel() {
        return hotelDAO.findAll();
    }

    public Hotel getHotelById(Integer HotelId) {
        return hotelDAO.findById(HotelId).orElse(null);
    }

    public void addHotel(Hotel hotel) {
        this.hotelDAO.save(hotel);
    }

    public void deleteHotel(Integer HotelId) {
        this.hotelDAO.deleteById(HotelId);
    }

    public Page<Hotel> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5);
        return this.hotelDAO.findAll(pageable);
    }

    public List<Hotel> searchTourService(String keyword) {
        return this.hotelDAO.HotelSearch(keyword);
    }

    public Page<Hotel> SearchPageTourService(String keyword, Integer pageNo) {
        List list = this.hotelDAO.HotelSearch(keyword);

        Pageable pageable = PageRequest.of(pageNo - 1, 5);

        Integer start = (int) pageable.getOffset();
        Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
                : pageable.getOffset() + pageable.getPageSize());

        list = list.subList(start, end);

        return new PageImpl<Hotel>(list, pageable,
                this.hotelDAO.HotelSearch(keyword).size());
    }
}
