package Travel_Foly.API.ServiceImpl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import Travel_Foly.API.Service.QRCodeService;

@Service
public class QRCodeServiceImpl implements QRCodeService{
	
	@Override
	public BitMatrix generateQRCode(Integer id) throws IOException, WriterException {
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(String.valueOf(id), BarcodeFormat.QR_CODE, 400, 400);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", null);
        return bitMatrix;
	}

}
