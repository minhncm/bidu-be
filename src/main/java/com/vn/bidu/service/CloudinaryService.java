package com.vn.bidu.service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CloudinaryService {
    Map uploadFile(MultipartFile file, String folderName);
    Map uploadVideo(MultipartFile file, String folderName);
    String getUrlFile(List<MultipartFile> files, String path);
}
