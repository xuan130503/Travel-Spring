package Travel_Foly.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Travel_Foly.Model.TourSchedule;
import Travel_Foly.Service.TourScheduleService;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class TourScheduleController {

    @Autowired
    private TourScheduleService tourScheduleService;

    @GetMapping("TourSchedule")
    public String index(Model model) {
        List<TourSchedule> tourSchedules = tourScheduleService.getAllTourSchedules();
        model.addAttribute("tourSchedules", tourSchedules);
        model.addAttribute("tourSchedule", new TourSchedule());
        return "admin/TourSchedule";
    }

    @PostMapping("Save")
    public String saveTourSchedule(Model model, @ModelAttribute TourSchedule tourSchedule) {
        this.tourScheduleService.saveTourSchedule(tourSchedule);
        return "redirect:/travelfpoly/admin/TourSchedule";
    }

    @GetMapping("update/{TourScheduleId}")
    public String update(@PathVariable Integer TourScheduleId, Model model) {
        TourSchedule tourSchedule = tourScheduleService.getTourScheduleById(TourScheduleId);
        model.addAttribute("tourSchedule", tourSchedule);
        List<TourSchedule> tourSchedules = tourScheduleService.getAllTourSchedules();
        model.addAttribute("tourSchedules", tourSchedules);
        return "admin/TourSchedule";
    }

    @GetMapping("delete/{TourScheduleId}")
    public String UpdateTourSchedule(@PathVariable("TourScheduleId") Integer TourScheduleId) {
        this.tourScheduleService.deleteTourSchedule(TourScheduleId);
        return "redirect:/travelfpoly/admin/TourSchedule";
    }
}
