package Travel_Foly.DTO;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderHotelDTO {
    private Integer OrderDetailHotelId;
    private String NameHotel;
    private Date CheckIn;
    private Date CheckOut;
    private Integer Quantity;
    private Double Price;
    private Integer Status;
    private Date BookDate;
    private String Name;
    private String Email;
    private String Phone;

    private Double total;
}
