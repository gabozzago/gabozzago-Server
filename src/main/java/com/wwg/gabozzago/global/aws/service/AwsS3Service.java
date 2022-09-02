package com.wwg.gabozzago.global.aws.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AwsS3Service {
    String uploadImage(MultipartFile multipartFile);
    void deleteImage(String fileName);
}
