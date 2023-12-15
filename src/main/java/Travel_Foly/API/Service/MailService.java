package Travel_Foly.API.Service;

import Travel_Foly.DTO.InvoiceDTO;
import Travel_Foly.DTO.orderHotelDTO;

public interface MailService {
	void sendMailTest();

	void sendMailWithCustomer(InvoiceDTO invoice);

	void sendMailwithCustomerOrderHotel(orderHotelDTO orderHotelDTO);
}
