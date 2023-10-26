package Travel_Foly.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Travel_Foly.API.Service.TourService;
import Travel_Foly.Model.Tour;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("tour")
    public String index(Model model) {
        model.addAttribute("getListTour", tourService.getListTour());
        return "admin/form-add-san-pham";
    }

    @GetMapping("show")
    public String showtour(Model model) {
        Tour tour = new Tour();
        model.addAttribute("tour", tour);
        return "admin/tour/form-add-tour";
    }

    @PostMapping("createTour")
    public String createTour(@ModelAttribute(value = "tour") Tour tour) {
        this.tourService.createTour(tour);
        return "redirect:/travelfpoly/admin/tour";
    }

    @GetMapping("updateTour/{TourId}")
    public String updateTour(@PathVariable("TourId") Integer TourId, Model model) {
        Tour tour = tourService.updateTour(TourId);
        model.addAttribute("tour", tour);
        return "admin/tour/form-add-tour";
    }

    @GetMapping("deleteTour/{TourId}")
    public String deleteTour(@PathVariable("TourId") Integer TourId) {
        this.tourService.deleteTour(TourId);
        return "redirect:/travelfpoly/admin/tour";
    }

}
