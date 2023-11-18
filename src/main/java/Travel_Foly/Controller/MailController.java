package Travel_Foly.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Travel_Foly.API.Service.MailService;
import Travel_Foly.DAO.OrderDetailTourDAO;
import Travel_Foly.DTO.InvoiceDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/travelfpoly/mailtest")
@RequiredArgsConstructor
public class MailController {
	
	@Autowired
	private OrderDetailTourDAO orderDetailDao; 
	
	private final MailService mailService;
	
	@GetMapping("/sendmail")
	public String sendMail() {
		mailService.sendMailTest();
		return "Success";
	}
	@GetMapping("/sendmailcustomer")
	public String sendMailWithCustomer() {
		InvoiceDTO invoice = new InvoiceDTO();
		invoice = orderDetailDao.detailInvoice(4);
		System.out.println(invoice);
		mailService.sendMailWithCustomer(invoice);
		return "Success";
	}
}
