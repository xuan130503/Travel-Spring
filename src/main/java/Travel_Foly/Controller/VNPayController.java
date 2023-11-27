package Travel_Foly.Controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Travel_Foly.API.Service.MailService;
import Travel_Foly.Config.VNPayConfig;
import Travel_Foly.DAO.OrderDetailTourDAO;
import Travel_Foly.DTO.InvoiceDTO;
import Travel_Foly.Model.OrderDetailTour;
import Travel_Foly.Service.SessionService;

@Controller

@RequestMapping("/travelfpoly/payment/vnpay/")
public class VNPayController {
	@Autowired
	SessionService session;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	OrderDetailTourDAO orderDetailTourDao;
	
	@GetMapping("/pay")
	public void getPay(@RequestParam("id") Integer id, HttpServletResponse response) throws IOException{
		InvoiceDTO invoice = orderDetailTourDao.detailInvoice(id);
		List<Integer> invoiceId = new ArrayList<>();
		invoiceId.add(id);
		session.setAttribute("invoiceId", invoiceId);
		Double total = (invoice.getPriceAdult()*invoice.getQuantityAdult())+(invoice.getPriceChildren()*invoice.getQuantityChildren());
        long amount =(long)(total*24000*100);
        // 100.000.000 1*24.000*100
        String bankCode = "NCB";
        String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";
        String vnp_TmnCode = VNPayConfig.vnp_TmnCode;
        
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", VNPayConfig.vnp_Version);
        vnp_Params.put("vnp_Command", VNPayConfig.vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        
        vnp_Params.put("vnp_BankCode", bankCode);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", VNPayConfig.orderType);

        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
		
        response.sendRedirect(paymentUrl);
	}
	//vnp_Amount=10000000&vnp_BankCode=NCB&vnp_BankTranNo=VNP14179315&vnp_CardType=ATM&vnp_OrderInfo=Thanh+toan+don+hang%3A99483234
	//&vnp_PayDate=20231113231943&vnp_ResponseCode=00&vnp_TmnCode=4LG073UH&vnp_TransactionNo=14179315&vnp_TransactionStatus=00&vnp_TxnRef=99483234
	//&vnp_SecureHash=934cb07dd88498a5ea5dae09ccf929a605b056b16e85c369c2bb60628a699a209d004f63e98e3a23012c1a91941a40511d383333867ff343b6aee6caca8b0109
	@GetMapping("/paylist")
	public void getPayList(@RequestParam("listOrderId") List<Integer> listOrderId, HttpServletResponse response) throws IOException{
		Double total=0.0;
		for(Integer index :listOrderId) {
			InvoiceDTO invoice = orderDetailTourDao.detailInvoice(index);
			total += (invoice.getPriceAdult()*invoice.getQuantityAdult())+(invoice.getPriceChildren()*invoice.getQuantityChildren());
		}
		session.setAttribute("invoiceId", listOrderId);
        long amount =(long)(total*24000*100);
        // 100.000.000 1*24.000*100
        String bankCode = "NCB";
        String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";
        String vnp_TmnCode = VNPayConfig.vnp_TmnCode;
        
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", VNPayConfig.vnp_Version);
        vnp_Params.put("vnp_Command", VNPayConfig.vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        
        vnp_Params.put("vnp_BankCode", bankCode);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", VNPayConfig.orderType);

        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
		
        response.sendRedirect(paymentUrl);
	}
	@GetMapping("/return")
	public String paymentReturn(Model model,
				@RequestParam("vnp_Amount") Long mount,
				@RequestParam("vnp_BankCode") String nameBank,
				@RequestParam("vnp_BankTranNo") String bankNo,
				@RequestParam("vnp_CardType") String cartType,
				@RequestParam("vnp_OrderInfo") String orderInfo,
				@RequestParam("vnp_PayDate") String payDate,
				@RequestParam("vnp_TransactionStatus") String status
			) {
		List<Integer> id =session.getAttribute("invoiceId");
		for(Integer index : id) {
			OrderDetailTour order = orderDetailTourDao.findByOrderDetailTourId(index);
			order.setStatus(2);
			orderDetailTourDao.save(order);
			InvoiceDTO invoice = orderDetailTourDao.detailInvoice(index);
			mailService.sendMailWithCustomer(invoice);
		}
		
		return "redirect:/travelfpoly/payment/vnpay/getinfor?mount="+mount+"&status="+status+"&payDate="+payDate;
		
	}
	@GetMapping("getinfor")
	public String getInforReturn(Model model,
				@RequestParam("mount") Long mount,
				@RequestParam("status") String status,
				@RequestParam("payDate") String payDate
			) {
			model.addAttribute("mount",  mount);
			model.addAttribute("status", status);
			model.addAttribute("payDate", payDate);
		return "user/vnpayInvoice";
	}
}
