package Travel_Foly.API.Service;

import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import Travel_Foly.DTO.OrderDetailTourDTO;

public interface paymentService {
	String authorizePayment(OrderDetailTourDTO orderDetail) throws PayPalRESTException;
	Payer getPayerInformation();
	Payment getPaymentDetails(String paymentId) throws PayPalRESTException;
	Payment executePayment(String paymentId, String payerId)throws PayPalRESTException;
}
