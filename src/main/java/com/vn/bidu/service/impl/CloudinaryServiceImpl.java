package com.vn.bidu.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vn.bidu.constant.CloudPath;
import com.vn.bidu.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    @Override
    public Map uploadFile(MultipartFile file, String folderName){
        try {
            return cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap("folder", folderName));
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Map uploadVideo(MultipartFile file, String folderName){
        try {
            return cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap(
                            "resource_type", "video",
                            "folder", folderName)
            );
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String getUrlFile(List<MultipartFile> files, String path) {
        List<String> urls = new ArrayList<>();
        for (MultipartFile file : files) {
            Map cloud = uploadFile(file, path);
            urls.add((String) cloud.get("url"));
        }

        return String.join(", ", urls);
    }


}
