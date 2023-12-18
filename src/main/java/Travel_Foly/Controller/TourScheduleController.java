package Travel_Foly.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Travel_Foly.Model.TourSchedule;
import Travel_Foly.Service.TourScheduleService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class TourScheduleController {

    @Autowired
    private TourScheduleService tourScheduleService;

    @GetMapping("TourSchedule")
    public String index(Model model,
            @RequestParam(defaultValue = "1") Integer pageNo,
            @Param("keyword") String keyword) {

        Page<TourSchedule> tourSchedules = tourScheduleService.getAll(pageNo);
        if (keyword != null) {
            tourSchedules = this.tourScheduleService.SearchPageTourService(keyword,
                    pageNo);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("tourSchedules", tourSchedules);
        model.addAttribute("tourSchedule", new TourSchedule());
        model.addAttribute("totalPage", tourSchedules.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        return "admin/TourSchedule";
    }

    @PostMapping("Save")
    public String saveTourSchedule(@Valid @ModelAttribute TourSchedule tourSchedule,
            BindingResult result, Model model,
            @RequestParam(defaultValue = "1") Integer pageNo,
            @Param("keyword") String keyword) {
        if (result.hasErrors()) {

            Page<TourSchedule> tourSchedules = tourScheduleService.getAll(pageNo);
            if (keyword != null) {
                tourSchedules = this.tourScheduleService.SearchPageTourService(keyword,
                        pageNo);
                model.addAttribute("keyword", keyword);
            }
            model.addAttribute("tourSchedules", tourSchedules);
            model.addAttribute("totalPage", tourSchedules.getTotalPages());
            model.addAttribute("currentPage", pageNo);
            return "admin/TourSchedule";
        }
        this.tourScheduleService.saveTourSchedule(tourSchedule);

        return "redirect:/travelfpoly/admin/TourSchedule";
    }

    @GetMapping("update/{TourScheduleId}")
    public String update(@PathVariable Integer TourScheduleId, Model model,
            @RequestParam(defaultValue = "1") Integer pageNo,
            @Param("keyword") String keyword) {
        TourSchedule tourSchedule = tourScheduleService.getTourScheduleById(TourScheduleId);
        model.addAttribute("tourSchedule", tourSchedule);
        Page<TourSchedule> tourSchedules = tourScheduleService.getAll(pageNo);
        if (keyword != null) {
            tourSchedules = this.tourScheduleService.SearchPageTourService(keyword,
                    pageNo);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("tourSchedules", tourSchedules);
        model.addAttribute("totalPage", tourSchedules.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        return "admin/TourSchedule";
    }

    @GetMapping("delete/{TourScheduleId}")
    public String UpdateTourSchedule(@PathVariable("TourScheduleId") Integer TourScheduleId) {
        this.tourScheduleService.deleteTourSchedule(TourScheduleId);
        return "redirect:/travelfpoly/admin/TourSchedule";
    }
}
