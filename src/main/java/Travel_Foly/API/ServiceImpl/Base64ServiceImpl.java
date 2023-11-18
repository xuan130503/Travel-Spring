package Travel_Foly.API.ServiceImpl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import Travel_Foly.API.Service.Base64Service;
import Travel_Foly.Service.FileUpload;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Base64ServiceImpl implements Base64Service{
	private final Cloudinary cloudinary;
	@Override
	public String encodeImage(String imgPath, String savePath) {
		try {
			FileInputStream stream = new FileInputStream(imgPath);
	        int bufLength = 2048;
	        byte[] buffer = new byte[2048];
	
	        byte[] data;
	
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        int readLength;
	        while ((readLength = stream.read(buffer, 0, bufLength)) != -1) {
	            out.write(buffer, 0, readLength);
	        }
	
	        data = out.toByteArray();
	
	        String imageString = Base64.getEncoder().encodeToString(data);
	
	        FileWriter fileWriter = new FileWriter(savePath);
	
	        fileWriter.write(imageString);
	
	        // close streams
	        fileWriter.close();
	        out.close();
	        stream.close();
	        return imageString;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}

	@Override
	public void decodeImage(String txtPath, String savePath) {
		try {
			FileInputStream inputStream = new FileInputStream(txtPath);

	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        int len = 2048;
	        byte[] buffer = new byte[len];
	        byte[] textData;
	        int readLength;

	        while ((readLength = inputStream.read(buffer, 0, len)) != -1) {
	            out.write(buffer, 0, readLength);
	        }

	        textData = out.toByteArray();


	        byte[] data = Base64.getDecoder().decode(new String(textData));

	        // Base64.getDecoder().decode(inputStream.readAllBytes());

	        FileOutputStream fileOutputStream = new FileOutputStream(savePath);

	        // write array of bytes to an image file
	        fileOutputStream.write(data);
	        out.close();
	        // close streams
	        fileOutputStream.close();
	        inputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String endcodeBitMaxtrix(BitMatrix bitMatrix) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] imageBytes = outputStream.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
	}
	@Override
	public String generateQRCodeAndEncodeToBase64(Integer data) {
		try {
            // Tạo đối tượng QRCodeWriter
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            // Thiết lập các thông số cho mã QR
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            // Tạo BitMatrix từ dữ liệu
            BitMatrix bitMatrix = qrCodeWriter.encode(String.valueOf(data), BarcodeFormat.QR_CODE, 200, 200, hints);

            // Tạo mảng byte từ BitMatrix
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            byte[] imageBytes = outputStream.toByteArray();
            
            //push image to cloudinary
            Map<String, String> options = new HashMap<>();
            options.put("public_id", "Travel_FPoly/QrTour/" + data);
            cloudinary.uploader().upload(imageBytes, options);
            
            
            // decoder byte[] to base64
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            
            
            
            return base64Image;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public String generateQRCodeWithIconAndEncodeToBase64(Integer data) {
		try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            
            BitMatrix bitMatrix = qrCodeWriter.encode(String.valueOf(data), BarcodeFormat.QR_CODE, 200, 200, hints);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            BufferedImage qrImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = qrImage.createGraphics();

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    qrImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
            
            ClassPathResource iconResource = new ClassPathResource("/static/user/images/bee_small.png");
            BufferedImage iconImage = ImageIO.read(iconResource.getInputStream());

            int iconWidth = iconImage.getWidth();
            int iconHeight = iconImage.getHeight();
            int x = (width - iconWidth) / 2;
            int y = (height - iconHeight) / 2;

            graphics.drawImage(iconImage, x, y, null);
            graphics.dispose();

            // Mã hóa hình ảnh thành chuỗi Base64
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(qrImage, "png", outputStream);
            byte[] qrCodeBytes = outputStream.toByteArray();
            
            Map<String, String> options = new HashMap<>();
            options.put("public_id", "Travel_FPoly/QrTour/" + data);
            cloudinary.uploader().upload(qrCodeBytes, options);
            
            return Base64.getEncoder().encodeToString(qrCodeBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
