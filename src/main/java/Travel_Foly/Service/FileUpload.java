package Travel_Foly.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

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

}
