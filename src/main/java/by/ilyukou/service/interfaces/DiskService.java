package by.ilyukou.service.interfaces;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface DiskService {
    String storeFile(MultipartFile file);
    boolean save(InputStream inputStream, long idFile);
    boolean save(InputStream inputStream, String filename);
    Resource loadFileAsResource(String fileName);
    Resource getByFileId(Long id);
    InputStream getFileInputStream(Long id);
}
