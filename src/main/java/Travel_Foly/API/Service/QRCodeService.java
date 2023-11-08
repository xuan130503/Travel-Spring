package Travel_Foly.API.Service;

import java.io.IOException;


import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public interface QRCodeService {
	BitMatrix generateQRCode(Integer id)throws IOException,WriterException;
}
