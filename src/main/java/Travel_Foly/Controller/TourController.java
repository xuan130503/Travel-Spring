package Travel_Foly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Travel_Foly.API.Service.TourService;
import Travel_Foly.Model.Tour;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("Tour")
    public String index(Model model, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        Page<Tour> tours = tourService.getAll(pageNo);
        model.addAttribute("totalPage", tours.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("tours", tours);
        model.addAttribute("tour", new Tour());
        return "admin/form-add-san-pham";
    }

    @PostMapping("addTour")
    public String addTour(@ModelAttribute Tour tour) {
        tourService.addTour(tour);
        return "redirect:/travelfpoly/admin/Tour";
    }

    @GetMapping("edit/{TourId}")
    public String editTour(@PathVariable Integer TourId, Model model) {
        Tour tour = tourService.getTourById(TourId);
        model.addAttribute("tour", tour);
        List<Tour> tours = tourService.getAllTour();
        model.addAttribute("tours", tours);
        return "admin/form-add-san-pham";
    }

    @GetMapping("delete/{TourId}")
    public String deleteTour(@PathVariable Integer TourId) {
        tourService.deleteTour(TourId);
        return "redirect:/travelfpoly/admin/Tour";
    }
}
