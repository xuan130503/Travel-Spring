package Travel_Foly.API.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import Travel_Foly.Model.Tour;

@Component
public interface TourService {

    List<Tour> getAllTours();
    Tour findByTourId(Integer TourId);

    void saveTour(Tour tour);

    Tour getTourById(Integer TourId);

    void deleteTour(Integer tour);

    // List<Tour> searchTour(String keyword);

}
