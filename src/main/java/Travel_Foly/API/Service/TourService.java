package Travel_Foly.API.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import Travel_Foly.Model.Tour;

@Component
public interface TourService {

    List<Tour> getAllTours();

    Optional<Tour> findByTourId(Integer TourId);

    void saveTour(Tour tour);

    Tour getTourById(Integer TourId);

    void deleteTour(Integer tour);

    // List<Tour> searchTours(String keyword);

    Page<Tour> getAll(Pageable pageable);

}
