package by.ilyukou.service;

import by.ilyukou.service.interfaces.DiskService;
import by.ilyukou.service.interfaces.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {

    final DiskService diskService;

    public UploadServiceImpl(DiskService diskService) {
        this.diskService = diskService;
    }

    @Transactional
    @Override
    public boolean upload(MultipartFile file) {


        String name = file.getName();

        return false;
    }
}
