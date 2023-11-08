package Travel_Foly.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileUpload {

	private final Cloudinary cloudinary;
	
	public String upload(MultipartFile multipartFile,String folderName)
			throws Exception {

	    Map<String, String> options = new HashMap<>();
	    options.put("public_id", folderName + "/" + UUID.randomUUID());
	    return cloudinary.uploader().upload(multipartFile.getBytes(), options).get("url").toString();
	}
	
	public String uploadBase64(String baseCode, Integer id) throws IOException {
		Map<String, String> options = new HashMap<>();
	    options.put("public_id", "Travel_FPoly/QrTour/" + id);
		return cloudinary.uploader().upload("data:image/png;base64,"+baseCode,options).get("url").toString();
	}
	
	public List<String> upload(List<MultipartFile> imageFiles, String folderName) throws IOException {
	    List<String> imageUrls = new ArrayList<>();

	    for (MultipartFile multipartFile : imageFiles) {
	        Map<String, String> options = new HashMap<>();
	        options.put("public_id", folderName + "/" + UUID.randomUUID());
	        String imageUrl = cloudinary.uploader().upload(multipartFile.getBytes(), options).get("url").toString();
	        imageUrls.add(imageUrl);
	    }

	    return imageUrls;
	}
	
	public void deleteImageOnCloudinary(String publicId) throws IOException {
	    cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
	}
}
