package Travel_Foly.API.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import Travel_Foly.Model.Tour;

@Component
public interface TourService {

    List<Tour> getListTour();

    void createTour(Tour tour);

    Tour updateTour(Integer TourId);

    void deleteTour(Integer TourId);

}
