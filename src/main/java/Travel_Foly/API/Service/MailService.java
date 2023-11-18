package Travel_Foly.API.Service;

import Travel_Foly.DTO.InvoiceDTO;

public interface MailService {
	void sendMailTest();
	void sendMailWithCustomer(InvoiceDTO invoice);
}
