package Travel_Foly.API.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import Travel_Foly.API.Service.paymentService;
import Travel_Foly.DTO.OrderDetailTourDTO;
//import Travel_Foly.Model.OrderDetailTour;

@Service
public class paymentServiceImpl implements paymentService{
//  AdnW78R-tUIGj5Jd8Rkt_dAkOF1e0eyUaYUn2pqE6sWKm6geDx4fotS9nfee3xIKqhfpOSXneeyyAmyo
	private static final String CLIENT_ID="AeRpO0g4Kk_keDh6jDLNQOd32QBuw-a56wTtjcZ74_Z1toV8P6BQCDn2b2wWimJ1QfaN4jJQsfTJSlsO";
//	EDm9UZ_MBfipBzCkcuIQox5RWkc4uyISL8WKDjxelH2VDOFjMiKF6jNitkBhLbHdNTXLXC4t8x5A8Vqh
	private static final String CLIENT_SECRET="EH2srCMawkNLARvmvyAd8bnr9rlGLrxHJ9XKNWg0PdgkqEAql5BCbforWNS_g2ww_c6FmHP9SC9UWd1x";
	private static final String MODE = "live";
	@Override
	public String authorizePayment(OrderDetailTourDTO orderDetail) throws PayPalRESTException {       
 
        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);
         
        Payment requestPayment = new Payment();
        requestPayment
        	.setTransactions(listTransaction)
			.setRedirectUrls(redirectUrls)
			.setPayer(payer)
			.setIntent("authorize");
 
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
 
        Payment approvedPayment = requestPayment.create(apiContext);
        System.out.println(getApprovalLink(approvedPayment));
        
        return getApprovalLink(approvedPayment);
 
    }
	@Override
	public Payer getPayerInformation() {
	    Payer payer = new Payer();
	    payer.setPaymentMethod("paypal");
	     
	    PayerInfo payerInfo = new PayerInfo();
	    payerInfo.setFirstName("Tan")
	             .setLastName("Duong")
	             .setEmail("tanduong969@gmail.com");
	     
	    payer.setPayerInfo(payerInfo);
	     
	    return payer;
	}
	@Override
	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
		return Payment.get(apiContext, paymentId);
	}
	@Override
	public Payment executePayment(String paymentId, String payerId)
	        throws PayPalRESTException {
	    PaymentExecution paymentExecution = new PaymentExecution();
	    paymentExecution.setPayerId(payerId);
	 
	    Payment payment = new Payment().setId(paymentId);
	 
	    APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
	 
	    return payment.execute(apiContext, paymentExecution);
	}
	private RedirectUrls getRedirectURLs() {
	    RedirectUrls redirectUrls = new RedirectUrls();
	    redirectUrls.setCancelUrl("http://localhost:8080/PaypalTest/cancel.html");
	    redirectUrls.setReturnUrl("http://localhost:8080/travelfpoly/payment/review_payment");
	     
	    return redirectUrls;
	}
	private List<Transaction> getTransactionInformation(OrderDetailTourDTO orderDetail) {
	    Details details = new Details();
	    details.setShipping(orderDetail.getShipping());
	    details.setSubtotal(orderDetail.getSubtotal());
	    details.setTax(orderDetail.getTax());
	 
	    Amount amount = new Amount();
	    amount.setCurrency("USD");
	    amount.setTotal(orderDetail.getTotal());
	    amount.setDetails(details);
	 
	    Transaction transaction = new Transaction();
	    transaction.setAmount(amount);
	    transaction.setDescription(orderDetail.getProductName());
	     
	    ItemList itemList = new ItemList();
	    List<Item> items = new ArrayList<>();
	     
	    Item item = new Item();
	    item.setCurrency("USD");
	    item.setName(orderDetail.getProductName());
	    item.setPrice(orderDetail.getSubtotal());
	    item.setTax(orderDetail.getTax());
	    item.setQuantity("1");
	    items.add(item);
	    itemList.setItems(items);
	    transaction.setItemList(itemList);
	 
	    List<Transaction> listTransaction = new ArrayList<>();
	    listTransaction.add(transaction);  
	     
	    return listTransaction;
	}
	private String getApprovalLink(Payment approvedPayment) {
	    List<Links> links = approvedPayment.getLinks();
	    String approvalLink = null;
	     
	    for (Links link : links) {
	        if (link.getRel().equalsIgnoreCase("approval_url")) {
	            approvalLink = link.getHref();
	            break;
	        }
	    }      
	     
	    return approvalLink;
	}
	
}
