package com.wwg.gabozzago.domain.aws.controller;

import com.wwg.gabozzago.domain.aws.data.response.UploadImageResponse;
import com.wwg.gabozzago.domain.aws.dto.ImageResponseDto;
import com.wwg.gabozzago.global.aws.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")

public class ImageUploadController {
    private final AwsS3Service awsS3Service;

    @PostMapping
    public ResponseEntity<ImageResponseDto> uploadImage(@RequestParam("image") MultipartFile multipartFile) {
        String imageUrl = awsS3Service.uploadImage(multipartFile);
        return ResponseEntity.ok(new ImageResponseDto(imageUrl));
    }

}
