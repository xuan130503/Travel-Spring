package Travel_Foly.API.Service;

import java.awt.image.BufferedImage;

import com.google.zxing.common.BitMatrix;

public interface Base64Service {
	String encodeImage(String imgPath, String savePath);

	void decodeImage(String txtPath, String savePath);

	public String endcodeBitMaxtrix(BitMatrix bitMatrix);

	String generateQRCodeAndEncodeToBase64(Integer data);

	String generateQRCodeWithIconAndEncodeToBase64(Integer data);

	String generateQRCodeAndEncodeToBase64Hotel(Integer id);
}
