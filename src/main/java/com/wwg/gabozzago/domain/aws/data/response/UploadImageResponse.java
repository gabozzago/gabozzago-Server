package com.wwg.gabozzago.domain.aws.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class UploadImageResponse {
    private final List<String> data;
}
