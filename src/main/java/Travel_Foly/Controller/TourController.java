package Travel_Foly.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
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
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import Travel_Foly.API.Service.TourService;
import Travel_Foly.DAO.TourImageDAO;
import Travel_Foly.Model.Tour;
import Travel_Foly.Model.TourImage;
import Travel_Foly.Service.FileUpload;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class TourController {
	
	@Autowired
	private FileUpload cloud;
	
    @Autowired
    private TourService tourService;
    
    @Autowired
    private TourImageDAO tourImageDao;
    
    @GetMapping("tour")
    public String index(Model model, @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer sizeNo) {
        Pageable pageable = PageRequest.of(pageNo, sizeNo);
        Page<Tour> list = tourService.getAll(pageable);
        // List<Tour> list = tourService.getAllTours();
        model.addAttribute("tours", list);
        model.addAttribute("tour", new Tour());
        // model.addAttribute("totalPage", list.getTotalPages());
        // model.addAttribute("currenPage", pageNo);
        return "admin/form-add-san-pham";
    }

    @PostMapping("save")
    public String saveTour(@Valid @ModelAttribute Tour tour, BindingResult result, Model model,
            @RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "5") Integer sizeNo,
            @RequestParam("image1") MultipartFile image1) throws Exception {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(pageNo, sizeNo);
            Page<Tour> tours = tourService.getAll(pageable);
            model.addAttribute("tours", tours);
            return "admin/form-add-san-pham";
        }
      //push image to cloudinary
        this.tourService.saveTour(tour);
        String img = cloud.uploadWithName(image1, tour.getName(), "avatar");
        TourImage tourImage = new TourImage();
        tourImage.setAvatar(img);
        tourImage.setTourImage(tour);
        this.tourImageDao.save(tourImage);
        
        return "redirect:/travelfpoly/admin/tour";

    }

    @GetMapping("updateTour/{TourId}")
    public String updateTour(@PathVariable("TourId") Integer TourId, Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer sizeNo) {
        Pageable pageable = PageRequest.of(pageNo, sizeNo);

        Optional<Tour> optionalTour = tourService.findByTourId(TourId);
        if (optionalTour.isPresent()) {
            model.addAttribute("tour", optionalTour.get());
        } else {
            model.addAttribute("tour", new Tour());
        }
        Page<Tour> tours = tourService.getAll(pageable);
        model.addAttribute("tours", tours);
        return "admin/form-add-san-pham";
    }

    @GetMapping("deleteTour/{TourId}")
    public String deleteTour(@PathVariable("TourId") Integer TourId) {
        this.tourService.deleteTour(TourId);
        return "redirect:/travelfpoly/admin/tour";

    }
}