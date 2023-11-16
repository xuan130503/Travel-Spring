package Travel_Foly.API.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import Travel_Foly.Model.Tour;

@Component
public interface TourService {

    List<Tour> getAllTour();

    Tour getTourById(Integer TourId);

    void addTour(Tour tour);

    void deleteTour(Integer TourId);

    Page<Tour> getAll(Integer pageNo);
}
