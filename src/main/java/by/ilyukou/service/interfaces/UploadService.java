package by.ilyukou.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    boolean upload(MultipartFile file);
}
