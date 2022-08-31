package com.wwg.gabozzago.domain.aws.controller;

import com.wwg.gabozzago.domain.aws.data.response.UploadImageResponse;
import com.wwg.gabozzago.global.aws.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/image")

public class ImageResourcesController {
    private final AwsS3Service awsS3Service;

    @PostMapping
    public ResponseEntity<UploadImageResponse> uploadImage(@RequestParam("image") MultipartFile image) {
        List<MultipartFile> images = new ArrayList<>();
        images.add(image);
        List<String> imageNames = awsS3Service.uploadImage(images);
        return ResponseEntity.ok(new UploadImageResponse(imageNames));
    }

}
