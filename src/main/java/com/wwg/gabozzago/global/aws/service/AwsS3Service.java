package com.wwg.gabozzago.global.aws.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AwsS3Service {
    List<String> uploadImage(List<MultipartFile> multipartFile);
    void deleteImage(String fileName);
}
