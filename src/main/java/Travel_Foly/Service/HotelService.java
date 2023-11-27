package Travel_Foly.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Travel_Foly.DAO.HotelDAO;
import Travel_Foly.Model.Hotel;

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

}
