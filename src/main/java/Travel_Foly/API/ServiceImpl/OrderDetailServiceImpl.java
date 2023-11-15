package Travel_Foly.API.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Travel_Foly.API.Service.OrderDetailService;
import Travel_Foly.DAO.OrderDetailTourDAO;
import Travel_Foly.Model.OrderDetailTour;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailTourDAO orderDetailTourDAO;

    @Override
    public List<OrderDetailTour> getAllOrderDetailTour() {
        return orderDetailTourDAO.findAll();
    }

    @Override
    public OrderDetailTour getOrderDetailTourById(Integer OrderDetailTourId) {
        return orderDetailTourDAO.findById(OrderDetailTourId).orElse(null);
    }

    @Override
    public void addOrderDetailTour(OrderDetailTour orderDetailTour) {
        this.orderDetailTourDAO.save(orderDetailTour);
    }

    @Override
    public void deleteOrderDetaiTour(Integer OrderDetailTourId) {
        this.orderDetailTourDAO.deleteById(OrderDetailTourId);
    }

}
