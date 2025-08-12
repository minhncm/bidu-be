package com.vn.bidu.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CloudinaryService {
    Map uploadFile(MultipartFile file, String folderName);
    Map uploadVideo(MultipartFile file, String folderName);
}
