package Travel_Foly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Travel_Foly.Model.Tour;
import Travel_Foly.Model.TourSchedule;
import Travel_Foly.Model.TourService;
import Travel_Foly.Service.TourServiceSer;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class TourServiceController {

    @Autowired
    private TourServiceSer tourServiceSer;

    @GetMapping("TourService")
    public String index(Model model) {
        List<TourService> tourServices = tourServiceSer.getAllTourServices();
        model.addAttribute("tourServices", tourServices);
        model.addAttribute("tourService", new TourService());
        return "admin/TourService";
    }

    @PostMapping("SaveTourService")
    public String SaveTourservice(Model model, @ModelAttribute TourService tourService) {
        this.tourServiceSer.SaveTourService(tourService);
        // return "redirect:/travelfpoly/admin/TourService";
        return "redirect:/travelfpoly/admin/TourService";
    }

    @GetMapping("updateTourService/{TourServiceId}")
    public String UpdateTourService(@PathVariable Integer TourServiceId, Model model) {
        TourService tourService = tourServiceSer.getTourServiceById(TourServiceId);
        model.addAttribute("tourService", tourService);
        List<TourService> tourServices = tourServiceSer.getAllTourServices();
        model.addAttribute("tourServices", tourServices);
        return "admin/TourService";
    }

    @GetMapping("deleteTourService/{TourServiceId}")
    public String DeleteTourService(@PathVariable Integer TourServiceId) {
        this.tourServiceSer.DeleteTourService(TourServiceId);
        return "redirect:/travelfpoly/admin/TourService";
    }
}
