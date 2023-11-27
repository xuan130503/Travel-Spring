package Travel_Foly.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

import Travel_Foly.API.Service.MailService;
import Travel_Foly.API.Service.paymentService;
import Travel_Foly.DAO.OrderDetailTourDAO;
import Travel_Foly.DTO.InvoiceDTO;
import Travel_Foly.DTO.OrderDetailTourDTO;
import Travel_Foly.Model.OrderDetailTour;
import Travel_Foly.Service.SessionService;

@Controller
@RequestMapping("/travelfpoly/payment/")
public class PaymentController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionService session;
	@Autowired
	paymentService paymentService;
	
	@Autowired
	private OrderDetailTourDAO orderDetailTourDao;
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("index")
	public String index(@RequestParam("id") Integer id, Model model) {
		InvoiceDTO invoice = orderDetailTourDao.detailInvoice(id);
		
		Double total = (invoice.getPriceAdult()*invoice.getQuantityAdult())+(invoice.getPriceChildren()*invoice.getQuantityChildren());
		model.addAttribute("name", invoice.getDestination());
		model.addAttribute("total", total);
		session.setAttribute("tourId", invoice.getOrderDetailTourId());
		return "user/payment";
	}
	@GetMapping("listOrder")
	public String listOrder(@RequestParam("listOrderId") List<Integer> listOrderId, Model model) {
		StringBuilder nameBuilder = new StringBuilder();
		Double total=0.0;
		for(Integer index :listOrderId) {
			InvoiceDTO invoice = orderDetailTourDao.detailInvoice(index);
			total += (invoice.getPriceAdult()*invoice.getQuantityAdult())+(invoice.getPriceChildren()*invoice.getQuantityChildren());
			 if (nameBuilder.length() > 0) {
		            nameBuilder.append("-");
		        }
		        nameBuilder.append(invoice.getDestination());
		}
		System.out.println("Total:"+total);
		System.out.println("Name"+nameBuilder);
		model.addAttribute("name", nameBuilder.toString());
		model.addAttribute("total", total);
		session.setAttribute("tourId", listOrderId);
		return "user/payment";
	}
	@GetMapping("review_payment")
	public String review_payment(Model model, 
			@RequestParam("paymentId") String paymentId, 
			@RequestParam("token") String token, 
			@RequestParam("PayerID") String payerId) {
		
        try {
            Payment payment = paymentService.getPaymentDetails(paymentId);
             
            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
            ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
             
            model.addAttribute("payer", payerInfo);
            model.addAttribute("transaction", transaction);
            model.addAttribute("shippingAddress", shippingAddress);
            model.addAttribute("paymentId", paymentId);
            model.addAttribute("payerId", payerId);
            session.setAttribute("paymentId", paymentId);
            session.setAttribute("payerId", payerId);
            System.out.println(payerInfo);
            System.out.println(transaction);
            System.out.println(shippingAddress);
            System.out.println(paymentId);
            System.out.println(payerId);
            return "user/reviewPayment";
        } catch (PayPalRESTException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            return null;
        }      
    }
	@PostMapping("authorize_payment")
	public String checkout(Model model, 
				@RequestParam("product") String product,
				@RequestParam("subtotal") String subtotal,
				@RequestParam("shipping") String shipping,
				@RequestParam("tax") String tax,
				@RequestParam("total") String total
			) {
		OrderDetailTourDTO orderDetail = new OrderDetailTourDTO(product, subtotal, shipping, tax, total);
		try {
            String approvalLink = paymentService.authorizePayment(orderDetail);
 
            return "redirect:"+approvalLink;
             
        } catch (PayPalRESTException ex) {
        	model.addAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            return "user/error";
        }
		
	}
	@PostMapping("execute_payment")
	public String excutePayment(Model model) {
		
		String paymentId = session.getAttribute("paymentId");
		String payerId = session.getAttribute("payerId");
		
		System.out.println("PaymentId:"+paymentId);
		System.out.println("PayerId:"+payerId);
		//send mail
		List<Integer> id =session.getAttribute("tourId");
		for(Integer index : id) {
			OrderDetailTour order = orderDetailTourDao.findByOrderDetailTourId(index);
			order.setStatus(2);
			orderDetailTourDao.save(order);
			InvoiceDTO invoice = orderDetailTourDao.detailInvoice(index);
			mailService.sendMailWithCustomer(invoice);
		}
        try {
            Payment payment = paymentService.executePayment(paymentId, payerId);
             
            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
             
            model.addAttribute("payer", payerInfo);
            model.addAttribute("transaction", transaction);          
 
            return "user/receipt";
             
        } catch (PayPalRESTException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            return "user/error";
        }
	}
}
