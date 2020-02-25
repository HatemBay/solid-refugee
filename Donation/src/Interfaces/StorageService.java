package Interfaces;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


public class StorageService {
    private static StorageService instance;
    Cloudinary cloudinary;

    public StorageService() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "tunisiansgottalent",
                "api_key", "724787676593126",
                "api_secret", "RzewQadrcJrKfiBb5MOr0mO8SYI"));
    }
    public static StorageService getInstance() {
        if (instance == null) {
            instance = new StorageService();
        }
        return instance;
    }
    public String upload(File file) throws IOException {
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", UUID.randomUUID().toString())).get("public_id").toString();
    }
    public String download(String fileId) throws IOException {
        return cloudinary.url().generate(fileId);
    }
}
