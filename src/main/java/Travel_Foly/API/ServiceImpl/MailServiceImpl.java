package Travel_Foly.API.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.nimbusds.jose.util.StandardCharset;
import Travel_Foly.API.Service.MailService;
import Travel_Foly.API.Service.ThymeleafInterface;
import Travel_Foly.DTO.InvoiceDTO;
import Travel_Foly.Service.FileUpload;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService{
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	ThymeleafInterface thymeleafService;
	
	private final FileUpload uploadCloundinary;
//	
//	@Autowired
//	OrderDetailTourDAO orderDao;
	
	@Value("${spring.mail.username}")
	private String email;
	
	@Override
	public void sendMailTest() {
		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(
					message, 
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, 
					StandardCharset.UTF_8.name());
			
			helper.setFrom(email);
			helper.setText(thymeleafService.createContent("mail.html", null),true);
			
			helper.setTo("tanduong969@gmail.com");
			helper.setSubject("Mail Test Sender");
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void sendMailWithCustomer(InvoiceDTO dto) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(
					message, 
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, 
					StandardCharset.UTF_8.name()
				);
			
//			String ImageUrl = uploadCloundinary.uploadBase64(dto.getBase64(), dto.getOrderDetailTourId());
//			System.out.println(ImageUrl);
			Map<String,Object> values = new HashMap<>();
			values.put("fullname", dto.getCustomerName());
			values.put("email", dto.getEmail());
			values.put("phone", dto.getPhone());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			values.put("startDate", sdf.format(dto.getStartDate()));
			values.put("endDate", sdf.format(dto.getEndDate()));
			values.put("departure", dto.getDeparture());
			values.put("destination", dto.getDestination());
			values.put("duration", dto.getDuration());
			values.put("priceAdult", dto.getPriceAdult());
			values.put("priceChildren", dto.getPriceChildren());
			values.put("quantityAdult", dto.getQuantityAdult());
			values.put("quantityChildren", dto.getQuantityChildren());
			values.put("base64", dto.getOrderDetailTourId());
			values.put("status", dto.getStatus());
			double total = (dto.getQuantityAdult()*dto.getPriceAdult())+(dto.getQuantityChildren()*dto.getPriceChildren());
			values.put("total", total);
			helper.setTo(dto.getEmail());
			helper.setSubject("TRAVEL FPOLY INFORMATION");
			helper.setText(thymeleafService.createContent("mail.html", values),true);
			helper.setFrom(email);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
