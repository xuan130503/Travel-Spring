package Travel_Foly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Travel_Foly.Model.Tour;
import Travel_Foly.Model.TourSchedule;
import Travel_Foly.Model.TourService;
import Travel_Foly.Service.TourServiceSer;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class TourServiceController {

    @Autowired
    private TourServiceSer tourServiceSer;

    @GetMapping("TourService")
    public String index(Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer sizeNo) {
        Pageable pageable = PageRequest.of(pageNo, sizeNo);
        Page<TourService> tourServices = tourServiceSer.getAll(pageable);
        model.addAttribute("tourServices", tourServices);
        model.addAttribute("tourService", new TourService());
        return "admin/TourService";
    }

    @PostMapping("SaveTourService")
    public String SaveTourservice(@Valid @ModelAttribute TourService tourService, BindingResult result, Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer sizeNo) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(pageNo, sizeNo);
            Page<TourService> tourServices = tourServiceSer.getAll(pageable);
            model.addAttribute("tourServices", tourServices);
            return "admin/TourService";
        }
        this.tourServiceSer.SaveTourService(tourService);

        return "redirect:/travelfpoly/admin/TourService";
    }

    @GetMapping("updateTourService/{TourServiceId}")
    public String UpdateTourService(@PathVariable Integer TourServiceId, Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer sizeNo) {
        Pageable pageable = PageRequest.of(pageNo, sizeNo);
        TourService tourService = tourServiceSer.getTourServiceById(TourServiceId);
        model.addAttribute("tourService", tourService);
        Page<TourService> tourServices = tourServiceSer.getAll(pageable);
        model.addAttribute("tourServices", tourServices);
        return "admin/TourService";
    }

    @GetMapping("deleteTourService/{TourServiceId}")
    public String DeleteTourService(@PathVariable Integer TourServiceId) {
        this.tourServiceSer.DeleteTourService(TourServiceId);
        return "redirect:/travelfpoly/admin/TourService";
    }
}
