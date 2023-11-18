package Travel_Foly.API.Service;

import java.util.List;

import Travel_Foly.Model.OrderDetailTour;

public interface OrderDetailService {

    List<OrderDetailTour> getAllOrderDetailTour();

    OrderDetailTour getOrderDetailTourById(Integer OrderDetailTourId);

    void addOrderDetailTour(OrderDetailTour orderDetailTour);

    void deleteOrderDetaiTour(Integer OrderDetailTourId);
}