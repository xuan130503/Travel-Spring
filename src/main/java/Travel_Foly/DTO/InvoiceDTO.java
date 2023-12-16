package Travel_Foly.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {
	private Integer orderDetailTourId;
	private String CustomerName;
	private String Email;
	private String Phone;
	private String TourName;
	private String Departure;
	private String Destination;
	private Integer Duration;
	private Double PriceAdult;
	private Double PriceChildren;
	private Integer QuantityAdult;
	private Integer QuantityChildren;
	private Double Total;
	private Date StartDate;
	private Date EndDate;
	private String Base64;
	private Integer Status;
}
