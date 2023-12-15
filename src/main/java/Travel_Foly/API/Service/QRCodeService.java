package Travel_Foly.API.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import Travel_Foly.DTO.orderHotelDTO;

public interface QRCodeService {
	BitMatrix generateQRCode(Integer id) throws IOException, WriterException;

}
