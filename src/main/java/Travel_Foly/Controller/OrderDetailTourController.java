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

import Travel_Foly.API.Service.OrderDetailService;
import Travel_Foly.Model.OrderDetailTour;

@Controller
@RequestMapping("/travelfpoly/admin/")
public class OrderDetailTourController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("orderDetailTour")
    public String index(Model model) {
        List<OrderDetailTour> orderDetailTours = orderDetailService.getAllOrderDetailTour();
        model.addAttribute("orderDetailTours", orderDetailTours);
        model.addAttribute("orderDetailTour", orderDetailTours);
        return "admin/form-add-don-hang";

    }

    @PostMapping("addOrderDetailTour")
    public String addOrderDetailTour(@ModelAttribute OrderDetailTour orderDetailTour) {
        orderDetailService.addOrderDetailTour(orderDetailTour);
        return "redirect:/travelfpoly/admin/orderDetailTour";
    }

    @PostMapping("editOrderdetailTour/{OrderDetailTourId}")
    public String editOrderDetail(@PathVariable Integer OrderDetailTourId, Model model) {
        OrderDetailTour orderDetailTour = orderDetailService.getOrderDetailTourById(OrderDetailTourId);
        model.addAttribute("orderDetailTour", orderDetailTour);
        List<OrderDetailTour> orderDetailTours = orderDetailService.getAllOrderDetailTour();
        model.addAttribute("orderDetailTours", orderDetailTours);
        return "redirect:/travelfpoly/admin/orderDetailTour";
    }

    @PostMapping("deleteOrderDetailTour/{OrderDetailTourId}")
    public String deleteOrdertailTour(@PathVariable Integer OrderDetailTourId) {
        orderDetailService.deleteOrderDetaiTour(OrderDetailTourId);
        return "redirect:/travelfpoly/admin/orderDetailTour";
    }

}
